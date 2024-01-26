package com.activation.velocity.managers

import com.activation.velocity.ActivationVelocity
import com.activation.velocity.commands.LobbyCommand
import com.activation.velocity.commands.MessageCommand
import com.activation.velocity.commands.ReplyCommand
import com.activation.velocity.commands.ServerCommand
import com.velocitypowered.api.command.Command

object CommandManager {
    val plugin = ActivationVelocity.instance

    fun init() {
        register("lobby", LobbyCommand(), "l", "로비")
        register("message", MessageCommand(), "msg", "whisper", "w", "tell")
        register("reply", ReplyCommand(), "r")
        register("server", ServerCommand(), "서버")
    }

    private fun register(name: String, command: Command, vararg aliases: String) {
        val manager = plugin.proxy.commandManager
        val meta = manager.metaBuilder(name).aliases(*aliases).plugin(plugin).build()

        manager.register(meta, command)
    }
}