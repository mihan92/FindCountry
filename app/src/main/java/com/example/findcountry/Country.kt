package com.example.findcountry

data class Country(
    val name: String,
    val capital: String,
    val population: Long,
    val languages: List<Language>,
    val flag: String
    ) {
}

data class Language(
    val name: String
)