package br.com.nakajimaphilippe.roomrelationship.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.nakajimaphilippe.roomrelationship.db.entity.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Long

    @Query("SELECT * FROM user")
    fun getUsers(): MutableList<User>

    @Query("SELECT * FROM user WHERE id=:id")
    fun getUserById(id: Int): User

}