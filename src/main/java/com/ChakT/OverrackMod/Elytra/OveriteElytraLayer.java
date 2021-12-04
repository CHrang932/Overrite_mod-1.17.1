package com.ChakT.OverrackMod.Elytra;

import com.ChakT.OverrackMod.Overrack;
import com.ChakT.OverrackMod.util.RegistryHandler;

import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OveriteElytraLayer extends ElytraLayer<AbstractClientPlayer,
        PlayerModel<AbstractClientPlayer>> {

    private static final ResourceLocation TEXTURE_ELYTRA = new ResourceLocation(Overrack.Mod_Id,
            "textures/entity/overrite_elytra.png");
    private final ElytraModel<AbstractClientPlayer> elytraModel;

    public OveriteElytraLayer(
            RenderLayerParent<AbstractClientPlayer,
                    PlayerModel<AbstractClientPlayer>> rendererIn, EntityModelSet entityModelSet) {
        super(rendererIn,entityModelSet);
        this.elytraModel = new ElytraModel<>(entityModelSet.bakeLayer(ModelLayers.ELYTRA));
    }



    @Override
    public boolean shouldRender(ItemStack stack, AbstractClientPlayer entity) {
        return stack.getItem() == RegistryHandler.OVERRITE_ELYTRA.get();
    }

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, AbstractClientPlayer entity) {
        return TEXTURE_ELYTRA;
    }
}
