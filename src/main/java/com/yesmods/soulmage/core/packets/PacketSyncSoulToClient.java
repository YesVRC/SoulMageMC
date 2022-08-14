package com.yesmods.soulmage.core.packets;

import com.yesmods.soulmage.client.PlayerSoulClientData;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketSyncSoulToClient {

    private final int playerSoul;
    private final int playerSoulTier;

    public PacketSyncSoulToClient(int playerSoul, int playerSoulTier){
        this.playerSoul = playerSoul;
        this.playerSoulTier = playerSoulTier;
    }

    public PacketSyncSoulToClient(FriendlyByteBuf buf){
        playerSoul = buf.readInt();
        playerSoulTier = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(playerSoul);
        buf.writeInt(playerSoulTier);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {

            PlayerSoulClientData.set(playerSoul, playerSoulTier);
        });
        return true;
    }
}
