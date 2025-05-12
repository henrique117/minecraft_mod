package com.henrique.danerick.block;

import com.henrique.danerick.util.AuxFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class NormalEndwarpOre extends Block {

    public NormalEndwarpOre(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        ItemStack currentItem = player.getMainHandItem();

        if (currentItem.is(ItemTags.TOOLS)) {
            AuxFunctions.addRandomCurse(currentItem);
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}