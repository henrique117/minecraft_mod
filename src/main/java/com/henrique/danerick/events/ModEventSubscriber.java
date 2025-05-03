package com.henrique.danerick.events;

import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEventSubscriber {

    public static void register(IEventBus eventBus) {
        eventBus.addListener(ModEventSubscriber::onWorldLoad);
    }

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        System.out.println("Mundo carregado!");
    }
}
