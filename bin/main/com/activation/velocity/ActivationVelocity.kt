package com.activation.velocity

import com.activation.velocity.managers.CommandManager
import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer

@Plugin(
    id = "activation-velocity",
    name = "Activation-Velocity",
    url = "https://activation.com",
    authors = ["zdt"],
    version = "1.0",
)
class ActivationVelocity @Inject constructor(val proxy: ProxyServer) {
    @Subscribe
    @SuppressWarnings("unused")
    fun onInitialize(event: ProxyInitializeEvent) {
        instance = this

        CommandManager.init()
    }

    companion object {
        lateinit var instance: ActivationVelocity
    }
}