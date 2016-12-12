package com.loobo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildRepository extends MongoRepository<Build, String> {
}
