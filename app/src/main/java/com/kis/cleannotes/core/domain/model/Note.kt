package com.kis.cleannotes.core.domain.model

// For work with data out of the Room database
data class Note(
    val id: Int,
    val title: String,
    val description: String
)
