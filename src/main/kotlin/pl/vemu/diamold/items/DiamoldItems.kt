package pl.vemu.diamold.items

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.*
import pl.vemu.diamold.blocks.DiamoldBlock
import pl.vemu.diamold.group.diamoldGroup
import pl.vemu.diamold.material.DiamoldArmorMaterial
import pl.vemu.diamold.material.DiamoldMaterial

object DiamoldItems {

    val arrayOfItems: Array<Item> by lazy {
        arrayOf(
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
    }

    private val settings = Item.Settings().group(diamoldGroup)

    object DiamoldIngot : Item(Settings().group(diamoldGroup)), JsonName {
        override val jsonName = "diamold_ingot"
    }

    object DiamoldBlockItem : BlockItem(DiamoldBlock, Settings().group(diamoldGroup)), JsonName {
        override val jsonName = DiamoldBlock.jsonName
    }

    object DiamoldPickaxe : PickaxeItem(DiamoldMaterial, 1, -2.8F, settings), JsonName {
        override val jsonName = "diamold_pickaxe"
    }

    object DiamoldAxe : AxeItem(DiamoldMaterial, 5.0F, -3.0F, settings), JsonName {
        override val jsonName = "diamold_axe"
    }

    object DiamoldShovel : ShovelItem(DiamoldMaterial, 1.5F, -3.0F, settings), JsonName {
        override val jsonName = "diamold_shovel"
    }

    object DiamoldHoe : HoeItem(DiamoldMaterial, -3, 0F, settings), JsonName {
        override val jsonName = "diamold_hoe"
    }

    object DiamoldHelmet : ArmorItem(DiamoldArmorMaterial, EquipmentSlot.HEAD, settings), JsonName {
        override val jsonName = "diamold_helmet"
    }

    object DiamoldChestplate : ArmorItem(DiamoldArmorMaterial, EquipmentSlot.CHEST, settings), JsonName {
        override val jsonName = "diamold_chestplate"
    }

    object DiamoldLeggings : ArmorItem(DiamoldArmorMaterial, EquipmentSlot.LEGS, settings), JsonName {
        override val jsonName = "diamold_leggings"
    }

    object DiamoldBoots : ArmorItem(DiamoldArmorMaterial, EquipmentSlot.FEET, settings), JsonName {
        override val jsonName = "diamold_boots"
    }

    object DiamoldSword : SwordItem(DiamoldMaterial, 3, -2.4F, Settings().group(diamoldGroup)), JsonName {
        override val jsonName = "diamold_sword"
    }


    object DiamoldHammer : PickaxeItem(DiamoldMaterial, 1, -2.8F, settings), JsonName {
        override val jsonName = "diamold_hammer"
    }
}