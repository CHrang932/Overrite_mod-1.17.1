package com.ChakT.OverrackMod.Blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;


public class OveriteBlock extends Block {
    public OveriteBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL)
                .explosionResistance(5)
                .strength(50.0F, 1200.0F)
                .sound(SoundType.NETHERITE_BLOCK)

        );
    }
}
