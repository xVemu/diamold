package pl.vemu.diamold

import net.fabricmc.loader.api.FabricLoader
import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.apache.commons.io.FileUtils
import pl.vemu.diamold.blocks.DiamoldBlock
import pl.vemu.diamold.items.Hammer
import pl.vemu.diamold.items.Items
import java.io.File

fun init() {
    Items.values().forEach(::registerItem)
    registerBlock(DiamoldBlock)
    registerHammer()
}

private fun registerItem(item: Items) {
    Registry.register(Registry.ITEM, Identifier("diamold", item.identifier), item.item)
}

private fun registerBlock(block: Block) {
    Registry.register(Registry.BLOCK, Identifier("diamold", "diamold_block"), block)
}

private fun registerHammer() {
    if (!FabricLoader.getInstance().isModLoaded("crushing_hammers")) return

    Registry.register(Registry.ITEM, Identifier("diamold", "diamold_hammer"), Hammer)
    val inputStream = object {}.javaClass.getResourceAsStream("/configs/diamold_block.json")
    FileUtils.copyInputStreamToFile(inputStream, File("config/crushing_hammers/recipes/diamold_block.json"))

}