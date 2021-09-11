package pl.vemu.diamold

import net.fabricmc.loader.api.FabricLoader
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.apache.commons.io.FileUtils
import pl.vemu.diamold.blocks.DiamoldBlock
import pl.vemu.diamold.items.DiamoldItems
import pl.vemu.diamold.items.JsonName
import java.io.File

fun init() {
    DiamoldItems.arrayOfItems.forEach(::registerItem)
    registerBlock(DiamoldBlock)
    if (FabricLoader.getInstance().isModLoaded("crushing_hammers")) {
        registerItem(DiamoldItems.DiamoldHammer)
        val inputStream = object {}.javaClass.getResourceAsStream("/configs/diamold_block.json")
        FileUtils.copyInputStreamToFile(inputStream, File("config/crushing_hammers/recipes/diamold_block.json"))
    }
}

private fun registerItem(item: Item) {
    Registry.register(Registry.ITEM, Identifier("diamold", (item as JsonName).jsonName), item)
}

private fun registerBlock(block: Block) {
    Registry.register(Registry.BLOCK, Identifier("diamold", (block as JsonName).jsonName), block)
}