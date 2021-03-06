package com.fengshui.tomatomod.init;

import com.fengshui.tomatomod.Main;
import com.fengshui.tomatomod.items.TomatoSoupItem;
import com.fengshui.tomatomod.items.TomatoItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemList {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new BlockNamedItem(BlockList.TOMATO_CROP.get(),
                    new Item.Properties().group(Main.TAB)));

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new TomatoItem(new Item.Properties().group(Main.TAB)
                    .food(new Food.Builder().hunger(3).saturation(3.0f).build())));

    public static final RegistryObject<Item> TOMATO_SOUP = ITEMS.register("tomato_soup",
            () -> new TomatoSoupItem(new Item.Properties().group(Main.TAB)
                    .food(new Food.Builder().hunger(6).saturation(4.0f).build())));
}
