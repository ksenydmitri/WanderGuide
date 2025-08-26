package com.ksenia.wanderguide.domain.model

data class Note(
    val id: String,
    val text: String,
    val isCompleted: Boolean,
    val createdAt: String
)