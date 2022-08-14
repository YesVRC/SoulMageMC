package com.yesmods.soulmage.setup;

import com.yesmods.soulmage.client.SoulHudOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.minecraftforge.client.gui.ForgeIngameGui.HOTBAR_ELEMENT;
import static net.minecraftforge.client.gui.ForgeIngameGui.PLAYER_HEALTH_ELEMENT;

public class ClientSetup {

    public static void init(FMLClientSetupEvent event){

        OverlayRegistry.registerOverlayAbove(PLAYER_HEALTH_ELEMENT, "soulPower", SoulHudOverlay.HUD_SOUL);

    }
}
