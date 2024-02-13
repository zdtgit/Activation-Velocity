package com.activation.velocity.commands

import com.activation.velocity.ActivationVelocity
import com.activation.velocity.extensions.string.legacy
import com.activation.velocity.managers.MessageManager
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.Player

class MessageCommand: SimpleCommand {
    private val plugin = ActivationVelocity.instance

    override fun execute(invocation: SimpleCommand.Invocation) {
        val source = invocation.source()

        if (source is Player) {
            val args = invocation.arguments()

            if (args.size < 2) {
                source.sendMessage("&c사용법: /message (플레이어) (메세지)".legacy)
                return
            }

            val name = args[0]
            val player = plugin.proxy.getPlayer(name)

            if (player.isEmpty) {
                source.sendMessage("&c그 플레이어는 온라인이 아닙니다.".legacy)
                return
            }

            val target = player.get()
            val message = args.copyOfRange(1, args.size).joinToString(" ")

            MessageManager.send(source, target, message)
        }
    }
}