package com.yesmods.soulmage.events;

import com.yesmods.soulmage.SoulMage;
import com.yesmods.soulmage.core.capabilities.PlayerSoulPower;
import com.yesmods.soulmage.core.capabilities.PlayerSoulProvider;
import com.yesmods.soulmage.core.packets.PacketSyncSoulToClient;
import com.yesmods.soulmage.setup.Messages;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SoulMage.MOD_ID)
public class ModEvents {


    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player){
            if(!event.getObject().getCapability(PlayerSoulProvider.PLAYER_SOUL).isPresent()){
                event.addCapability(new ResourceLocation(SoulMage.MOD_ID, "playersoul"), new PlayerSoulProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        if(event.isWasDeath()){
            event.getOriginal().getCapability(PlayerSoulProvider.PLAYER_SOUL).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerSoulProvider.PLAYER_SOUL).ifPresent(newStore ->{
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PlayerSoulPower.class);
    }


    @SubscribeEvent
    public static void onWorldTick(TickEvent.WorldTickEvent event){
        for (Player player : event.world.players()) {
            if(player instanceof ServerPlayer serverPlayer){
                int playerSoul = serverPlayer.getCapability(PlayerSoulProvider.PLAYER_SOUL)
                        .map(PlayerSoulPower::getSoulPower)
                        .orElse(-1);
                int playerSoulTier = serverPlayer.getCapability(PlayerSoulProvider.PLAYER_SOUL)
                                .map(PlayerSoulPower::getSoulTier)
                                        .orElse(-1);
                Messages.sendToPlayer(serverPlayer, new PacketSyncSoulToClient(playerSoul, playerSoulTier));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event){
        if(event.getEntity() instanceof Player){
            event.getEntity().getCapability(PlayerSoulProvider.PLAYER_SOUL).ifPresent(soulPower -> {
                soulPower.onDamage();
            });
        }
    }

}
