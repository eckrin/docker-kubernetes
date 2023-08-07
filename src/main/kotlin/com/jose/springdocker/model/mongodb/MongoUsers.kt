package com.jose.springdocker.model.mongodb

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class MongoUsers(
    @Id
    val id: String, //UUID
    val email: String,
    val name: String
)