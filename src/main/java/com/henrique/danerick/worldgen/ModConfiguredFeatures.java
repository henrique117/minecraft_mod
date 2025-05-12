package com.henrique.danerick.worldgen;

import com.henrique.danerick.Danerick;
import com.henrique.danerick.init.ModBlocks;
import com.henrique.danerick.init.ModCustomFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOOSTED_FIRE_ORE_KEY = registerKey("boosted_fire_ore_key");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest netherrackRepleacables = new TagMatchTest(BlockTags.NETHER_CARVER_REPLACEABLES);

        register(context, BOOSTED_FIRE_ORE_KEY, ModCustomFeatures.BOOSTED_FIRE_ORE_FEATURE.get(), new OreConfiguration(netherrackRepleacables, ModBlocks.BOOSTED_FIRE_ORE.get().defaultBlockState(), 9));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Danerick.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}