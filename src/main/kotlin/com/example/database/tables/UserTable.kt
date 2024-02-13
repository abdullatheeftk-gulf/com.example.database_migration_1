package com.example.database.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object UserTable:IntIdTable(name = "user") {
    val name = varchar(name = "name", length = 128)
    // mark this column as nullable
    val mark = float(name = "mark").nullable()
}