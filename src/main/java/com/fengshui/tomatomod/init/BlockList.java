package com.fengshui.tomatomod.init;

import com.fengshui.tomatomod.Main;
import net.minecraft.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockList {
        public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MOD_ID);
        public static final DeferredRegister<Block> NO_ITEM_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MOD_ID);
}
