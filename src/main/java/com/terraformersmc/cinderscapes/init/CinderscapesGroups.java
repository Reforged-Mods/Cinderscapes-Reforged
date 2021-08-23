package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

// Contains the item groups added by Cinderscapes
public class CinderscapesGroups {
    // Registers the item group added by Cinderscapes
    public static final CinderscapesItemGroup ITEMS = new CinderscapesItemGroup();
    public static void init() {
    }

    public static class CinderscapesItemGroup extends ItemGroup {

        public CinderscapesItemGroup() {
            super(Cinderscapes.ID + ".items");
        }

        @Override
        public ItemStack createIcon() {
            return CinderscapesBlocks.UMBRAL_FUNGUS.asItem().getDefaultStack();
        }

        public void appendStacks(DefaultedList<ItemStack> list) {
            Registry.ITEM.stream().filter((item) -> {
                return Registry.ITEM.getId(item).getNamespace().equals(Cinderscapes.ID);
            }).forEach((item) -> list.add(new ItemStack(item)));
        }

    }
}
