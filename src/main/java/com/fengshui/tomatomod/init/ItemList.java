package com.fengshui.tomatomod.init;

import com.fengshui.tomatomod.Main;
import com.fengshui.tomatomod.items.ModdingToolItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemList {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> MODDING_TOOL = ITEMS.register("modding_tool",
            () -> new ModdingToolItem(new Item.Properties().group(Main.TAB)));

    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_crop",
            () -> new BlockItem(BlockList.TOMATO_CROP.get(),
                    new Item.Properties().group(Main.TAB)));

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().group(Main.TAB)
                    .food(new Food.Builder().hunger(4).saturation(3.0f).build())));
}
