package com.henrique.danerick.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class BoostedEarthOre extends Block {

    private static final float EARTH_POISON_RADIUS = 5F;

    public BoostedEarthOre(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        super.stepOn(level, blockPos, blockState, entity);

        if (entity instanceof LivingEntity livingEntity) {
            MobEffectInstance effect1 = new MobEffectInstance(MobEffects.CONFUSION, 200, 0);
            MobEffectInstance effect2 = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0);

            livingEntity.addEffect(effect1);
            livingEntity.addEffect(effect2);
        }
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        AreaEffectCloud poisonCloud = new AreaEffectCloud(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        poisonCloud.setRadius(EARTH_POISON_RADIUS);
        poisonCloud.setDuration(200);
        poisonCloud.setWaitTime(20);
        poisonCloud.setRadiusPerTick(-0.02F);

        MobEffectInstance effect = new MobEffectInstance(MobEffects.POISON, 180, 0);

        poisonCloud.addEffect(effect);

        level.addFreshEntity(poisonCloud);

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}