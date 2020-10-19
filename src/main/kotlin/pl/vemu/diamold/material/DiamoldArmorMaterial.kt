package pl.vemu.diamold.material

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import pl.vemu.diamold.items.DiamoldIngot

object DiamoldArmorMaterial : ArmorMaterial {

    private const val durabilityMultiplier = 33
    private val protectionAmounts = intArrayOf(3, 6, 8, 3)
    private val BASE_DURABILITY = intArrayOf(13, 15, 16, 11)

    override fun getDurability(slot: EquipmentSlot?): Int =
        BASE_DURABILITY[slot?.entitySlotId!!] * durabilityMultiplier

    override fun getProtectionAmount(slot: EquipmentSlot?): Int = protectionAmounts[slot!!.entitySlotId]

    override fun getEnchantability(): Int = 10

    //TODO sound effect
    override fun getEquipSound(): SoundEvent = SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(DiamoldIngot)

    override fun getName(): String = "diamold"

    override fun getToughness(): Float = 2F

    override fun getKnockbackResistance(): Float = 0F
}