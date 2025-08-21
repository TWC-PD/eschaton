package net.twc.eschaton.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twc.eschaton.Eschaton;
import net.twc.eschaton.entity.custom.RiftSpearProjectileEntity;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Eschaton.MOD_ID);

    public static final RegistryObject<EntityType<RiftSpearProjectileEntity>> RIFT_SPEAR =
            ENTITY_TYPES.register("rift_spear", () -> EntityType.Builder.<RiftSpearProjectileEntity>of(RiftSpearProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20).build("rift_spear"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
