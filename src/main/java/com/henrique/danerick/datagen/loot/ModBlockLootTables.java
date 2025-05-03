package com.henrique.danerick.datagen.loot;

import com.henrique.danerick.init.ModBlocks;
import com.henrique.danerick.init.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.add(ModBlocks.NORMAL_FIRE_ORE.get(),
        block -> createRawNormalOreDrops(ModBlocks.NORMAL_FIRE_ORE.get(), ModItems.FIRE_SHARD.get()));
        this.add(ModBlocks.NORMAL_DEEPSLATE_FIRE_ORE.get(),
        block -> createRawNormalOreDrops(ModBlocks.NORMAL_DEEPSLATE_FIRE_ORE.get(), ModItems.FIRE_SHARD.get()));

        this.add(ModBlocks.BOOSTED_FIRE_ORE.get(),
        block -> createRawBoostedOreDrops(ModBlocks.BOOSTED_FIRE_ORE.get(), ModItems.FIRE_SHARD.get()));
        this.add(ModBlocks.BOOSTED_WATER_ORE.get(),
        block -> createRawBoostedOreDrops(ModBlocks.BOOSTED_WATER_ORE.get(), ModItems.WATER_SHARD.get()));
    }

    protected LootTable.Builder createRawNormalOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
            this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createRawBoostedOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
            this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 5.0F)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}