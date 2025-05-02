package com.henrique.danerick.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BoostedFireOre extends Block {
    public BoostedFireOre(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        super.stepOn(level, blockPos, blockState, entity);

        entity.setSecondsOnFire(6);
    }
}