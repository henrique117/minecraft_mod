package com.henrique.danerick.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class NormalWaterOre extends Block {
    public NormalWaterOre(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        MobEffectInstance effect = new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0);

        player.addEffect(effect);

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
