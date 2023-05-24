package pl.vemu.diamold.items

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.*
import net.minecraft.util.Identifier
import pl.vemu.diamold.blocks.DiamoldBlock
import pl.vemu.diamold.material.DiamoldArmorMaterial
import pl.vemu.diamold.material.DiamoldToolMaterial

private val diamoldGroup: ItemGroup =
    FabricItemGroupBuilder.create(Identifier("diamold", "group")).icon { ItemStack(Items.Ingot.item) }.build()
private val settings = Item.Settings().group(diamoldGroup)

@Suppress("unused")
enum class Items(identifier: String, val item: Item) {
    Ingot("ingot", Item(settings)),
    BlockItem("block", BlockItem(DiamoldBlock, settings)),
    Pickaxe("pickaxe", object : PickaxeItem(DiamoldToolMaterial, 1, -2.8F, settings) {}),
    Axe("axe", object : AxeItem(DiamoldToolMaterial, 5.0F, -3.0F, settings) {}),
    Shovel("shovel", ShovelItem(DiamoldToolMaterial, 1.5F, -3.0F, settings)),
    Hoe("hoe", object : HoeItem(DiamoldToolMaterial, -3, 0F, settings) {}),
    Helmet("helmet", ArmorItem(DiamoldArmorMaterial, EquipmentSlot.HEAD, settings)),
    Chestplate("chestplate", ArmorItem(DiamoldArmorMaterial, EquipmentSlot.CHEST, settings)),
    Leggings("leggings", ArmorItem(DiamoldArmorMaterial, EquipmentSlot.LEGS, settings)),
    Boots("boots", ArmorItem(DiamoldArmorMaterial, EquipmentSlot.FEET, settings)),
    Sword("sword", SwordItem(DiamoldToolMaterial, 3, -2.4F, settings));

    val identifier: String

    init {
        this.identifier = "diamold_$identifier"
    }
}
