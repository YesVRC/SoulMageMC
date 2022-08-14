package com.yesmods.soulmage.core.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerSoulProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerSoulPower> PLAYER_SOUL = CapabilityManager.get(new CapabilityToken<PlayerSoulPower>() {});

    private PlayerSoulPower soul = null;
    private final LazyOptional<PlayerSoulPower> optional = LazyOptional.of(this::createPlayerSoul);

    private PlayerSoulPower createPlayerSoul() {
        if(this.soul == null){
            this.soul = new PlayerSoulPower();
        }

        return this.soul;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_SOUL){
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerSoul().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerSoul().loadNBTData(nbt);


    }
}
