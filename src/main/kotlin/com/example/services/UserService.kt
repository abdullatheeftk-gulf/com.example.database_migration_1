package com.example.services

import com.example.models.User

interface UserService {

    suspend fun addUser(user: User)

    suspend fun getAllUser():List<User>
}