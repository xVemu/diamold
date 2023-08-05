package pl.vemu.diamold.items

import net.minecraft.item.*
import pl.vemu.diamold.blocks.DiamoldBlock
import pl.vemu.diamold.material.DiamoldArmorMaterial
import pl.vemu.diamold.material.DiamoldToolMaterial

private val settings = Item.Settings()

@Suppress("unused")
enum class Items(identifier: String, val item: Item) {
    Ingot("ingot", Item(settings)),
    BlockItem("block", BlockItem(DiamoldBlock, settings)),
    Pickaxe("pickaxe", object : PickaxeItem(DiamoldToolMaterial, 1, -2.8F, settings) {}),
    Axe("axe", object : AxeItem(DiamoldToolMaterial, 5.0F, -3.0F, settings) {}),
    Shovel("shovel", ShovelItem(DiamoldToolMaterial, 1.5F, -3.0F, settings)),
    Hoe("hoe", object : HoeItem(DiamoldToolMaterial, -3, 0F, settings) {}),
    Helmet("helmet", ArmorItem(DiamoldArmorMaterial, ArmorItem.Type.HELMET, settings)),
    Chestplate("chestplate", ArmorItem(DiamoldArmorMaterial, ArmorItem.Type.CHESTPLATE, settings)),
    Leggings("leggings", ArmorItem(DiamoldArmorMaterial, ArmorItem.Type.LEGGINGS, settings)),
    Boots("boots", ArmorItem(DiamoldArmorMaterial, ArmorItem.Type.BOOTS, settings)),
    Sword("sword", SwordItem(DiamoldToolMaterial, 3, -2.4F, settings));

    val identifier: String

    init {
        this.identifier = "diamold_$identifier"
    }
}
