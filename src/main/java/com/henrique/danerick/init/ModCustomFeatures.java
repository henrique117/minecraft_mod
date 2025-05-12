package com.henrique.danerick.init;

import com.henrique.danerick.Danerick;
import com.henrique.danerick.features.BoostedFireOreFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCustomFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Danerick.MODID);

    public static final RegistryObject<Feature<OreConfiguration>> BOOSTED_FIRE_ORE_FEATURE =
        FEATURES.register("boosted_fire_ore_feature", () -> new BoostedFireOreFeature(OreConfiguration.CODEC));
}