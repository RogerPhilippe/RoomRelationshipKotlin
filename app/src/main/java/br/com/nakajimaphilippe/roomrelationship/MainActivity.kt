package br.com.nakajimaphilippe.roomrelationship

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.nakajimaphilippe.roomrelationship.db.DatabaseHandler
import br.com.nakajimaphilippe.roomrelationship.db.GetDatabase
import br.com.nakajimaphilippe.roomrelationship.db.entity.Repo
import br.com.nakajimaphilippe.roomrelationship.db.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = GetDatabase.getDatabaseBuilder(this)

        val user = User().apply {
            this.login = ""
            this.avatarUrl = "https://github.com/RogerPhilippe"
        }

        Log.i("TESTE", "Insert User.")
        val id = insertUser(db, user)

        val repo = Repo().apply {
            this.name = "Repo $id"
            this.url = "https://github.com/RogerPhilippe/repo_$id"
            this.userId = id
        }

        Log.i("TESTE", "Insert Repo for UserID: $id")
        insertRepo(db, repo)
        Log.i("TESTE", "Print All Repos.")
        printAllRepos(db)

    }

    private fun insertUser(db: DatabaseHandler, user: User) = runBlocking {
        withContext(Dispatchers.IO) {
            return@withContext db.getUserDAO().insert(user)
        }
    }

    private fun insertRepo(db: DatabaseHandler, repo: Repo) = runBlocking {
        withContext(Dispatchers.IO) {
            return@withContext db.getRepoDAO().insert(repo)
        }
    }

    private fun printAllRepos(db: DatabaseHandler) = runBlocking {
        withContext(Dispatchers.IO) {
            db.getRepoDAO().getAllRepos().forEach { repos ->
                Log.i("TESTE", repos.name)
            }
        }
    }

}
