package com.example.database

import com.example.database.tables.UserTable
import com.example.models.User
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction


// For general query
suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }

 // For converting UserTable result row from database user table to user
fun UserTable.rowToUser(row: ResultRow) = User(
    id = row[id].value,
    name = row[name],
    mark = row[mark]
)


