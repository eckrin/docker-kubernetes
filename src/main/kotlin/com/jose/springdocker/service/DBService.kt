package com.jose.springdocker.service

import com.jose.springdocker.model.mongodb.MongoUsers
import com.jose.springdocker.model.mysql.MySQLUsers
import com.jose.springdocker.repository.mongodb.UserMongoRepository
import com.jose.springdocker.repository.mysql.UserMySQLRepository
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.concurrent.TimeUnit


@Service
class DBService(private val stringRedisTemplate: StringRedisTemplate,
                private val userMongoRepository: UserMongoRepository,
                private val userMySQLRepository: UserMySQLRepository) {
    fun getRedis(): Map<String, String> {
        return stringRedisTemplate.keys("*").associateWith { key -> stringRedisTemplate.opsForValue().get(key)!! }
    }

    fun addRedis(email:String, name:String) {
        stringRedisTemplate.opsForValue().set(
            UUID.randomUUID().toString(), "$email $name", 600000, TimeUnit.MILLISECONDS
        )
    }

    fun getMongo(): List<MongoUsers> {
        return userMongoRepository.findAll()
    }

    fun addMongo(email: String, name: String) {
        userMongoRepository.save(
            MongoUsers(
                id = UUID.randomUUID().toString(),
                email = email,
                name = name
            )
        )
    }

    fun getMySQL(): List<MySQLUsers> {
        return userMySQLRepository.findAll()
    }

    fun addMySQL(email: String, name: String) {
        userMySQLRepository.save(
            MySQLUsers(
                id = UUID.randomUUID().toString(),
                email = email,
                name = name
            )
        )
    }
}