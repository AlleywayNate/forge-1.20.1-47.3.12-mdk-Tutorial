/*     */ package net.nastynate.sandworm_mod.event;
/*     */ 
/*     */

import net.jelly.sandworm_mod.capabilities.wormsign.WormSign;
import net.jelly.sandworm_mod.capabilities.wormsign.WormSignProvider;
import net.jelly.sandworm_mod.config.CommonConfigs;
import net.jelly.sandworm_mod.entity.IK.worm.WormChainEntity;
import net.jelly.sandworm_mod.helper.BiomeHelper;
import net.jelly.sandworm_mod.helper.WarningSpawnHelper;
import net.jelly.sandworm_mod.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber(modid = "sandworm_mod", bus = EventBusSubscriber.Bus.FORGE)
/*     */ public class WormSignHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void tickWS(TickEvent.PlayerTickEvent event) {
/*  34 */     int spawnWorm = ((Integer)CommonConfigs.SPAWNWORM_WORMSIGN.get()).intValue();
/*  35 */     if (event.side == LogicalSide.CLIENT)
/*  36 */       return;  Player player = event.player;
/*     */ 
/*     */     
/*  39 */     if (!BiomeHelper.isDesertBiome(player.m_20194_().m_129880_(player.m_9236_().m_46472_()), player.m_20183_()) || player
/*  40 */       .m_9236_().m_45517_(LightLayer.SKY, player.m_20183_()) <= 0) {
/*  41 */       player.getCapability(WormSignProvider.WS).ifPresent(ws -> decrementWormSign(1, ws));
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/*  49 */     if (!player.m_9236_().m_45976_(WormChainEntity.class, new AABB(player.m_20182_().m_82520_(600.0D, 200.0D, 600.0D), player.m_20182_().m_82492_(600.0D, 200.0D, 600.0D))).isEmpty()) {
/*  50 */       player.getCapability(WormSignProvider.WS).ifPresent(ws -> {
/*     */             ws.setStage(0);
/*     */             
/*     */             ws.setStageTimer(0);
/*     */             
/*     */             ws.subWS(2 * spawnWorm);
/*     */             ws.setMultiplier(0.0D);
/*     */             ws.setRespawnTimer(((Integer)CommonConfigs.RESPAWN_DURATION.get()).intValue() * 40);
/*     */           });
/*     */       return;
/*     */     } 
/*  61 */     int softBoots = player.m_6844_(EquipmentSlot.FEET).getEnchantmentLevel(Enchantments.f_44967_);
/*  62 */     player.getCapability(WormSignProvider.WS).ifPresent(ws -> {
/*     */           System.out.println(ws.getWS());
/*     */           if (!ws.canRespawn()) {
/*     */             ws.decrementRespawnTimer();
/*     */             return;
/*     */           } 
/*     */           if (ws.getSignTimer() < 200) {
/*     */             if (player.m_20142_()) {
/*     */               incrementWormSign(4 - softBoots, player, ws);
/*     */             }
/*     */             ws.addThisJumpTime(1);
/*     */             ws.addMultiplier(-0.01D);
/*     */             if (ws.getSignTimer() == 0) {
/*     */               decrementWormSign(1, ws);
/*     */             }
/*     */             if (ws.getWS() >= spawnWorm) {
/*     */               ws.setWS(0);
/*     */               WarningSpawnHelper.spawnWorm(player);
/*     */             } 
/*     */           } 
/*     */           ws.decrementSignTimer();
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
/*  89 */     if (event.getEntity().m_9236_().m_5776_())
/*  90 */       return;  if (!(event.getEntity() instanceof Player))
/*  91 */       return;  Player player = (Player)event.getEntity();
/*  92 */     int softBoots = player.m_6844_(EquipmentSlot.FEET).getEnchantmentLevel(Enchantments.f_44967_);
/*  93 */     if (!BiomeHelper.isDesertBiome(player.m_20194_().m_129880_(player.m_9236_().m_46472_()), player.m_20183_()) || player
/*  94 */       .m_9236_().m_45517_(LightLayer.SKY, player.m_20183_()) <= 0)
/*     */       return; 
/*  96 */     player.getCapability(WormSignProvider.WS).ifPresent(ws -> {
/*     */           if (ws.getSignTimer() < 200) {
/*     */             float lastJump = ws.getLastJumpTime();
/*     */             float thisJump = ws.getThisJumpTime();
/*     */             float percentDiff = Math.abs(lastJump - thisJump) / (lastJump + thisJump) / 2.0F;
/*     */             float similarity = 1.0F - percentDiff;
/*     */             ws.addMultiplier(similarity * 0.7D);
/*     */             incrementWormSign((int)(80.0D * ws.getMultiplier() * (1.0D - softBoots / 16.0D)), player, ws);
/*     */             ws.setLastJumpTime(ws.getThisJumpTime());
/*     */             ws.setThisJumpTime(0);
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void incrementWormSign(int add, Player player, WormSign ws) {
/* 114 */     int spawnWorm = ((Integer)CommonConfigs.SPAWNWORM_WORMSIGN.get()).intValue();
/* 115 */     if (ws.getWS() < spawnWorm / 2 && ws.getWS() + add >= spawnWorm / 2) {
/* 116 */       WarningSpawnHelper.warningScreenshake(player, 0.5D, (SoundEvent)ModSounds.WORM_WARNING_1.get(), ws.getStage(), ws.getWS());
/* 117 */       ws.setStage(1);
/* 118 */       ws.setStageTimer(600);
/* 119 */       ws.setSignTimer();
/* 120 */     } else if (ws.getWS() < spawnWorm * 0.8D && (ws.getWS() + add) >= spawnWorm * 0.8D) {
/* 121 */       WarningSpawnHelper.warningScreenshake(player, 0.6D, (SoundEvent)ModSounds.WORM_WARNING_2.get(), ws.getStage(), ws.getWS());
/* 122 */       ws.setStage(2);
/* 123 */       ws.setStageTimer(600);
/* 124 */       ws.setSignTimer();
/*     */     } 
/* 126 */     ws.addWS(add);
/*     */   }
/*     */   
/*     */   private static void decrementWormSign(int decrement, WormSign ws) {
/* 130 */     int spawnWorm = ((Integer)CommonConfigs.SPAWNWORM_WORMSIGN.get()).intValue();
/* 131 */     if (ws.getStage() == 0) {
/* 132 */       ws.subWS(decrement);
/* 133 */       ws.setStageTimer(0);
/*     */     }
/* 135 */     else if (ws.getStage() == 1) {
/* 136 */       if (ws.getWS() - decrement >= spawnWorm / 2) { ws.subWS(decrement); }
/* 137 */       else { ws.setWS(spawnWorm / 2); }
/* 138 */        ws.decrementStageTimer();
/* 139 */       if (ws.dropStage()) ws.setStage(0);
/*     */     
/* 141 */     } else if (ws.getStage() == 2) {
/* 142 */       if ((ws.getWS() - decrement) >= spawnWorm * 0.8D) { ws.subWS(decrement); }
/* 143 */       else { ws.setWS((int)(spawnWorm * 0.8D)); }
/* 144 */        ws.decrementStageTimer();
/* 145 */       if (ws.dropStage()) ws.setStage(1); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\event\WormSignHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */