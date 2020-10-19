package pl.vemu.diamold.items

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.*
import pl.vemu.diamold.blocks.DiamoldBlock
import pl.vemu.diamold.group.diamoldGroup
import pl.vemu.diamold.material.DiamoldArmorMaterial
import pl.vemu.diamold.material.DiamoldMaterial


private val settings = Item.Settings().group(diamoldGroup)

val diamoldItems: Array<Item> = arrayOf(
    DiamoldSword,
    DiamoldPickaxe,
    DiamoldAxe,
    DiamoldShovel,
    DiamoldHoe,
    DiamoldHelmet,
    DiamoldChestplate,
    DiamoldLeggings,
    DiamoldBoots,
    DiamoldBlockItem,
    DiamoldIngot
)

object DiamoldIngot : Item(Settings().group(diamoldGroup)), JsonName {
    override val jsonName = "diamold_ingot"
}

private object DiamoldBlockItem : BlockItem(DiamoldBlock, Settings().group(diamoldGroup)), JsonName {
    override val jsonName = DiamoldBlock.jsonName
}

private object DiamoldPickaxe : PickaxeItem(DiamoldMaterial, 1, -2.8F, settings), JsonName {
    override val jsonName = "diamold_pickaxe"
}

private object DiamoldAxe : AxeItem(DiamoldMaterial, 5.0F, -3.0F, settings), JsonName {
    override val jsonName = "diamold_axe"
}

private object DiamoldShovel : ShovelItem(DiamoldMaterial, 1.5F, -3.0F, settings), JsonName {
    override val jsonName = "diamold_shovel"
}

private object DiamoldHoe : HoeItem(DiamoldMaterial, -3, 0F, settings), JsonName {
    override val jsonName = "diamold_hoe"
}

private object DiamoldHelmet : ArmorItem(DiamoldArmorMaterial, EquipmentSlot.HEAD, settings), JsonName {
    override val jsonName = "diamold_helmet"
}

private object DiamoldChestplate : ArmorItem(DiamoldArmorMaterial, EquipmentSlot.CHEST, settings), JsonName {
    override val jsonName = "diamold_chestplate"
}

private object DiamoldLeggings : ArmorItem(DiamoldArmorMaterial, EquipmentSlot.LEGS, settings), JsonName {
    override val jsonName = "diamold_leggings"
}

private object DiamoldBoots : ArmorItem(DiamoldArmorMaterial, EquipmentSlot.FEET, settings), JsonName {
    override val jsonName = "diamold_boots"
}