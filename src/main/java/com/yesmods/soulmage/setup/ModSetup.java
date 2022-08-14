package com.yesmods.soulmage.setup;

import com.yesmods.soulmage.events.ModEvents;
import com.yesmods.soulmage.items.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;



public class ModSetup {

    public static void init(FMLCommonSetupEvent event){
        Messages.register();
    }

    public static void setup(){
        IEventBus bus = MinecraftForge.EVENT_BUS;

        bus.addGenericListener(Entity.class, ModEvents::onAttachCapabilitiesPlayer);
        bus.addListener(ModEvents::onWorldTick);
        bus.addListener(ModEvents::onLivingDamage);
        bus.addListener(ModEvents::onPlayerCloned);
        bus.addListener(ModEvents::onRegisterCapabilities);

        ModItems.register(bus);

    }

}
