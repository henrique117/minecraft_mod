package com.henrique.danerick;

import com.henrique.danerick.init.ModBlocks;
import com.henrique.danerick.init.ModCreativeTabs;
import com.henrique.danerick.init.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Danerick.MODID)
public class Danerick {

    public static final String MODID = "danerick";

    public Danerick() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
    }
}