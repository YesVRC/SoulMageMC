package com.yesmods.soulmage.setup;

import com.yesmods.soulmage.SoulMage;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.core.jmx.Server;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = SoulMage.MOD_ID)
public class Config {
    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_CLIENT = "client";

    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.IntValue INIT_MAX_SOUL;
    public static ForgeConfigSpec.IntValue INIT_SOUL_REGEN;

    public static ForgeConfigSpec.IntValue SOULBAR_X_OFFSET;
    public static ForgeConfigSpec.IntValue SOULBAR_Y_OFFSET;

    static{
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("Client Settings").push(CATEGORY_CLIENT);
        SOULBAR_X_OFFSET = CLIENT_BUILDER.comment("X offset for the Soul Bar").defineInRange("xSoulBar", 10, Integer.MIN_VALUE, Integer.MAX_VALUE);
        SOULBAR_Y_OFFSET = CLIENT_BUILDER.comment("Y offset for the Soul Bar").defineInRange("ySoulBar", 10, Integer.MIN_VALUE, Integer.MAX_VALUE);

        SERVER_BUILDER.comment("Server Settings").push(CATEGORY_GENERAL);
        INIT_MAX_SOUL = SERVER_BUILDER.comment("Default Max Soul Power").defineInRange("initMaxSoul", 1000, Integer.MIN_VALUE, Integer.MAX_VALUE);
        INIT_SOUL_REGEN = SERVER_BUILDER.comment("Default Soul Regen").defineInRange("initSoulRegen", 15, Integer.MIN_VALUE, Integer.MAX_VALUE);

        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();


    }

}
