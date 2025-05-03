package com.henrique.danerick.datagen;

import com.henrique.danerick.Danerick;
import com.henrique.danerick.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Danerick.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        List<Block> mineableWithPickaxeList = List.of(
            ModBlocks.NORMAL_FIRE_ORE.get(),
            ModBlocks.NORMAL_DEEPSLATE_FIRE_ORE.get(),
            ModBlocks.BOOSTED_FIRE_ORE.get(),
            ModBlocks.BOOSTED_WATER_ORE.get()
        );

        List<Block> needsDiamondToolList = List.of(
            ModBlocks.NORMAL_FIRE_ORE.get(),
            ModBlocks.NORMAL_DEEPSLATE_FIRE_ORE.get(),
            ModBlocks.BOOSTED_FIRE_ORE.get(),
            ModBlocks.BOOSTED_WATER_ORE.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(mineableWithPickaxeList.toArray(new Block[0]));
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(needsDiamondToolList.toArray(new Block[0]));
    }
}