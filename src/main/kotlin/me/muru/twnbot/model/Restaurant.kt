package me.muru.twnbot.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Restaurant(val name: String = "",
                      val items: List<RestaurantItem> = ArrayList()
) {
    class Deserializer : ResponseDeserializable<Restaurant> {
        override fun deserialize(content: String): Restaurant = Gson().fromJson(content, Restaurant::class.java)
    }
}
