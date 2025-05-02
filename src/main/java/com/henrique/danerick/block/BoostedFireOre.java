package com.henrique.danerick.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class BoostedFireOre extends Block {
    public BoostedFireOre(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        super.stepOn(level, blockPos, blockState, entity);

        entity.setSecondsOnFire(6);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        ItemStack currentItem = player.getMainHandItem();

        if (currentItem.is(ItemTags.TOOLS)) {
            currentItem.hurtAndBreak(currentItem.getMaxDamage() - currentItem.getDamageValue(), player, player1 -> player1.broadcastBreakEvent(player1.getUsedItemHand()));
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}