package com.henrique.danerick.init;

import java.util.List;

import com.henrique.danerick.Danerick;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Danerick.MODID);

    public static final RegistryObject<Block> FIRE_ORE = BLOCKS.register("fire_ore",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_FIRE_ORE = BLOCKS.register("deepslate_fire_ore",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    public static final List<RegistryObject<Block>> blocksList = List.of(
        FIRE_ORE,
        DEEPSLATE_FIRE_ORE
    );
}