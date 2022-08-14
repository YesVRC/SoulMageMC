package com.yesmods.soulmage.setup;

import com.yesmods.soulmage.SoulMage;
import com.yesmods.soulmage.core.packets.PacketSyncSoulToClient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class Messages {

    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id(){
        return packetId++;
    }

    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(SoulMage.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(PacketSyncSoulToClient.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PacketSyncSoulToClient::new)
                .encoder(PacketSyncSoulToClient::toBytes)
                .consumer(PacketSyncSoulToClient::handle)
                .add();


    }

    public static <MSG> void sendToPlayer(ServerPlayer player, MSG message){
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

}
