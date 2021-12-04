package com.ChakT.OverrackMod.Items;

import com.ChakT.OverrackMod.Overrack;
import net.minecraft.world.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().tab(Overrack.TAB).fireResistant());
    }
}
