package br.com.nakajimaphilippe.roomrelationship.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(
    entity = User::class,
    parentColumns = ["id"],
    childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE
    )
])

data class Repo(
    @PrimaryKey(autoGenerate = true) var id: Long,
    var name: String,
    var url: String,
    var userId: Long
) {
    constructor(): this(0, "", "", 0)
}