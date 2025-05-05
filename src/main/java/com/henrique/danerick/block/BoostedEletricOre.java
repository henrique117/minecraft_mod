package com.henrique.danerick.block;

import com.henrique.danerick.init.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class BoostedEletricOre extends Block {

    private static final double ELETRIC_PLAYER_SEARCH_RADIUS = 7.0;

    public BoostedEletricOre(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        super.stepOn(level, blockPos, blockState, entity);

        MobEffectInstance effect = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 2);

        if (!level.isClientSide() && entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(effect);
        }
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        List<LivingEntity> livingEntitiesNearby = getLivingEntitiesNearby(level, pos);
        MobEffectInstance effect = new MobEffectInstance(ModEffects.PARALYSIS_EFFECT.get(), 60, 0);

        for (LivingEntity entity : livingEntitiesNearby) {
            entity.addEffect(effect);
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    private List<LivingEntity> getLivingEntitiesNearby(Level level, BlockPos center) {
        AABB box = new AABB(
    center.getX() - ELETRIC_PLAYER_SEARCH_RADIUS, center.getY() - ELETRIC_PLAYER_SEARCH_RADIUS, center.getZ() - ELETRIC_PLAYER_SEARCH_RADIUS,
    center.getX() + ELETRIC_PLAYER_SEARCH_RADIUS + 1, center.getY() + ELETRIC_PLAYER_SEARCH_RADIUS + 1, center.getZ() + ELETRIC_PLAYER_SEARCH_RADIUS + 1
        );

        return level.getEntitiesOfClass(LivingEntity.class, box);
    }
}