package com.activation.velocity.commands

import com.activation.velocity.extensions.string.mini
import com.velocitypowered.api.command.RawCommand

class TwitchCommand: RawCommand {
    override fun execute(invocation: RawCommand.Invocation) {
        invocation.source().sendMessage("<green><bold>트위치:</bold> <yellow>https://www.twitch.tv/activation0000".mini)
    }
}