package com.henrique.danerick.block;

import com.henrique.danerick.init.ModEffects;
import com.henrique.danerick.util.AuxFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import java.util.List;

public class NormalEletricOre extends Block {

    private static final double ELETRIC_PLAYER_SEARCH_RADIUS = 4.0;

    public NormalEletricOre(Properties properties) {
        super(properties);
    }

    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        List<LivingEntity> livingEntitiesNearby = AuxFunctions.getLivingEntitiesNearby(level, pos, ELETRIC_PLAYER_SEARCH_RADIUS);
        MobEffectInstance effect = new MobEffectInstance(ModEffects.PARALYSIS_EFFECT.get(), 40, 0);

        for (LivingEntity entity : livingEntitiesNearby) {
            entity.addEffect(effect);
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
