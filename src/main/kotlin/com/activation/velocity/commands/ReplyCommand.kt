package com.activation.velocity.commands

import com.activation.velocity.ActivationVelocity
import com.activation.velocity.extensions.string.legacy
import com.activation.velocity.managers.MessageManager
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.Player
import java.util.*

class ReplyCommand: SimpleCommand {
    private val plugin = ActivationVelocity.instance

    override fun execute(invocation: SimpleCommand.Invocation) {
        val source = invocation.source()

        if (source is Player) {
            val args = invocation.arguments()

            if (args.isEmpty()) {
                source.sendMessage("&c사용법: /reply (메세지)".legacy)
                return
            }

            val uuid = MessageManager.getPrevious(source.uniqueId)

            if (!source.hasPermission("activation.admin") && uuid == UUID.fromString("f677f965-cab5-410b-803f-049a4d4fe18b")) {
                source.sendMessage("&c해당 플레이어에게 메세지를 보낼 수 없습니다.".legacy)
                return
            }

            val player = plugin.proxy.getPlayer(uuid)

            if (player.isEmpty) {
                source.sendMessage("&c그 플레이어는 온라인이 아닙니다.".legacy)
                return
            }

            val target = player.get()
            val message = args.joinToString(" ")

            MessageManager.send(source, target, message)
        }
    }
}