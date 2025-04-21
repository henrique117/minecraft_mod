package com.henrique.danerick.item;

import com.henrique.danerick.Danerick;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItem extends Item {

    private final String itemKey;

    public ModItem(Properties itemProperties, String itemKey) {
        super(itemProperties);
        this.itemKey = itemKey;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        componentList.add(Component.translatable("tooltip." + Danerick.MODID + "." + itemKey));
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
    }
}