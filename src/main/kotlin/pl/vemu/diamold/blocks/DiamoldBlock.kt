package pl.vemu.diamold.blocks

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.sound.BlockSoundGroup

object DiamoldBlock : Block(
    FabricBlockSettings.of(Material.METAL).requiresTool()
        .strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)
)