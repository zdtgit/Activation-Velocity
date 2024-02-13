package com.activation.velocity.commands

import com.activation.velocity.ActivationVelocity
import com.activation.velocity.extensions.string.legacy
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.Player
import java.util.concurrent.CompletableFuture

class ServerCommand: SimpleCommand {
    private val plugin = ActivationVelocity.instance

    override fun execute(invocation: SimpleCommand.Invocation) {
        val source = invocation.source()

        if (source is Player) {
            val args = invocation.arguments()

            if (args.isEmpty()) {
                source.sendMessage("&c사용법: /server [serverName]".legacy)
                return
            }

            val serverName = args[0]
            val server = plugin.proxy.getServer(serverName)

            if (server.isEmpty) {
                source.sendMessage("&c서버를 찾지 못했습니다.".legacy)
                return
            }

            source.createConnectionRequest(server.get()).fireAndForget()
        }
    }

    override fun suggestAsync(invocation: SimpleCommand.Invocation): CompletableFuture<List<String>> {
        val args = invocation.arguments()

        if (args.size == 1) {
            val serverName = args[0] ?: ""
            return CompletableFuture.completedFuture(plugin.proxy.allServers.map { it.serverInfo.name }.filter { it.startsWith(serverName) })
        }

        return CompletableFuture.completedFuture(emptyList())
    }
}