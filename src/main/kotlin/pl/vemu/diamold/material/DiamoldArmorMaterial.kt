package pl.vemu.diamold.material

import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import pl.vemu.diamold.items.Items

object DiamoldArmorMaterial : ArmorMaterial {

    private const val durabilityMultiplier = 33
    private val protectionAmounts = intArrayOf(3, 6, 8, 3)
    private val BASE_DURABILITY = intArrayOf(13, 15, 16, 11)

    override fun getDurability(type: ArmorItem.Type): Int =
        BASE_DURABILITY[type.equipmentSlot.entitySlotId] * durabilityMultiplier

    override fun getProtection(type: ArmorItem.Type): Int = protectionAmounts[type.equipmentSlot.entitySlotId]

    override fun getEnchantability(): Int = 25

    //TODO sound effect
    override fun getEquipSound(): SoundEvent = SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(Items.Ingot.item)

    override fun getName(): String = "diamold"

    override fun getToughness(): Float = 2F

    override fun getKnockbackResistance(): Float = 0F
}
