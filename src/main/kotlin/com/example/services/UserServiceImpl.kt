package com.example.services

import com.example.database.dbQuery
import com.example.database.rowToUser
import com.example.database.tables.UserTable
import com.example.models.User
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class UserServiceImpl:UserService {
    override suspend fun addUser(user: User) {
        dbQuery {
            UserTable.insert {
                it[name] = user.name
                it[mark] = user.mark
            }
        }
    }

    override suspend fun getAllUser(): List<User> {
        return  dbQuery {
            UserTable.selectAll().map {
                UserTable.rowToUser(it)
            }
        }
    }
}