package com.marketplace.propertiesservice.backend;

import com.marketplace.propertiesservice.model.Contract;
import com.marketplace.propertiesservice.model.Search;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    private SearchRepository searchRepository;
    private MongoTemplate mongoTemplate;

    public SearchService(SearchRepository searchRepository, MongoTemplate mongoTemplate) {
        this.searchRepository = searchRepository;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     *
     * @param bedrooms Optional number of bedrooms
     * @param price Optional price
     * @param contractType Optional contract type, ie. "rental", "sale"
     * @return searches matching the criteria
     */
    public List<Search> find(Optional<Integer> bedrooms,
                             Optional<BigDecimal> price,
                             Optional<Contract.Type> contractType) {
        List<Criteria> criteria = new ArrayList<>();
        if (bedrooms.isPresent()) {
            criteria.add(Criteria.where("minimumBedrooms").lte(bedrooms.get())
                .orOperator(Criteria.where("minimumBedrooms").exists(false)));
            criteria.add(Criteria.where("maximumBedrooms").gte(bedrooms.get())
                .orOperator(Criteria.where("maximumBedrooms").exists(false)));
        }
        if (price.isPresent()) {
            criteria.add(Criteria.where("minimumPrice.value").lte(price.get())
                .orOperator(Criteria.where("minimumPrice").exists(false)));
            criteria.add(Criteria.where("maximumPrice.value").gte(price.get())
                .orOperator(Criteria.where("maximumPrice").exists(false)));
        }
        if (contractType.isPresent()) {
            criteria.add(Criteria.where("contract.type").is(contractType.get())
                .orOperator(Criteria.where("contract").exists(false)));
        }
        if (! criteria.isEmpty()) {
            Criteria and = new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()]));
            return mongoTemplate.find(Query.query(and), Search.class);
        } else {
            return mongoTemplate.findAll(Search.class);
        }
    }

    public Search create(Search search) {
        return searchRepository.save(search);
    }

    public Search get(String searchId) {
        return searchRepository.findOne(searchId);
    }

    public Search update(Search search) {
        return searchRepository.save(search);
    }

    public void delete(String searchId) {
        searchRepository.delete(searchId);
    }
}
