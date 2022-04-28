package me.muru.twnbot.model

data class RestaurantItem(val name: String = "",
                          val baseprice: Int = 0,
                          val type: String = "",
                          val image: String = ""
) {
    fun getFormattedBasePrice(): Float = baseprice.toFloat() / 100
}
