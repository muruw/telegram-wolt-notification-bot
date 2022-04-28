package me.muru.twnbot.service

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import me.muru.twnbot.model.BotConfigProperties
import me.muru.twnbot.model.Restaurant
import org.springframework.stereotype.Service

@Service
class BotService(val properties: BotConfigProperties) {

    fun findDeals() {
        val restaurants = listOf("viru-burger-tartu", "subway-kaubamaja")
        for (r in restaurants) {
            sendRestaurantDealNotifications(properties.woltUrl.replace("{RESTAURANT_NAME}", r))
        }
    }

    private fun sendRestaurantDealNotifications(restaurantUrl: String) {
        restaurantUrl
            .httpGet()
            .header(mapOf("user-agent" to properties.userAgentHeader))
            .responseObject(Restaurant.Deserializer()) { _, _, result ->
                val (restaurant, err) = result
                for (item in restaurant?.items!!) {
                    if (item.type == "deal") {
                        val message = "${item.name}: ${item.getFormattedBasePrice()}€"
                        sendNotificationToTelegramBot(item.image, message)
                    }
                }
            }
    }

    private fun sendNotificationToTelegramBot(imageUrl: String, message: String) {
        val params = listOf("photo" to imageUrl, "chat_id" to properties.chatId, "caption" to message)
        Fuel.get("https://api.telegram.org/bot${properties.botId}/sendPhoto", params)
            .response()
    }
}