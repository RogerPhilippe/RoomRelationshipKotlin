package br.com.nakajimaphilippe.roomrelationship.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long,
    var login: String,
    var avatarUrl: String
) {
    constructor(): this(0, "", "")
}