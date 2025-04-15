package com.gfg.ricky_morty_recycler_fragments.Data

data class Data(val results: List<Result> = listOf()) {
    data class Result(
        val created: String = "",
        val episode: List<String> = listOf(),
        val gender: String = "",
        val id: Int = 0,
        val image: String = "",
        val location: Location = Location(),
        val name: String = "",
        val origin: Origin = Origin(),
        val species: String = "",
        val status: String = "",
        val type: String = "",
        val url: String = ""
    ) {
        data class Location(
            val name: String = "",
            val url: String = ""
        )

        data class Origin(
            val name: String = "",
            val url: String = ""
        )
    }
}