package com.henrique.danerick.datagen;

import com.henrique.danerick.Danerick;
import com.henrique.danerick.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Danerick.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : ModItems.itemsList) {
            simpleItem((RegistryObject<Item>) item);
        }
    }

    private void simpleItem(RegistryObject<Item> item) {
        assert item.getId() != null;
        withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(Danerick.MODID,"item/" + item.getId().getPath()));
    }
}
