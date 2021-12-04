package com.ChakT.OverrackMod;


import com.ChakT.OverrackMod.Elytra.OveriteElytraArmorStandLayer;
import com.ChakT.OverrackMod.Elytra.OveriteElytraLayer;
import com.ChakT.OverrackMod.util.RegistryHandler;
import com.ChakT.OverrackMod.world.gen.ModOreGen;
import net.java.games.input.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ArmorStandArmorModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.tags.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeRegistryTagsProvider;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Reference;

import static com.ChakT.OverrackMod.util.RegistryHandler.OVERITE_BOW;


@Mod("or")
public class Overrack
{

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String Mod_Id = "or";
    public static final ResourceLocation itemTag = new ResourceLocation(Mod_Id,"or");



    public Overrack()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModOreGen::generationOres);
        MinecraftForge.EVENT_BUS.addListener(this::onEntitySpawn);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        ItemProperties.register(OVERITE_BOW.get(), new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(OVERITE_BOW.get(), new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
        });
        //registerElytraLayer();
    }


    public static final CreativeModeTab TAB = new CreativeModeTab("overrite_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegistryHandler.OVERRITE_DIAMOND.get());
        }
    };

    @SubscribeEvent
    public void onEntitySpawn(EntityJoinWorldEvent event){
        if  (event.getEntity() instanceof ItemEntity){
            if (ItemTags.getAllTags().getTagOrEmpty(itemTag).contains(((ItemEntity) event.getEntity()).getItem().getItem())){
                event.getEntity().setInvulnerable(true);
            }
        }
    }
   /*  @OnlyIn(Dist.CLIENT)
    private void registerElytraLayer() {
        Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().values()
                .forEach(entityRenderer -> entityRenderer.addLayer(new OveriteElytraLayer(entityRenderer)));
        ArmorStand armorStandEntity = new ArmorStand(EntityType.ARMOR_STAND, Minecraft.getInstance().level);
        LivingEntityRenderer<ArmorStand, ArmorStandArmorModel> armorStandRenderer =
                (LivingEntityRenderer<ArmorStand, ArmorStandArmorModel>)
                        Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(armorStandEntity);
        armorStandRenderer.addLayer(new OveriteElytraArmorStandLayer(armorStandRenderer));
    }*/
    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers e) {
        e.getSkin("default").addLayer(new OveriteElytraLayer(e.getSkin("default")));
    }
    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers k) {
        k.getSkin("slim").addLayer(new OveriteElytraLayer(k.getSkin("slim")));
    }

}
