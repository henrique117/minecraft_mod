package com.henrique.danerick.init;

import com.henrique.danerick.Danerick;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB, Danerick.MODID);

    public static final RegistryObject<CreativeModeTab> DANERICK_TAB = TABS.register("danerick_tab", () -> CreativeModeTab.builder()
        .title(Component.translatable("item_group." + Danerick.MODID + ".danerick_tab"))
        .icon(() -> new ItemStack(ModItems.FIRE_INGOT.get()))
        .displayItems((params, output) -> {
            for (RegistryObject<?> item : ModItems.itemsList) {
                Object obj = item.get();
                if (obj instanceof Item) output.accept((Item) obj);
            }
        })
        .build());

}