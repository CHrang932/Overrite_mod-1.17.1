package com.ChakT.OverrackMod.Blocks;

import com.ChakT.OverrackMod.Overrack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block ,new Item.Properties().tab(Overrack.TAB).fireResistant());
    }
}
