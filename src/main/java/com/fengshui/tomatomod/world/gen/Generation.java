package com.fengshui.tomatomod.world.gen;

import com.fengshui.tomatomod.blocks.TomatoCropsBlock;
import com.fengshui.tomatomod.init.BlockList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class Generation {
    public static final BlockClusterFeatureConfig WILD_TOMATO_CONFIG = (new BlockClusterFeatureConfig
            .Builder(new SimpleBlockStateProvider(BlockList.WILD_TOMATO_PLANT.get().getDefaultState()),
            new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock()))
            .func_227317_b_().build();

    public static void generateTomato() {
        ForgeRegistries.BIOMES.forEach(biome -> {
            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                    Feature.RANDOM_PATCH.withConfiguration(WILD_TOMATO_CONFIG)
                            .withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
        });
    }

}
