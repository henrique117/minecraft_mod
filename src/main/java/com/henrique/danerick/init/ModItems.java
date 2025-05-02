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
    public static final RegistryObject<BlockItem> FIRE_ORE_ITEM = ITEMS.register("fire_ore", () -> new BlockItem(ModBlocks.FIRE_ORE.get(), new Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_FIRE_ORE_ITEM = ITEMS.register("deepslate_fire_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_FIRE_ORE.get(), new Properties()));

    public static final List<RegistryObject<? extends Item>> allItemsList = List.of(
        FIRE_INGOT,
        FIRE_ORE_ITEM,
        DEEPSLATE_FIRE_ORE_ITEM
    );

    public static final List<RegistryObject<? extends Item>> itemsList = List.of(
        FIRE_INGOT
    );

}