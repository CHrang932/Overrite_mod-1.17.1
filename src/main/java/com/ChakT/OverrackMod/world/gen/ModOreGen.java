package com.ChakT.OverrackMod.world.gen;

import com.ChakT.OverrackMod.Overrack;
import com.ChakT.OverrackMod.util.RegistryHandler;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.ConfiguredDecorator;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.common.Mod;



@Mod.EventBusSubscriber(modid = Overrack.Mod_Id,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {
   public static void generationOres(final BiomeLoadingEvent event){
        if (event.getCategory().equals(Biome.BiomeCategory.OCEAN)){
            genOre(event.getGeneration(),OreConfiguration.Predicates.NATURAL_STONE, RegistryHandler.OVERRITEORE.get().defaultBlockState(),
                    4,2,50,10);

        }else {
                genOre(event.getGeneration(),OreConfiguration.Predicates.NATURAL_STONE, RegistryHandler.OVERRITEORE.get().defaultBlockState(),
                        3,2,50,6);
            }
   }

    private static void genOre(BiomeGenerationSettingsBuilder settings,RuleTest filler,BlockState blockState,int veinSize,
                               int bottomOffset,int TopOffset,int amout){
        settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,Feature.ORE.configured(new OreConfiguration(filler,blockState,veinSize))
                .decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(bottomOffset),VerticalAnchor.belowTop(TopOffset)))).squared().count(amout)));
    }

}
