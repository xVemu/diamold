package pl.vemu.diamold.blocks

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.sound.BlockSoundGroup
import pl.vemu.diamold.items.JsonName

object DiamoldBlock : Block(
    FabricBlockSettings.of(Material.METAL).requiresTool().strength(5.0F, 6.0F)
        .sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 2)
), JsonName {
    override val jsonName = "diamold_block"
}