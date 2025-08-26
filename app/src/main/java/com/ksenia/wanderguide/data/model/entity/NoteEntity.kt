package com.ksenia.wanderguide.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class NoteEntity (
    @PrimaryKey
    val id: String,
    val text: String,
    val isCompleted: Boolean,
    val createdAt: String
)