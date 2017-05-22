package com.marketplace.propertiesservice.backend;

import com.marketplace.propertiesservice.model.Property;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropertyRepository extends MongoRepository<Property, String> {

}
