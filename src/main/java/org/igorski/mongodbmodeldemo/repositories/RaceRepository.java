package org.igorski.mongodbmodeldemo.repositories;

import org.igorski.mongodbmodeldemo.model.Race;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RaceRepository extends MongoRepository<Race, String> {
}
