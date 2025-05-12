package com.henrique.danerick.features;

import com.henrique.danerick.init.ModBlocks;
import com.henrique.danerick.util.AuxFunctions;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class BoostedFireOreFeature extends Feature<OreConfiguration> {

    public BoostedFireOreFeature(Codec<OreConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<OreConfiguration> context) {
        OreConfiguration config = context.config();
        BlockPos origin = context.origin();
        LevelAccessor level = context.level();
        RandomSource random = context.random();

        int size = config.size;
        int placed = 0;

        for (int i = 0; i < size; i++) {
            BlockPos offsetPos = origin.offset(
        random.nextInt(3) - 1,
        random.nextInt(3) - 1,
        random.nextInt(3) - 1
            );

            BlockState currentState = level.getBlockState(offsetPos);
            for (OreConfiguration.TargetBlockState target : config.targetStates) {
                if (target.target.test(currentState, random)) {
                    if (AuxFunctions.hasLavaNearby(level, offsetPos)) {
                        level.setBlock(offsetPos, target.state, 2);
                        placed++;
                    }
                    break;
                }
            }
        }

        return placed > 0;
    }
}