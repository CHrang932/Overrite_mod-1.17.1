package com.ChakT.OverrackMod.Items;

import com.ChakT.OverrackMod.Overrack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class PoisonApple extends Item {
    public PoisonApple() {
        super(new Properties()
            .tab(Overrack.TAB)
                .fireResistant()
            .food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(2.0f)
                    .effect(new MobEffectInstance(MobEffects.HEAL,1200,2),1.0f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST , 1200,2),1.0f)
                    .effect(new MobEffectInstance(MobEffects.ABSORPTION , 1200,4),1.0f)
                    .effect(new MobEffectInstance(MobEffects.NIGHT_VISION , 1200,2),1.0f)
                    .alwaysEat()
                    .build()

            )

        );
    }
}
