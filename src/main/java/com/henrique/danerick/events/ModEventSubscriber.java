package com.henrique.danerick.events;

import com.henrique.danerick.effects.ParalysisEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEventSubscriber {

    public static void register(IEventBus eventBus) {
        eventBus.addListener(ModEventSubscriber::onWorldLoad);
        eventBus.addListener(ModEventSubscriber::onPlayerAttack);
        eventBus.addListener(ModEventSubscriber::onBlockBreakSpeed);
    }

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        System.out.println("Mundo carregado!");
    }

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (ParalysisEffect.isParalyzed(player)) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onBlockBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (event.getEntity() instanceof Player player) {
            if (ParalysisEffect.isParalyzed(player)) {
                event.setCanceled(true);
            }
        }
    }
}