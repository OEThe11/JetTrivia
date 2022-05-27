package com.example.jettriva.model

data class GetTriviaResponseItem(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
)