package me.muru.twnbot.model

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "twnb")
@ConstructorBinding
data class BotConfigProperties(
    val chatId: String,
    val botId: String,
    val woltUrl: String,
    val userAgentHeader: String,
)
