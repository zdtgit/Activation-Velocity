package com.activation.velocity.commands

import com.activation.velocity.ActivationVelocity
import com.activation.velocity.extensions.string.legacy
import com.velocitypowered.api.command.RawCommand
import com.velocitypowered.api.proxy.Player
import java.util.concurrent.CompletableFuture

class LobbyCommand: RawCommand {
    private val plugin = ActivationVelocity.instance

    override fun execute(invocation: RawCommand.Invocation) {
        val source = invocation.source()

        if (source is Player) {
            val server = plugin.proxy.getServer("lobby")

            if (server.isEmpty) {
                source.sendMessage("&c서버를 찾지 못했습니다.".legacy)
                return
            }

            source.createConnectionRequest(server.get()).fireAndForget()
        }
    }

    override fun suggestAsync(invocation: RawCommand.Invocation): CompletableFuture<List<String>> {
        return CompletableFuture.completedFuture(emptyList())
    }
}