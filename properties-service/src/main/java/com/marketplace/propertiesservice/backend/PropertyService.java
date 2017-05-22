package com.marketplace.propertiesservice.backend;

import com.marketplace.propertiesservice.model.Contract;
import com.marketplace.propertiesservice.model.Property;
import com.marketplace.propertiesservice.search.Range;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;
    private MongoTemplate mongoTemplate;
    private RabbitTemplate rabbitTemplate;
    private TopicExchange topicExchange;
    private Queue queue;

    public PropertyService(PropertyRepository propertyRepository, MongoTemplate mongoTemplate,
                           RabbitTemplate rabbitTemplate, TopicExchange topicExchange, Queue queue) {
        this.propertyRepository = propertyRepository;
        this.mongoTemplate = mongoTemplate;
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
        this.queue = queue;
    }

    /**
     *
     * @param bedrooms Range of bedrooms
     * @param prices Range of prices
     * @param contractType Contract type, ie. "rental", "sale"
     * @return properties matching the criteria
     */
    public List<Property> find(Range<Optional<Integer>> bedrooms,
                               Range<Optional<BigDecimal>> prices,
                               Optional<Contract.Type> contractType) {
        List<Criteria> criteria = new ArrayList<>();
        if (bedrooms.getMin().isPresent()) {
            criteria.add(Criteria.where("bedrooms").gte(bedrooms.getMin().get()));
        }
        if (bedrooms.getMax().isPresent()) {
            criteria.add(Criteria.where("bedrooms").lte(bedrooms.getMax().get()));
        }
        if (prices.getMin().isPresent()) {
            criteria.add(Criteria.where("price.value").gte(prices.getMin().get()));
        }
        if (prices.getMax().isPresent()) {
            criteria.add(Criteria.where("price.value").lte(prices.getMax().get()));
        }
        if (contractType.isPresent()) {
            criteria.add(Criteria.where("contract.type").is(contractType.get().name()));
        }
        if (!criteria.isEmpty()) {
            Criteria and = new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()]));
            return mongoTemplate.find(Query.query(and), Property.class);
        } else {
            return mongoTemplate.findAll(Property.class);
        }
    }

    public Property create(Property property) {
        propertyRepository.save(property);
        rabbitTemplate.convertAndSend(topicExchange.getName(), queue.getName(), property);
        return property;
    }

    public Property get(String propertyId) {
        return propertyRepository.findOne(propertyId);
    }

    public Property update(Property property) {
        return propertyRepository.save(property);
    }

    public void delete(String propertyId) {
        propertyRepository.delete(propertyId);
    }
}
