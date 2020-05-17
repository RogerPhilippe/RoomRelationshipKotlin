package br.com.nakajimaphilippe.roomrelationship.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.nakajimaphilippe.roomrelationship.db.entity.Repo

@Dao
interface RepoDAO {

    @Insert
    fun insert(repo: Repo)

    @Query("SELECT * FROM repo")
    fun getAllRepos(): MutableList<Repo>

    @Query("SELECT * FROM repo WHERE userId=:userId")
    fun findRepositoriesForUer(userId: Int): MutableList<Repo>

}