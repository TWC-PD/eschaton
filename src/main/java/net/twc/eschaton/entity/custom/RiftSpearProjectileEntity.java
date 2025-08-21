package net.twc.eschaton.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import net.twc.eschaton.entity.ModEntityTypes;
import net.twc.eschaton.item.ModItems;

public class RiftSpearProjectileEntity extends AbstractArrow {
    private int damage;

    public RiftSpearProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public RiftSpearProjectileEntity(Level pLevel, double pX, double pY, double pZ, ItemStack pPickupItemStack) {
        super(EntityType.TRIDENT, pX, pY, pZ, pLevel, pPickupItemStack, pPickupItemStack);
    }

    public RiftSpearProjectileEntity(LivingEntity shooter, Level level) {
        super(ModEntityTypes.RIFT_SPEAR.get(), shooter, level, new ItemStack(ModItems.RIFT_SPEAR.get()), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.RIFT_SPEAR.get());
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), this.damage);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    @Override
    protected float getWaterInertia() {
        return 0.75F;
    }
}
