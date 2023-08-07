package com.jose.springdocker.repository.mysql

import com.jose.springdocker.model.mysql.MySQLUsers
import org.springframework.data.jpa.repository.JpaRepository

interface UserMySQLRepository: JpaRepository<MySQLUsers, String> {
}