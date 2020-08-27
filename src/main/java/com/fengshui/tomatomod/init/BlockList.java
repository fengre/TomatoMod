package com.fengshui.tomatomod.init;

import com.fengshui.tomatomod.Main;
import com.fengshui.tomatomod.blocks.TomatoCropsBlock;
import com.fengshui.tomatomod.blocks.WildTomatoBushBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockList {
        public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MOD_ID);

        public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
                () -> new TomatoCropsBlock(Block.Properties.create(Material.PLANTS)
                        .doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));

        public static final RegistryObject<Block> WILD_TOMATO_PLANT = BLOCKS.register("wild_tomato_plant",
                () -> new WildTomatoBushBlock(Block.Properties.create(Material.PLANTS)
                        .doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));


}
