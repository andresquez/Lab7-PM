package gt.uvg.pokelist.model

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String,

    ) {
    fun cleanURLbefore(str: String?, num: Int): String? {
        return if (str == null || str.length < num) {
            str
        } else str.substring(num)
    }

    private val url2: String = cleanURLbefore(url, 34)!!

    private fun cleanURLafter(str: String, num: Int): String {
        return str.substring(0, str.length - num)
    }

    val id: Int = Integer.valueOf(cleanURLafter(url2, 1))
    val imageUrlFront: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

}

data class PokemonResponse(
    @Json(name = "results")
    val result: List<Pokemon>
)