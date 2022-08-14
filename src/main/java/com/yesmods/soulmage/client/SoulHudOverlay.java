package com.yesmods.soulmage.client;

import com.yesmods.soulmage.setup.Config;
import net.minecraftforge.client.gui.IIngameOverlay;

public class SoulHudOverlay{



    public static final IIngameOverlay HUD_SOUL = ((gui, poseStack, partialTick, width, height) -> {
       //int x = width/2;
       //int y = height;

       String toDisplay = PlayerSoulClientData.getPlayerSoul() + " / " + (PlayerSoulClientData.getPlayerSoul() * PlayerSoulClientData.getPlayerSoulTier());
       gui.getFont().draw(poseStack, toDisplay, Config.SOULBAR_X_OFFSET.get(), Config.SOULBAR_Y_OFFSET.get(), 0xffffffff);
    });
}
