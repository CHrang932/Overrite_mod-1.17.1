package com.ChakT.OverrackMod.util;

import com.ChakT.OverrackMod.Blocks.BlockItemBase;
import com.ChakT.OverrackMod.Blocks.EndStoneOre;
import com.ChakT.OverrackMod.Blocks.OveriteBlock;
import com.ChakT.OverrackMod.Items.ItemBase;
import com.ChakT.OverrackMod.Items.OveritBowItem;
import com.ChakT.OverrackMod.Items.OveriteElytraItem;
import com.ChakT.OverrackMod.Items.PoisonApple;
import com.ChakT.OverrackMod.Overrack;
import com.ChakT.OverrackMod.armor.ModArmorMaterial;
import com.ChakT.OverrackMod.armor.ArmorEffects;
import com.ChakT.OverrackMod.tools.ModItemTier;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static  final DeferredRegister<Item> ITEMS =DeferredRegister.create(ForgeRegistries.ITEMS, Overrack.Mod_Id);
    public static final DeferredRegister<Block> BLOCKS =DeferredRegister.create(ForgeRegistries.BLOCKS, Overrack.Mod_Id);


    public static  void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }



    // Items
    public static final RegistryObject<Item> OVERRITE = ITEMS.register("overrite",ItemBase::new);
    public static final RegistryObject<PoisonApple> POISON_APPLE = ITEMS.register("overrite_apple",
            PoisonApple::new);
    public static final RegistryObject<Item> OVERRITE_DIAMOND = ITEMS.register("overrite_diamond", ItemBase::new);




    // Blocks
    public static final RegistryObject<Block> OVERRITEORE = BLOCKS.register("overrite_ore", EndStoneOre::new);
    public static final RegistryObject<Block> OVERRITEBLOCK = BLOCKS.register("overrite_block", OveriteBlock::new);



    // Block Items
    public static final RegistryObject<Item> OVERRITE_ORE_ITEM =ITEMS.register("overrite_ore",() ->
            new BlockItemBase(OVERRITEORE.get()));
    public static final RegistryObject<Item> OVERRITEBLOCK_ITEM = ITEMS.register("overrite_block", ()->
            new BlockItemBase(OVERRITEBLOCK.get()));





    // Gliron Tools
    public static final RegistryObject<SwordItem> GLIRON_SWORD = ITEMS.register("gliron_sword",()->
            new SwordItem(ModItemTier.GLIRON,6,-2.3F,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<PickaxeItem> GLIRON_PICKAXE = ITEMS.register("gliron_pickaxe",()->
            new PickaxeItem(ModItemTier.GLIRON,4,-2.8F,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<AxeItem> GLIRON_AXE = ITEMS.register("gliron_axe",()->
            new AxeItem(ModItemTier.GLIRON,8,-3F,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<ShovelItem> GLIRON_SHOVEL = ITEMS.register("gliron_shovel",()->
            new ShovelItem(ModItemTier.GLIRON,4,-3F,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<HoeItem> GLIRON_HOE = ITEMS.register("gliron_hoe",()->
            new HoeItem(ModItemTier.GLIRON,0,-0f,new Item.Properties().fireResistant().tab(Overrack.TAB)));






    // Gliron Armor
    public static final RegistryObject<ArmorItem> GLIRON_HELMET= ITEMS.register("gliron_helmet",()->
            new ArmorEffects(ModArmorMaterial.GLIRON, EquipmentSlot.HEAD,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<ArmorItem> GLIRON_CHESTPLATE= ITEMS.register("gliron_chestplate",()->
            new ArmorEffects(ModArmorMaterial.GLIRON, EquipmentSlot.CHEST,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<ArmorItem> GLIRON_LEGGINGS= ITEMS.register("gliron_leggings",()->
            new ArmorEffects(ModArmorMaterial.GLIRON, EquipmentSlot.LEGS,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<ArmorItem> GLIRON_BOOTS= ITEMS.register("gliron_boots",()->
            new ArmorEffects(ModArmorMaterial.GLIRON, EquipmentSlot.FEET,new Item.Properties().fireResistant().tab(Overrack.TAB)));


    // Overrite Armor
    public static final RegistryObject<ArmorItem> OVERRITE_HELMET= ITEMS.register("overrite_helmet",()->
            new ArmorEffects(ModArmorMaterial.OVERRITE, EquipmentSlot.HEAD,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<ArmorItem> OVERRITE_CHESTPLATE= ITEMS.register("overrite_chestplate",()->
            new ArmorEffects(ModArmorMaterial.OVERRITE, EquipmentSlot.CHEST,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<ArmorItem> OVERRITE_LEGGINGS= ITEMS.register("overrite_leggings",()->
            new ArmorEffects(ModArmorMaterial.OVERRITE, EquipmentSlot.LEGS,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<ArmorItem> OVERRITE_BOOTS= ITEMS.register("overrite_boots",()->
            new ArmorEffects(ModArmorMaterial.OVERRITE, EquipmentSlot.FEET,new Item.Properties().fireResistant().tab(Overrack.TAB)));


    // Overrite Tools
    public static final RegistryObject<SwordItem> OVERRITE_SWORD = ITEMS.register("overrite_sword",()->
            new SwordItem(ModItemTier.OVERRITE,9,-2.2F,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<PickaxeItem> OVERRITE_PICKAXE = ITEMS.register("overrite_pickaxe",()->
            new PickaxeItem(ModItemTier.OVERRITE,5,-2.8F,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<AxeItem> OVERRITE_AXE = ITEMS.register("overrite_axe",()->
            new AxeItem(ModItemTier.OVERRITE,11,-3F,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<ShovelItem> OVERRITE_SHOVEL = ITEMS.register("overrite_shovel",()->
            new ShovelItem(ModItemTier.OVERRITE,6,-3F,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<HoeItem> OVERRITE_HOE = ITEMS.register("overrite_hoe",()->
            new HoeItem(ModItemTier.OVERRITE,0,-0f,new Item.Properties().fireResistant().tab(Overrack.TAB)));

    public static final RegistryObject<Item> OVERITE_BOW = ITEMS.register("ov_bow",
            () -> new OveritBowItem(new Item.Properties().fireResistant().tab(Overrack.TAB).durability(1500)));

    public static final RegistryObject<ArmorItem> OVERRITE_ELYTRA = ITEMS.register("overrite_elytra",()->
            new OveriteElytraItem(ModArmorMaterial.OVERRITE_ELYTRA, EquipmentSlot.CHEST,new Item.Properties().fireResistant().tab(Overrack.TAB).durability(1000)));

}
