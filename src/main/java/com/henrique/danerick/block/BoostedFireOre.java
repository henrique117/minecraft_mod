package com.henrique.danerick.block;

import com.henrique.danerick.util.AuxFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

@SuppressWarnings("deprecation")
public class BoostedFireOre extends Block {

    private static final int FIRE_SEARCH_RADIUS = 5;
    private static final int FIRE_DRY_RADIUS = 7;
    private static final float FIRE_EXPLOSION_POWER = 4.0F;

    public BoostedFireOre(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public void onPlace(BlockState blockState, Level serverLevel, BlockPos blockPos, BlockState oldState, boolean bool) {
        super.onPlace(blockState, serverLevel, blockPos, oldState, bool);

        serverLevel.scheduleTick(blockPos, this, 5);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        super.tick(blockState, serverLevel, blockPos, randomSource);

        BlockPos flammableBlock = AuxFunctions.hasFlammableNearby(serverLevel, blockPos, FIRE_SEARCH_RADIUS);

        if (flammableBlock != null && !AuxFunctions.isOnFire(serverLevel, flammableBlock)) {
            serverLevel.setBlock(flammableBlock, Blocks.FIRE.defaultBlockState(), 11);
        }

        if(AuxFunctions.hasWaterNearby(serverLevel, blockPos)) {
            AuxFunctions.dryNearbyWater(serverLevel, blockPos, FIRE_DRY_RADIUS);
            explodeBlock(serverLevel, blockPos);
        }

        serverLevel.scheduleTick(blockPos, this, 5);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        super.stepOn(level, blockPos, blockState, entity);

        entity.setSecondsOnFire(10);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        ItemStack currentItem = player.getMainHandItem();

        if (currentItem.is(ItemTags.TOOLS)) {
            currentItem.hurtAndBreak(currentItem.getMaxDamage() - currentItem.getDamageValue(), player, player1 -> player1.broadcastBreakEvent(player1.getUsedItemHand()));
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return true;
    }

    private void explodeBlock(ServerLevel level, BlockPos pos) {
        level.explode(null, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, FIRE_EXPLOSION_POWER, Level.ExplosionInteraction.BLOCK);
    }
}