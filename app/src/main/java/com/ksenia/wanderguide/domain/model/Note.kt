package com.ksenia.wanderguide.domain.model

import java.time.LocalDateTime

data class Note(
    val id: String,
    val text: String,
    val isCompleted: Boolean,
    val createdAt: LocalDateTime
)