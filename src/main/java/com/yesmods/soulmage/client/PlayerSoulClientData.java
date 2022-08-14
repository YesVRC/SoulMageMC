package com.yesmods.soulmage.client;

public class PlayerSoulClientData {

    private static int playerSoul;
    private static int playerSoulTier;

    public static void set(int playerSoul, int playerSoulTier){
        PlayerSoulClientData.playerSoul = playerSoul;
        PlayerSoulClientData.playerSoulTier = playerSoulTier;
    }

    public static int getPlayerSoul(){
        return playerSoul;
    }

    public static int getPlayerSoulTier(){
        return playerSoulTier;
    }
}
