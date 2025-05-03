package com.henrique.danerick.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.material.Fluids;

@SuppressWarnings("deprecation")
public class BoostedFireOre extends Block {

    private static final int FIRE_SEARCH_RADIUS = 4;
    private static final int FIRE_DRY_RADIUS = 7;
    private static final float FIRE_EXPLOSION_POWER = 3.0F;

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

        serverLevel.scheduleTick(blockPos, this, 20);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        super.tick(blockState, serverLevel, blockPos, randomSource);

        BlockPos flammableBlock = hasFlammableNearby(serverLevel, blockPos);

        if (flammableBlock != null && !isOnFire(serverLevel, flammableBlock)) {
            serverLevel.setBlock(flammableBlock, Blocks.FIRE.defaultBlockState(), 11);
        }

        if(hasWaterNearby(serverLevel, blockPos)) {
            dryNearbyWater(serverLevel, blockPos);
            explodeBlock(serverLevel, blockPos);
        }

        serverLevel.scheduleTick(blockPos, this, 10);
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

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return true;
    }

    private BlockPos hasFlammableNearby(ServerLevel level, BlockPos pos) {
        for (int dx = -FIRE_SEARCH_RADIUS; dx <= FIRE_SEARCH_RADIUS; dx++) {
            for (int dy = -FIRE_SEARCH_RADIUS; dy <= FIRE_SEARCH_RADIUS; dy++) {
                for (int dz = -FIRE_SEARCH_RADIUS; dz <= FIRE_SEARCH_RADIUS; dz++) {
                    BlockPos checkPos = pos.offset(dx, dy, dz);
                    BlockState state = level.getBlockState(checkPos);

                    if (state.isFlammable(level, checkPos, Direction.UP)) {
                        BlockPos firePos = checkPos.above();

                        if (level.getBlockState(firePos).isAir()) {
                            return firePos;
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean isOnFire(ServerLevel level, BlockPos pos) {
        BlockPos above = pos.above();
        return level.getBlockState(above).is(Blocks.FIRE);
    }

    private boolean hasWaterNearby(ServerLevel level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (direction != Direction.DOWN) {
                BlockPos neighborPos = pos.relative(direction);
                BlockState neighborState = level.getBlockState(neighborPos);

                if (neighborState.getFluidState().is(Fluids.WATER)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dryNearbyWater(ServerLevel level, BlockPos pos) {
        for (int dx = -FIRE_DRY_RADIUS; dx <= FIRE_DRY_RADIUS; dx++) {
            for (int dy = -FIRE_DRY_RADIUS; dy <= FIRE_DRY_RADIUS; dy++) {
                for (int dz = -FIRE_DRY_RADIUS; dz <= FIRE_DRY_RADIUS; dz++) {
                    BlockPos checkPos = pos.offset(dx, dy, dz);
                    BlockState state = level.getBlockState(checkPos);

                    if (state.getFluidState().is(Fluids.WATER)) {
                        level.setBlock(checkPos, Blocks.AIR.defaultBlockState(), 3);
                    }
                }
            }
        }
    }

    private void explodeBlock(ServerLevel level, BlockPos pos) {
        level.explode(null, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, FIRE_EXPLOSION_POWER, Level.ExplosionInteraction.BLOCK);
    }
}