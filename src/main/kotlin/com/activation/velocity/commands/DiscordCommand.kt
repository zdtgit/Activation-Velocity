package com.activation.velocity.commands

import com.activation.velocity.extensions.string.mini
import com.velocitypowered.api.command.RawCommand

class DiscordCommand: RawCommand {
    override fun execute(invocation: RawCommand.Invocation) {
        invocation.source().sendMessage("<green><bold>디스코드:</bold> <yellow>https://discord.gg/u3mnfVBUSk".mini)
    }
}