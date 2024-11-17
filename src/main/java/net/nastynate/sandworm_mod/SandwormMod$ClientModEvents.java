/*     */ package net.nastynate.sandworm_mod;
/*     */ 
/*     */

import net.jelly.sandworm_mod.block.ModBlockEntities;
import net.jelly.sandworm_mod.entity.ModEntities;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber(modid = "sandworm_mod", bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*     */ public class ClientModEvents
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onClientSetup(FMLClientSetupEvent event) {
/* 101 */     EntityRenderers.m_174036_((EntityType)ModEntities.WORM_SEGMENT.get(), net.jelly.sandworm_mod.entity.IK.worm.WormSegmentRenderer::new);
/* 102 */     EntityRenderers.m_174036_((EntityType)ModEntities.WORM_HEAD_SEGMENT.get(), net.jelly.sandworm_mod.entity.IK.worm.WormHeadSegmentRenderer::new);
/* 103 */     EntityRenderers.m_174036_((EntityType)ModEntities.WORM_CHAIN.get(), net.jelly.sandworm_mod.entity.IK.KinematicChainRenderer::new);
/* 104 */     BlockEntityRenderers.m_173590_((BlockEntityType)ModBlockEntities.THUMPER_ENTITY.get(), net.jelly.sandworm_mod.block.thumper.ThumperRenderer::new);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\SandwormMod$ClientModEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */