package net.twc.eschaton.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.twc.eschaton.Eschaton;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Eschaton.MOD_ID);



    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
