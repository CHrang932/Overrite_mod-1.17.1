package com.ChakT.OverrackMod.armor;

import com.ChakT.OverrackMod.Overrack;
import com.ChakT.OverrackMod.util.RegistryHandler;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {

    GLIRON(Overrack.Mod_Id + ":gliron",26,new int[]{3,6,8,3},
            25, SoundEvents.ARMOR_EQUIP_NETHERITE,2f,0f,
            ()-> {return Ingredient.of(Items.GOLD_BLOCK);} ),

    OVERRITE(Overrack.Mod_Id + ":overrite",35,new int[]{3,6,8,3},
            20, SoundEvents.ARMOR_EQUIP_NETHERITE,4f,0.1f,
            ()-> {return Ingredient.of(RegistryHandler.OVERRITE_DIAMOND.get());} ),

    OVERRITE_ELYTRA(Overrack.Mod_Id + ":overrite_elytra",30,new int[]{0,0,5,0},
            20, SoundEvents.ARMOR_EQUIP_GOLD,0f,0f,
            ()-> {return Ingredient.of(RegistryHandler.OVERRITE_DIAMOND.get());});


    private static final int[] MAX_DAMAGE_ARRAY= new int[]{15,20,22,14};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float taughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorMaterial(String name,int maxDamageFactor,int[]damageReductionAmountArray,int enchantability,
                     SoundEvent soundEvent,float taughness,float KnockbackResistance  ,Supplier<Ingredient> repairMaterial){
        this.name =name;
        this.maxDamageFactor=maxDamageFactor;
        this.damageReductionAmountArray=damageReductionAmountArray;
        this.enchantability=enchantability;
        this.soundEvent = soundEvent;
        this.taughness=taughness;
        this.knockbackResistance=KnockbackResistance;
        this.repairMaterial=repairMaterial;


    }


    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() { return this.name; }

    @Override
    public float getToughness() {
        return this.taughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }


}
