package com.fengshui.tomatomod.init;

import com.fengshui.tomatomod.Main;
import com.fengshui.tomatomod.items.ModdingToolItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemList {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> MODDING_TOOL = ITEMS.register("modding_tool",
            () -> new ModdingToolItem(new Item.Properties().group(Main.TAB)));
}
