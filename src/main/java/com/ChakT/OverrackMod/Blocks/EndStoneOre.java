package com.ChakT.OverrackMod.Blocks;


import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;


public class EndStoneOre extends OreBlock {

    public EndStoneOre() {
        super(BlockBehaviour.Properties.of(Material.STONE)
                .strength(30.0f,1200f)
                .sound(SoundType.ANCIENT_DEBRIS)
                .requiresCorrectToolForDrops()
                .explosionResistance(50)


        );
    }
}
