package com.yesmods.soulmage;

import com.yesmods.soulmage.setup.ClientSetup;
import com.yesmods.soulmage.setup.Config;
import com.yesmods.soulmage.setup.ModSetup;
import com.yesmods.soulmage.setup.Registration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(SoulMage.MOD_ID)
public class SoulMage
{
    // Directly reference a log4j logger.
    // private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "soulmage";

    public SoulMage() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        //Register the setup method for configs
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SERVER_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);

        //Register the setup method for modloading
        Registration.init();
        modEventBus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(ClientSetup::init));


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


}
