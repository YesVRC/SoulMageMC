package com.yesmods.soulmage.core.capabilities;

import net.minecraft.nbt.CompoundTag;

public class PlayerSoulPower {

    private int soulPower;
    private int soulTier;
    private final int MIN_POWER = 0;
    private final int MAX_BASE_POWER = 100;

    private int regenCooldown;

    public int getSoulPower(){
        return soulPower;
    }

    public int getSoulTier(){
        return soulTier;
    }

    public int getMAXSoul(){
        return MAX_BASE_POWER * soulTier;
    }

    public void addTier(int add){
        this.soulTier += add;
    }

    public void subTier(int sub){
        this.soulTier = Math.max(soulPower - sub, 0);
    }

    public void addPower(int add){
        this.soulPower = Math.min(soulPower + add, MAX_BASE_POWER * soulTier);
    }

    public void subPower(int sub){
        this.soulPower = Math.max(soulPower - sub, MIN_POWER);
    }

    public void handleRegen(){
        if(regenCooldown > 0){
            regenCooldown--;
        }
        else{
            addPower(5);
        }
    }

    public void onDamage(){
        regenCooldown = 300;
    }

    public void copyFrom(PlayerSoulPower power){
        this.soulPower = power.soulPower;
        this.soulTier = power.soulTier;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("soulPower", soulPower);
        nbt.putInt("soulTier", soulTier);
    }

    public void loadNBTData(CompoundTag nbt){
        soulPower = nbt.getInt("soulPower");
        soulTier = nbt.getInt("soulTier");
    }

}
