package pl.vemu.diamold

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.Block
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import pl.vemu.diamold.blocks.DiamoldBlock
import pl.vemu.diamold.items.Items

@Suppress("unused")
fun init() {
    Items.entries.forEach(::registerItem)
    registerBlock(DiamoldBlock)
    registerGroup()
}

private fun registerItem(item: Items) {
    Registry.register(Registries.ITEM, Identifier("diamold", item.identifier), item.item)
    ItemGroupEvents.modifyEntriesEvent(groupKey).register { content ->
        content.add(ItemStack(item.item))
    }
}

private fun registerBlock(block: Block) {
    Registry.register(Registries.BLOCK, Identifier("diamold", "diamold_block"), block)
}

private val groupKey = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier("diamold", "diamold_group"))

private fun registerGroup() {
    val diamoldGroup =
        FabricItemGroup.builder().displayName(Text.translatable("itemGroup.diamold.group"))
            .icon { ItemStack(Items.Ingot.item) }.build()
    Registry.register(Registries.ITEM_GROUP, groupKey, diamoldGroup)
}
