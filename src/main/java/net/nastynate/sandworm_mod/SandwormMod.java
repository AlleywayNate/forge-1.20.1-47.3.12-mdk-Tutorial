/*     */ package net.nastynate.sandworm_mod;
/*     */ 
/*     */

import com.mojang.logging.LogUtils;
import net.nastynate.sandworm_mod.advancements.AdvancementTriggerRegistry;
import net.jelly.sandworm_mod.block.ModBlockEntities;
import net.jelly.sandworm_mod.block.ModBlocks;
import net.jelly.sandworm_mod.brewing.WormToothBrewing;
import net.jelly.sandworm_mod.config.CommonConfigs;
import net.jelly.sandworm_mod.entity.ModEntities;
import net.jelly.sandworm_mod.item.ModItems;
import net.jelly.sandworm_mod.registry.client.ParticleRegistry;
import net.jelly.sandworm_mod.sound.ModSounds;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mod("sandworm_mod")
/*     */ public class SandwormMod
/*     */ {
/*     */   public static final String MODID = "sandworm_mod";
/*  43 */   private static final Logger LOGGER = LogUtils.getLogger();
/*     */ 
/*     */   
/*     */   public SandwormMod() {
/*  47 */     IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
/*     */ 
/*     */     
/*  50 */     ModItems.register(modEventBus);
/*  51 */     ModBlocks.register(modEventBus);
/*  52 */     ModBlockEntities.register(modEventBus);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     ModEntities.register(modEventBus);
/*     */ 
/*     */     
/*  60 */     modEventBus.addListener(this::commonSetup);
/*     */ 
/*     */     
/*  63 */     ModSounds.register(modEventBus);
/*     */ 
/*     */     
/*  66 */     ParticleRegistry.register(modEventBus);
/*     */ 
/*     */     
/*  69 */     ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, (IConfigSpec)CommonConfigs.SPEC, "sandwormmod-common.toml");
/*     */ 
/*     */     
/*  72 */     MinecraftForge.EVENT_BUS.register(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void commonSetup(FMLCommonSetupEvent event) {
/*  78 */     event.enqueueWork(() -> {
/*     */           BrewingRecipeRegistry.addRecipe((IBrewingRecipe)new WormToothBrewing());
/*     */           AdvancementTriggerRegistry.init();
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onServerStarting(ServerStartingEvent event) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventBusSubscriber(modid = "sandworm_mod", bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*     */   public static class ClientModEvents
/*     */   {
/*     */     @SubscribeEvent
/*     */     public static void onClientSetup(FMLClientSetupEvent event) {
/* 101 */       EntityRenderers.m_174036_((EntityType)ModEntities.WORM_SEGMENT.get(), net.jelly.sandworm_mod.entity.IK.worm.WormSegmentRenderer::new);
/* 102 */       EntityRenderers.m_174036_((EntityType)ModEntities.WORM_HEAD_SEGMENT.get(), net.jelly.sandworm_mod.entity.IK.worm.WormHeadSegmentRenderer::new);
/* 103 */       EntityRenderers.m_174036_((EntityType)ModEntities.WORM_CHAIN.get(), net.jelly.sandworm_mod.entity.IK.KinematicChainRenderer::new);
/* 104 */       BlockEntityRenderers.m_173590_((BlockEntityType)ModBlockEntities.THUMPER_ENTITY.get(), net.jelly.sandworm_mod.block.thumper.ThumperRenderer::new);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\SandwormMod.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */