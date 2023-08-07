package com.jose.springdocker.controller

import com.jose.springdocker.model.mongodb.MongoUsers
import com.jose.springdocker.model.mysql.MySQLUsers
import com.jose.springdocker.model.redis.RedisUsers
import com.jose.springdocker.request.AddUserRequest
import com.jose.springdocker.service.DBService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DBController(private val dbService: DBService) {
    @GetMapping("/redis")
    fun getRedis(): Map<String, String> {
        return dbService.getRedis()
    }

    @PostMapping("/redis")
    fun addRedis(@RequestBody addUserRequest: AddUserRequest) {
        return dbService.addRedis(addUserRequest.email, addUserRequest.name)
    }

    @GetMapping("/mongo")
    fun getMongo(): List<MongoUsers> {
        return dbService.getMongo()
    }

    @PostMapping("/mongo")
    fun addMongo(@RequestBody addUserRequest: AddUserRequest) {
        return dbService.addMongo(addUserRequest.email, addUserRequest.name)

    }

    @GetMapping("/mysql")
    fun getMySQL(): List<MySQLUsers> {
        return dbService.getMySQL()
    }

    @PostMapping("/mysql")
    fun addMySQL(@RequestBody addUserRequest: AddUserRequest) {
        return dbService.addMySQL(addUserRequest.email, addUserRequest.name)
    }
}