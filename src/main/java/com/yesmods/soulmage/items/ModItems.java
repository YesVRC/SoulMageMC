package com.yesmods.soulmage.items;

import com.yesmods.soulmage.SoulMage;
import com.yesmods.soulmage.items.custom.CrimsonCruxItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.event.InputEvent;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SoulMage.MOD_ID);

    public static final RegistryObject<Item> TEST = ITEMS.register("testitem", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CRIMSON_CRUX = ITEMS.register("crimson_crux", () -> CrimsonCruxItem.INSTANCE);
    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }

}
