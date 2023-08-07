package com.jose.springdocker.repository.mongodb

import com.jose.springdocker.model.mongodb.MongoUsers
import org.springframework.data.mongodb.repository.MongoRepository

interface UserMongoRepository: MongoRepository<MongoUsers, String> {
}