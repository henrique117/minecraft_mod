package com.henrique.danerick.init;

import java.util.List;

import com.henrique.danerick.Danerick;
import com.henrique.danerick.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Danerick.MODID);

    public static final RegistryObject<Block> NORMAL_FIRE_ORE = BLOCKS.register("normal_fire_ore",
        () -> new NormalFireOre(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> NORMAL_DEEPSLATE_FIRE_ORE = BLOCKS.register("normal_deepslate_fire_ore",
        () -> new NormalFireOre(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final RegistryObject<Block> BOOSTED_FIRE_ORE = BLOCKS.register("boosted_fire_ore",
        () -> new BoostedFireOre(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    public static final RegistryObject<Block> NORMAL_WATER_ORE = BLOCKS.register("normal_water_ore",
        () -> new NormalWaterOre(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> BOOSTED_WATER_ORE = BLOCKS.register("boosted_water_ore",
        () -> new BoostedWaterOre(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<Block> BOOSTED_ELETRIC_ORE = BLOCKS.register("boosted_eletric_ore",
        () -> new BoostedEletricOre(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));

    public static final List<RegistryObject<Block>> blocksList = List.of(
        NORMAL_FIRE_ORE,
        NORMAL_WATER_ORE,
        NORMAL_DEEPSLATE_FIRE_ORE,
        BOOSTED_FIRE_ORE,
        BOOSTED_WATER_ORE,
        BOOSTED_ELETRIC_ORE
    );
}