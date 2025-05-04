package com.henrique.danerick.effects;

import com.henrique.danerick.init.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class ParalysisEffect extends MobEffect {
    public ParalysisEffect() {
        super(MobEffectCategory.HARMFUL, 0xAAAAAA);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        super.applyEffectTick(entity, amplifier);

        entity.setDeltaMovement(Vec3.ZERO);
        entity.hasImpulse = false;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    public static boolean isParalyzed(Player player) {
        return player.hasEffect(ModEffects.PARALYSIS_EFFECT.get());
    }
}