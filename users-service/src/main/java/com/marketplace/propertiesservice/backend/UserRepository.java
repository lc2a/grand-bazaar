package com.marketplace.propertiesservice.backend;

import com.marketplace.propertiesservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
