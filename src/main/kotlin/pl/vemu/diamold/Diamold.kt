package pl.vemu.diamold

import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import pl.vemu.diamold.blocks.DiamoldBlock
import pl.vemu.diamold.items.JsonName
import pl.vemu.diamold.items.diamoldItems

fun init() {
    diamoldItems.forEach {
        registerItem(it)
    }
    Registry.register(Registry.BLOCK, Identifier("diamold", DiamoldBlock.jsonName), DiamoldBlock)
}

private fun registerItem(item: Item) {
    Registry.register(Registry.ITEM, Identifier("diamold", (item as JsonName).jsonName), item)
}