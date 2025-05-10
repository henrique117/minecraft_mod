package com.henrique.danerick.block;

import com.henrique.danerick.util.AuxFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;

import java.util.List;

@SuppressWarnings("deprecation")
public class BoostedEndwarpOre extends Block {

    private static final int ENDWARP_LEVITATION_RANGE = 7;

    public BoostedEndwarpOre(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        for (ItemStack armorPiece : player.getArmorSlots()) {
            AuxFunctions.addAllCurses(armorPiece);
        }

        for (ItemStack item : player.getInventory().items) {
            if (item.is(ItemTags.TOOLS)) {
                AuxFunctions.addAllCurses(item);
            }
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public void onPlace(BlockState blockState, Level serverLevel, BlockPos blockPos, BlockState oldState, boolean bool) {
        super.onPlace(blockState, serverLevel, blockPos, oldState, bool);

        serverLevel.scheduleTick(blockPos, this, 5);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        super.tick(blockState, serverLevel, blockPos, randomSource);

        AABB checkBox = new AABB(
            blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(),
    blockPos.getX() + 1, blockPos.getY() + 1 + ENDWARP_LEVITATION_RANGE, blockPos.getZ() + 1
        );

        List<LivingEntity> entitiesAbove = serverLevel.getEntitiesOfClass(LivingEntity.class, checkBox);

        if (!entitiesAbove.isEmpty()) {
            for (LivingEntity entity : entitiesAbove) {
                entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 0));
            }
        }

        serverLevel.scheduleTick(blockPos, this, 5);
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return true;
    }
}
