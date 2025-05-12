package com.henrique.danerick.datagen;

import com.henrique.danerick.Danerick;
import com.henrique.danerick.worldgen.ModBiomeModifiers;
import com.henrique.danerick.worldgen.ModConfiguredFeatures;
import com.henrique.danerick.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
        .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
        .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Danerick.MODID));
    }
}
