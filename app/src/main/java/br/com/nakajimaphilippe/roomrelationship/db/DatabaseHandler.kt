package br.com.nakajimaphilippe.roomrelationship.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.nakajimaphilippe.roomrelationship.db.entity.Repo
import br.com.nakajimaphilippe.roomrelationship.db.entity.User

@Database(entities = [User::class, Repo::class], version = 1, exportSchema = false)
abstract class DatabaseHandler: RoomDatabase() {

    abstract fun getRepoDAO(): RepoDAO
    abstract fun getUserDAO(): UserDAO

}

object GetDatabase {

    private const val databaseName = "repos.db"

    fun getDatabaseBuilder(context: Context): DatabaseHandler {
        return Room.databaseBuilder(context, DatabaseHandler::class.java, databaseName).build()
    }

}