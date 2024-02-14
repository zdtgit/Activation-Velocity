package com.activation.velocity.commands

import com.activation.velocity.extensions.string.mini
import com.velocitypowered.api.command.RawCommand

class YouTubeCommand: RawCommand {
    override fun execute(invocation: RawCommand.Invocation) {
        invocation.source().sendMessage("<green><bold>유튜브:</bold> <yellow>https://www.youtube.com/@activation_".mini)
    }
}