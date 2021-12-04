package com.ChakT.OverrackMod.armor;

import com.ChakT.OverrackMod.util.RegistryHandler;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class ArmorEffects extends ArmorItem {

    public ArmorEffects(ArmorMaterial materialIn, EquipmentSlot slot, Properties properties) {
        super(materialIn, slot, properties);
    }


    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }


    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity)
    {
        if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() == RegistryHandler.OVERRITE_HELMET.get())
            return true;
        else if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == RegistryHandler.GLIRON_HELMET.get())
            return true;
        return false;
    }

    @Override
    public void onArmorTick(ItemStack itemstack, Level world, Player player) {
        //check armor
        if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() == RegistryHandler.OVERRITE_HELMET.get())
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0));
    }
}
