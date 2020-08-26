package com.fengshui.tomatomod.init;

import com.fengshui.tomatomod.Main;
import com.fengshui.tomatomod.entities.TomatoEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityList {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            Main.MOD_ID);

    public static final RegistryObject<EntityType<TomatoEntity>> TOMATO = ENTITY_TYPES
            .register("tomato_entity",
                    () -> EntityType.Builder.<TomatoEntity>create(TomatoEntity::new, EntityClassification.MISC)
                            .setCustomClientFactory(TomatoEntity::new).size(0.25f, 0.25f)
                            .setUpdateInterval(10)
                            .build(new ResourceLocation(Main.MOD_ID, "tomato_entity").toString()));
}
