package com.ChakT.OverrackMod.tools;

import com.ChakT.OverrackMod.util.RegistryHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {

    GLIRON( 4, 1800, 7, 0, 25, ()->{

        return Ingredient.of(Items.GOLD_INGOT);
    }),
    OVERRITE( 4, 2500, 9, 0, 20, ()->{

        return Ingredient.of(RegistryHandler.OVERRITE.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final int efficiency;
    private final int attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel,int maxUses ,int efficiency, int attackDamage , int enchantability , Supplier<Ingredient> repairMaterial)
    {
        this.harvestLevel =harvestLevel;
        this.maxUses = maxUses;
        this.efficiency=efficiency;
        this.attackDamage=attackDamage;
        this.enchantability=enchantability;
        this.repairMaterial=repairMaterial;
    }



    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }



}
