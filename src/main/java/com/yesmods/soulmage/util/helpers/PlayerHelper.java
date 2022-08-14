package com.yesmods.soulmage.util.helpers;

import com.google.common.collect.Lists;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.UsernameCache;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerHelper {

    private static final ArrayList<String> knownFakePlayers = Lists.newArrayList();

    public static Player getPlayerFromId(UUID uuid)
    {


        if (ServerLifecycleHooks.getCurrentServer() == null)
        {
            return null;
        }

        return ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayer(uuid);

    }

    public static Player getPlayerFromUUID(UUID uuid)
    {
        return getPlayerFromId(uuid);
    }

    public static UUID getUUIDFromPlayer(Player player)
    {
        return player.getGameProfile().getId();
    }

    public static String getUsernameFromUUID(UUID uuid)
    {
        return UsernameCache.getLastKnownUsername(uuid);
    }

    public static boolean isFakePlayer(Player player)
    {
        return player instanceof FakePlayer || (player != null && knownFakePlayers.contains(player.getClass().getCanonicalName()));
    }

}
