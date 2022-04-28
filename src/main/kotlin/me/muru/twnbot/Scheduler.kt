package me.muru.twnbot

import me.muru.twnbot.service.BotService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduler(val service: BotService) {

    @Scheduled(fixedRate = 18000000)
    fun woltDealScheduler() {
        service.findDeals()
    }
}