package pl.vemu.diamold.items

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import pl.vemu.diamold.group.diamoldGroup
import pl.vemu.diamold.material.DiamoldMaterial

object DiamoldSword : SwordItem(DiamoldMaterial, 3, -2.4F, Settings().group(diamoldGroup)), JsonName {

    private var isUpgraded: Boolean = false

    /*override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        user?.addStatusEffect(StatusEffectInstance(StatusEffects.HASTE, 1000))
        user?.getStackInHand(hand)?.damage(1, user, { })
        println("client")
        if (world is ServerWorld) {
            println("server")
            EntityType.CHICKEN.spawnFromItemStack(world, user?.getStackInHand(hand), user,
                    user?.blockPos, SpawnReason.SPAWN_EGG, false, false)
        }
        return TypedActionResult.consume(user!!.getStackInHand(hand))
    }*/

    override fun getAttackDamage(): Float = if (!isUpgraded) 1F else 25F

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        isUpgraded = !isUpgraded
        return super.use(world, user, hand)
    }

    override val jsonName = "diamold_sword"
}