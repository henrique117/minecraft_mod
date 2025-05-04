package com.henrique.danerick.init;

import com.henrique.danerick.Danerick;
import com.henrique.danerick.effects.ParalysisEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Danerick.MODID);

    public static final RegistryObject<MobEffect> PARALYSIS_EFFECT = EFFECTS.register("paralysis_effect", ParalysisEffect::new);
}
