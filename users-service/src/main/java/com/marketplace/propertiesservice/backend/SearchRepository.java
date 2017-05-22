package com.marketplace.propertiesservice.backend;

import com.marketplace.propertiesservice.model.Search;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchRepository extends MongoRepository<Search, String> {

}
