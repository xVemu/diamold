package pl.vemu.diamold.group

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import pl.vemu.diamold.items.DiamoldItems

val diamoldGroup: ItemGroup =
    FabricItemGroupBuilder.create(Identifier("diamold", "group")).icon { ItemStack(DiamoldItems.DiamoldIngot) }.build()