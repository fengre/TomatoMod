package com.fengshui.tomatomod;

import com.fengshui.tomatomod.client.RenderTomatoFactory;
import com.fengshui.tomatomod.init.EntityList;
import com.fengshui.tomatomod.init.BlockList;
import com.fengshui.tomatomod.init.ItemList;
import com.fengshui.tomatomod.world.gen.Generation;
import net.minecraft.block.ComposterBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MOD_ID)
@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Main
{
    public static Main instance;
    // The value here should match an entry in the META-INF/mods.toml file
    public static final String MOD_ID = "tomatomod";
    public static final ItemGroup TAB = new Main.ModItemGroup("mod_group");
    private static final Logger LOGGER = LogManager.getLogger();

    public Main() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemList.ITEMS.register(modEventBus);
        BlockList.BLOCKS.register(modEventBus);
        EntityList.ENTITY_TYPES.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ComposterBlock.CHANCES.put(ItemList.TOMATO.get(), 0.65F);
        ComposterBlock.CHANCES.put(ItemList.TOMATO_SEEDS.get(), 0.3F);
        Generation.generateTomato();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockList.TOMATO_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockList.WILD_TOMATO_PLANT.get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(EntityList.TOMATO.get(), new RenderTomatoFactory());
    }

    public static class ModItemGroup extends ItemGroup {

        public ModItemGroup(String name) {
            super(name);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.TOMATO.get());
        }

    }

}
