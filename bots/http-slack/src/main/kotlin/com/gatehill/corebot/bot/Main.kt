package com.gatehill.corebot.bot

import com.gatehill.corebot.asSingleton
import com.gatehill.corebot.backend.slack.SlackDriverModule
import com.gatehill.corebot.frontend.http.HttpModule
import com.gatehill.corebot.operation.NoOpOperationFactoryConverter
import com.gatehill.corebot.operation.OperationFactoryConverter
import com.gatehill.corebot.util.VersionUtil
import com.google.inject.AbstractModule

fun main(args: Array<String>) {
    println("Starting Corebot [version ${VersionUtil.version}]")
    println("Warning: the HTTP bot is experimental.")
    Bot.build(BotModule(), HttpModule()).start()
}

private class BotModule : AbstractModule() {
    override fun configure() {
        bind(BotBootstrap::class.java).asEagerSingleton()
        bind(OperationFactoryConverter::class.java).to(NoOpOperationFactoryConverter::class.java).asSingleton()

        // drivers
        install(SlackDriverModule())
    }
}
