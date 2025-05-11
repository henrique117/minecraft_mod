package com.henrique.danerick.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

@SuppressWarnings("deprecation")
public class BoostedWaterOre extends Block {

    public BoostedWaterOre(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public void onPlace(BlockState blockState, Level serverLevel, BlockPos blockPos, BlockState oldState, boolean bool) {
        super.onPlace(blockState, serverLevel, blockPos, oldState, bool);

        serverLevel.scheduleTick(blockPos, this, 20);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        super.tick(blockState, serverLevel, blockPos, randomSource);

        Player player = serverLevel.getNearestPlayer(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 2, player1 -> true);

        if (player != null && player.isUnderWater()) {
            int playerAirSupply = player.getAirSupply();
            int playerMaxAirSupply = player.getMaxAirSupply();

            int newAirSupply = Math.max((int) Math.round(playerAirSupply - playerMaxAirSupply * 0.2), 0);

            player.setAirSupply(newAirSupply);
        }

        serverLevel.scheduleTick(blockPos, this, 20);
    }

    @Override
    public boolean isRandomlyTicking(BlockState p_49921_) {
        return true;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        MobEffectInstance effect1 = new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 500, 1);
        MobEffectInstance effect2 = new MobEffectInstance(MobEffects.BLINDNESS, 500, 1);

        player.addEffect(effect1);
        player.addEffect(effect2);

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}