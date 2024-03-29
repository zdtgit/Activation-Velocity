package com.activation.velocity.managers

import com.activation.velocity.extensions.string.legacy
import com.velocitypowered.api.proxy.Player
import java.util.UUID

object MessageManager {
    private val previous = HashMap<UUID, UUID>()
    val ignores = HashSet<UUID>()

    fun getPrevious(uuid: UUID): UUID? {
        return previous[uuid]
    }

    private fun setPrevious(key: UUID, value: UUID) {
        previous[key] = value
    }

    fun send(player: Player, target: Player, message: String) {
        if (!player.hasPermission("act.admin") && ignores.contains(target.uniqueId)) {
            player.sendMessage("&c해당 플레이어에게 메세지를 보낼 수 없습니다.".legacy)
            return
        }

        player.sendMessage("&eTo &b${target.username}&7: $message".legacy)
        target.sendMessage("&eFrom &b${player.username}&7: $message".legacy)

        setPrevious(target.uniqueId, player.uniqueId)
    }
}