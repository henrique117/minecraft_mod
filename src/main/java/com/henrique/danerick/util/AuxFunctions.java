package com.henrique.danerick.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class AuxFunctions {
    public static BlockPos hasFlammableNearby(ServerLevel level, BlockPos pos, int radius) {
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
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

    public static boolean isOnFire(ServerLevel level, BlockPos pos) {
        BlockPos above = pos.above();
        return level.getBlockState(above).is(Blocks.FIRE);
    }

    public static boolean hasWaterNearby(ServerLevel level, BlockPos pos) {
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

    public static void dryNearbyWater(ServerLevel level, BlockPos pos, int radius) {
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    BlockPos checkPos = pos.offset(dx, dy, dz);
                    BlockState state = level.getBlockState(checkPos);

                    if (state.getFluidState().is(Fluids.WATER)) {
                        level.setBlock(checkPos, Blocks.AIR.defaultBlockState(), 3);
                    }
                }
            }
        }
    }

    public static List<LivingEntity> getLivingEntitiesNearby(Level level, BlockPos center, double radius) {
        AABB box = new AABB(
    center.getX() - radius, center.getY() - radius, center.getZ() - radius,
    center.getX() + radius + 1, center.getY() + radius + 1, center.getZ() + radius + 1
        );

        return level.getEntitiesOfClass(LivingEntity.class, box);
    }
}
