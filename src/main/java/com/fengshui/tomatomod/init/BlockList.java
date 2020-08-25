package com.fengshui.tomatomod.init;

import com.fengshui.tomatomod.Main;
import com.fengshui.tomatomod.blocks.TomatoCropsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockList {
        public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MOD_ID);
        public static final DeferredRegister<Block> NO_ITEM_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MOD_ID);

        public static final RegistryObject<Block> TOMATO_CROP = NO_ITEM_BLOCKS.register("tomato_crop",
                () -> new TomatoCropsBlock(Block.Properties.create(Material.PLANTS)
                        .doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
}
