package me.muru.twnbot

import me.muru.twnbot.model.BotConfigProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties(BotConfigProperties::class)
class TelegramWoltNotificationBotApplication

fun main(args: Array<String>) {
	runApplication<TelegramWoltNotificationBotApplication>(*args)
}
