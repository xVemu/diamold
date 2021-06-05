package pl.vemu.diamold.material

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import pl.vemu.diamold.items.DiamoldItems

object DiamoldMaterial : ToolMaterial {
    override fun getDurability(): Int = 1561

    override fun getMiningSpeedMultiplier(): Float = 12F

    override fun getAttackDamage(): Float = 3.0F

    override fun getMiningLevel(): Int = 3

    override fun getEnchantability(): Int = 22

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(DiamoldItems.DiamoldIngot)
}