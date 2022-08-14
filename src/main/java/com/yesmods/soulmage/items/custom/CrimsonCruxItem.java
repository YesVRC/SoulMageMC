package com.yesmods.soulmage.items.custom;

import com.yesmods.soulmage.items.ModTiers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.*;

public class CrimsonCruxItem extends SwordItem {

    public static CrimsonCruxItem INSTANCE = new CrimsonCruxItem(ModTiers.CRUX, 2, 2f, new Item.Properties().tab(CreativeModeTab.TAB_MISC));

    public CrimsonCruxItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }


    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {

        return super.onEntitySwing(stack, entity);
    }
}
