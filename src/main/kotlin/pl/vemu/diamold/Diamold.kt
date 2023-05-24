package pl.vemu.diamold

import net.fabricmc.api.ModInitializer
import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import pl.vemu.diamold.blocks.DiamoldBlock
import pl.vemu.diamold.items.Items

class Diamold : ModInitializer {
    override fun onInitialize() {
        Items.values().forEach(::registerItem)
        registerBlock(DiamoldBlock)
    }
}

private fun registerItem(item: Items) {
    Registry.register(Registry.ITEM, Identifier("diamold", item.identifier), item.item)
}

private fun registerBlock(block: Block) {
    Registry.register(Registry.BLOCK, Identifier("diamold", "diamold_block"), block)
}
