package com.henrique.danerick.datagen;

import com.henrique.danerick.Danerick;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFutureHolder, CompletableFuture<TagLookup<Block>> completableFutureTag, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFutureHolder, completableFutureTag, Danerick.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
