package com.activation.velocity.managers

import com.activation.velocity.ActivationVelocity
import com.activation.velocity.commands.*
import com.velocitypowered.api.command.Command

object CommandManager {
    private val plugin = ActivationVelocity.instance

    fun init() {
        // Social
        register("discord", DiscordCommand(), "디스코드")
        register("twitch", TwitchCommand(), "트위치")
        register("youtube", YouTubeCommand(), "유튜브")

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