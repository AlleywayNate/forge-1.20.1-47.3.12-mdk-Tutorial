/*    */ package net.nastynate.sandworm_mod.event;
/*    */ 
/*    */

import dev.architectury.registry.ReloadListenerRegistry;
import mod.chloeprime.aaaparticles.client.loader.EffekAssetLoader;
import net.jelly.sandworm_mod.registry.client.ParticleRegistry;
import net.jelly.sandworm_mod.registry.common.WorldEventRegistry;
import net.jelly.sandworm_mod.vfx.SonicBoomPostProcessor;
import net.jelly.sandworm_mod.worldevents.WormBreachRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import team.lodestar.lodestone.registry.client.LodestoneWorldEventRendererRegistry;
import team.lodestar.lodestone.systems.postprocess.PostProcessHandler;
import team.lodestar.lodestone.systems.postprocess.PostProcessor;
import team.lodestar.lodestone.systems.worldevent.WorldEventRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "sandworm_mod", bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*    */ public class ModClientEvents
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onClientSetup(FMLClientSetupEvent event) {
/* 41 */     PostProcessHandler.addInstance((PostProcessor)SonicBoomPostProcessor.INSTANCE);
/* 42 */     ReloadListenerRegistry.register(PackType.CLIENT_RESOURCES, (PreparableReloadListener)new EffekAssetLoader(), new ResourceLocation("sandworm_mod", "effeks"));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerParticleFactory(RegisterParticleProvidersEvent event) {
/* 47 */     ParticleRegistry.registerParticleFactory(event);
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerRenderers(FMLClientSetupEvent event) {
/* 52 */     LodestoneWorldEventRendererRegistry.registerRenderer(WorldEventRegistry.WORM_BREACH, (WorldEventRenderer)new WormBreachRenderer());
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\event\ClientEvents$ModClientEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */