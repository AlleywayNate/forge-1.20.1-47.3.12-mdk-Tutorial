/*     */ package net.nastynate.sandworm_mod.event;
/*     */ 
/*     */

import net.jelly.sandworm_mod.advancements.AdvancementTriggerRegistry;
import net.jelly.sandworm_mod.capabilities.wormsign.WormSignProvider;
import net.jelly.sandworm_mod.config.CommonConfigs;
import net.jelly.sandworm_mod.entity.IK.worm.WormChainEntity;
import net.jelly.sandworm_mod.entity.IK.worm.WormHeadSegment;
import net.jelly.sandworm_mod.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.brewing.PlayerBrewedPotionEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.List;
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
/*     */ @EventBusSubscriber(modid = "sandworm_mod", bus = EventBusSubscriber.Bus.FORGE)
/*     */ public class ForgeEventHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void RegisterModCommands(RegisterCommandsEvent event) {}
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
/*  63 */     if (event.getObject() instanceof Player && 
/*  64 */       !((Entity)event.getObject()).getCapability(WormSignProvider.WS).isPresent()) {
/*  65 */       event.addCapability(new ResourceLocation("sandworm_mod", "properties"), (ICapabilityProvider)new WormSignProvider());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onExplosion(ExplosionEvent.Detonate event) {
/*  73 */     if (event.getLevel().m_5776_())
/*  74 */       return;  Vec3 pos = event.getExplosion().getPosition();
/*  75 */     List<WormHeadSegment> hitHeads = event.getLevel().m_45976_(WormHeadSegment.class, new AABB(pos.f_82479_ + 5.0D, pos.f_82480_ + 5.0D, pos.f_82481_ + 5.0D, pos.f_82479_ - 5.0D, pos.f_82480_ - 5.0D, pos.f_82481_ - 5.0D));
/*  76 */     if (!hitHeads.isEmpty()) hitHeads.forEach(head -> {
/*     */             Player player;
/*     */             head.m_5496_((SoundEvent)ModSounds.WORM_ROAR.get(), 10.0F, 1.0F);
/*     */             WormChainEntity wormChain = head.getOwner();
/*     */             if (wormChain != null) {
/*     */               wormChain.blastHit();
/*     */             }
/*     */             LivingEntity livingEntity = event.getExplosion().m_252906_();
/*     */             if (livingEntity == null) {
/*     */               Vec3 explosionPos = event.getExplosion().getPosition();
/*     */               player = event.getLevel().m_45924_(explosionPos.f_82479_, explosionPos.f_82480_, explosionPos.f_82481_, 100.0D, true);
/*     */             } 
/*     */             if (player instanceof Player) {
/*     */               AdvancementTriggerRegistry.FIRST_BLAST.trigger((ServerPlayer)player);
/*     */               if (wormChain.explodedTimes >= ((Integer)CommonConfigs.HEALTH.get()).intValue()) {
/*     */                 AdvancementTriggerRegistry.SANDWORM_FLEE.trigger((ServerPlayer)player);
/*     */               }
/*     */             } 
/*     */           });
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void brewPotion(PlayerBrewedPotionEvent event) {
/* 102 */     if (event.getEntity().m_9236_().m_5776_())
/* 103 */       return;  if (event.getStack().m_41783_().m_128471_("duneElixir")) AdvancementTriggerRegistry.DUNE_ELIXIR.trigger((ServerPlayer)event.getEntity()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\event\ForgeEventHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */