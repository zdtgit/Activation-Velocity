package com.activation.velocity.extensions.string

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer

val String.legacy: Component
    get() = LegacyComponentSerializer.legacyAmpersand().deserialize(this)