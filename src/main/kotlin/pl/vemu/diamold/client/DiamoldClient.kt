package pl.vemu.diamold.client

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.network.AbstractClientPlayerEntity
import net.minecraft.client.options.StickyKeyBinding
import org.lwjgl.glfw.GLFW

fun init() {
    val keyBinding = KeyBindingHelper.registerKeyBinding(
        StickyKeyBinding(
            "diamold.key",
            GLFW.GLFW_KEY_F8,
            "diamold.category.key"
        ) { true })
    ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client ->
        if (keyBinding.isPressed)
            client.world?.players?.forEach { player: AbstractClientPlayerEntity ->
                if (!player.isGlowing && player != MinecraftClient.getInstance().player) player.isGlowing = true
            }
        else if (!keyBinding.isPressed) {
            client.world?.players?.forEach { player: AbstractClientPlayerEntity ->
                if (player.isGlowing) player.isGlowing = false
            }
        }
    })
}