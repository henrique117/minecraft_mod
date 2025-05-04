package com.henrique.danerick.block;

import com.henrique.danerick.init.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;

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

        List<Player> playerNearby = getPlayersNearby(level, pos);
        MobEffectInstance effect = new MobEffectInstance(ModEffects.PARALYSIS_EFFECT.get(), 40, 0);

        for (Player player1 : playerNearby) {
            player1.addEffect(effect);
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    private List<Player> getPlayersNearby(Level level, BlockPos center) {
        AABB box = new AABB(
    center.getX() - ELETRIC_PLAYER_SEARCH_RADIUS, center.getY() - ELETRIC_PLAYER_SEARCH_RADIUS, center.getZ() - ELETRIC_PLAYER_SEARCH_RADIUS,
    center.getX() + ELETRIC_PLAYER_SEARCH_RADIUS + 1, center.getY() + ELETRIC_PLAYER_SEARCH_RADIUS + 1, center.getZ() + ELETRIC_PLAYER_SEARCH_RADIUS + 1
        );

        return level.getEntitiesOfClass(Player.class, box);
    }
}
