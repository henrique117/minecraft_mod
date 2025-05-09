package com.henrique.danerick.init;

import java.util.List;

import com.henrique.danerick.Danerick;

import com.henrique.danerick.item.ModItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Danerick.MODID);

    public static final RegistryObject<Item> FIRE_INGOT = ITEMS.register("fire_ingot", () -> new ModItem(new Properties(), "fire_ingot"));
    public static final RegistryObject<Item> WATER_INGOT = ITEMS.register("water_ingot", () -> new ModItem(new Properties(), "water_ingot"));
    public static final RegistryObject<Item> ELETRIC_INGOT = ITEMS.register("eletric_ingot", () -> new ModItem(new Properties(), "eletric_ingot"));
    public static final RegistryObject<Item> EARTH_INGOT = ITEMS.register("earth_ingot", () -> new ModItem(new Properties(), "earth_ingot"));

    public static final RegistryObject<Item> FIRE_SHARD = ITEMS.register("fire_shard", () -> new ModItem(new Properties(), "fire_shard"));
    public static final RegistryObject<Item> WATER_SHARD = ITEMS.register("water_shard", () -> new ModItem(new Properties(), "water_shard"));
    public static final RegistryObject<Item> ELETRIC_SHARD = ITEMS.register("eletric_shard", () -> new ModItem(new Properties(), "eletric_shard"));
    public static final RegistryObject<Item> EARTH_SHARD = ITEMS.register("earth_shard", () -> new ModItem(new Properties(), "earth_shard"));

    public static final RegistryObject<BlockItem> NORMAL_FIRE_ORE_ITEM = ITEMS.register("normal_fire_ore", () -> new BlockItem(ModBlocks.NORMAL_FIRE_ORE.get(), new Properties()));
    public static final RegistryObject<BlockItem> NORMAL_WATER_ORE_ITEM = ITEMS.register("normal_water_ore", () -> new BlockItem(ModBlocks.NORMAL_WATER_ORE.get(), new Properties()));
    public static final RegistryObject<BlockItem> NORMAL_ELETRIC_ORE_ITEM = ITEMS.register("normal_eletric_ore", () -> new BlockItem(ModBlocks.NORMAL_ELETRIC_ORE.get(), new Properties()));
    public static final RegistryObject<BlockItem> NORMAL_EARTH_ORE_ITEM = ITEMS.register("normal_earth_ore", () -> new BlockItem(ModBlocks.NORMAL_EARTH_ORE.get(), new Properties()));
    public static final RegistryObject<BlockItem> NORMAL_DEEPSLATE_FIRE_ORE_ITEM = ITEMS.register("normal_deepslate_fire_ore", () -> new BlockItem(ModBlocks.NORMAL_DEEPSLATE_FIRE_ORE.get(), new Properties()));
    public static final RegistryObject<BlockItem> BOOSTED_FIRE_ORE_ITEM = ITEMS.register("boosted_fire_ore", () -> new BlockItem(ModBlocks.BOOSTED_FIRE_ORE.get(), new Properties()));
    public static final RegistryObject<BlockItem> BOOSTED_WATER_ORE_ITEM = ITEMS.register("boosted_water_ore", () -> new BlockItem(ModBlocks.BOOSTED_WATER_ORE.get(), new Properties()));
    public static final RegistryObject<BlockItem> BOOSTED_ELETRIC_ORE_ITEM = ITEMS.register("boosted_eletric_ore", () -> new BlockItem(ModBlocks.BOOSTED_ELETRIC_ORE.get(), new Properties()));
    public static final RegistryObject<BlockItem> BOOSTED_EARTH_ORE_ITEM = ITEMS.register("boosted_earth_ore", () -> new BlockItem(ModBlocks.BOOSTED_EARTH_ORE.get(), new Properties()));

    public static final List<RegistryObject<? extends Item>> allItemsList = List.of(
        FIRE_INGOT,
        WATER_INGOT,
        ELETRIC_INGOT,
        EARTH_INGOT,
        FIRE_SHARD,
        WATER_SHARD,
        ELETRIC_SHARD,
        EARTH_SHARD,
        NORMAL_FIRE_ORE_ITEM,
        NORMAL_WATER_ORE_ITEM,
        NORMAL_ELETRIC_ORE_ITEM,
        NORMAL_EARTH_ORE_ITEM,
        NORMAL_DEEPSLATE_FIRE_ORE_ITEM,
        BOOSTED_FIRE_ORE_ITEM,
        BOOSTED_WATER_ORE_ITEM,
        BOOSTED_ELETRIC_ORE_ITEM,
        BOOSTED_EARTH_ORE_ITEM
    );

    public static final List<RegistryObject<Item>> itemsList = List.of(
        FIRE_SHARD,
        WATER_SHARD,
        ELETRIC_SHARD,
        EARTH_SHARD,
        FIRE_INGOT,
        WATER_INGOT,
        ELETRIC_INGOT,
        EARTH_INGOT
    );
}