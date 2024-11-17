/*     */ package net.nastynate.sandworm_mod.helper;
/*     */ 
/*     */

import net.jelly.sandworm_mod.advancements.AdvancementTriggerRegistry;
import net.jelly.sandworm_mod.capabilities.wormsign.WormSignProvider;
import net.jelly.sandworm_mod.entity.IK.worm.WormChainEntity;
import net.jelly.sandworm_mod.entity.ModEntities;
import net.jelly.sandworm_mod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PacketDistributor;
import team.lodestar.lodestone.network.screenshake.ScreenshakePacket;
import team.lodestar.lodestone.registry.common.LodestonePacketRegistry;
import team.lodestar.lodestone.systems.easing.Easing;

import java.util.List;
import java.util.Random;
/*     */ 
/*     */ public class WarningSpawnHelper {
/*     */   public static void warningScreenshake(Player player, double strength, SoundEvent sound, int stage, int wormsign) {
/*  30 */     player.m_9236_().m_214150_(null, player.m_20185_(), player.m_20186_(), player.m_20189_(), sound, SoundSource.MASTER, 12.5F, 1.0F, 0L);
/*     */ 
/*     */     
/*  33 */     List<Player> nearbyPlayers = player.m_9236_().m_45955_(TargetingConditions.m_148353_(), null, new AABB(player
/*  34 */           .m_20182_().m_82520_(200.0D, 500.0D, 200.0D), player.m_20182_().m_82492_(200.0D, 500.0D, 200.0D)));
/*  35 */     nearbyPlayers.forEach(p -> {
/*     */           LodestonePacketRegistry.LODESTONE_CHANNEL.send(PacketDistributor.PLAYER.with(()), (new ScreenshakePacket(410)).setEasing(Easing.SINE_IN_OUT).setIntensity((float)strength));
/*     */           player.getCapability(WormSignProvider.WS).ifPresent(());
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void thumperWarning(Level level, Vec3 pos) {
/*  47 */     double strength = 0.6D;
/*  48 */     level.m_214150_(null, pos.f_82479_, pos.f_82480_, pos.f_82481_, (SoundEvent)ModSounds.WORM_WARNING_2.get(), SoundSource.MASTER, 12.5F, 1.0F, 0L);
/*     */     
/*  50 */     List<Player> nearbyPlayers = level.m_45955_(TargetingConditions.m_148353_(), null, new AABB(pos
/*  51 */           .m_82520_(200.0D, 500.0D, 200.0D), pos.m_82492_(200.0D, 500.0D, 200.0D)));
/*  52 */     nearbyPlayers.forEach(p -> LodestonePacketRegistry.LODESTONE_CHANNEL.send(PacketDistributor.PLAYER.with(()), (new ScreenshakePacket(410)).setEasing(Easing.SINE_IN_OUT).setIntensity((float)strength)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Vec3 spawnPosOffset() {
/*  61 */     Random random = new Random();
/*  62 */     float xOffset = (random.nextInt(100) + 100);
/*  63 */     if (random.nextBoolean()) xOffset *= -1.0F; 
/*  64 */     float zOffset = (random.nextInt(100) + 100);
/*  65 */     if (random.nextBoolean()) zOffset *= -1.0F; 
/*  66 */     float yOffset = -5.0F;
/*  67 */     return new Vec3(xOffset, yOffset, zOffset);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void spawnWorm(Player player) {
/*  73 */     if (player.m_9236_().m_5776_())
/*  74 */       return;  WormChainEntity sandWorm = new WormChainEntity((EntityType)ModEntities.WORM_CHAIN.get(), player.m_9236_());
/*  75 */     Vec3 sandWormSpawnPos = player.m_20182_().m_82549_(spawnPosOffset());
/*  76 */     int spawnChecks = 0;
/*  77 */     while (!BiomeHelper.isDesertBiome(player.m_20194_().m_129880_(player.m_9236_().m_46472_()).m_6018_(), new BlockPos((int)sandWormSpawnPos.f_82479_, (int)sandWormSpawnPos.f_82480_, (int)sandWormSpawnPos.f_82481_))) {
/*  78 */       sandWormSpawnPos = player.m_20182_().m_82549_(spawnPosOffset());
/*  79 */       spawnChecks++;
/*  80 */       if (spawnChecks > 100)
/*     */         break; 
/*  82 */     }  sandWorm.m_20219_(sandWormSpawnPos);
/*  83 */     sandWorm.setAggroTargetEntity((LivingEntity)player);
/*  84 */     player.m_9236_().m_7967_((Entity)sandWorm);
/*  85 */     sandWorm.m_5496_((SoundEvent)ModSounds.WORM_SPAWN.get(), 100.0F, 1.0F);
/*  86 */     AdvancementTriggerRegistry.SHAI_HULUD.trigger((ServerPlayer)player);
/*     */   }
/*     */   
/*     */   public static WormChainEntity spawnWormThumper(Level level, BlockPos bPos) {
/*  90 */     if (level.m_5776_()) return null; 
/*  91 */     Vec3 pos = bPos.m_252807_();
/*  92 */     WormChainEntity sandWorm = new WormChainEntity((EntityType)ModEntities.WORM_CHAIN.get(), level);
/*  93 */     Vec3 sandWormSpawnPos = pos.m_82549_(spawnPosOffset());
/*  94 */     int spawnChecks = 0;
/*  95 */     while (!BiomeHelper.isDesertBiome(level.m_7654_().m_129880_(level.m_46472_()), new BlockPos((int)sandWormSpawnPos.f_82479_, (int)sandWormSpawnPos.f_82480_, (int)sandWormSpawnPos.f_82481_))) {
/*  96 */       sandWormSpawnPos = pos.m_82549_(spawnPosOffset());
/*  97 */       spawnChecks++;
/*  98 */       if (spawnChecks > 100)
/*     */         break; 
/* 100 */     }  sandWorm.m_20219_(sandWormSpawnPos);
/* 101 */     sandWorm.thumperTarget = pos;
/* 102 */     level.m_7967_((Entity)sandWorm);
/* 103 */     sandWorm.m_5496_((SoundEvent)ModSounds.WORM_SPAWN.get(), 100.0F, 1.0F);
/* 104 */     return sandWorm;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\helper\WarningSpawnHelper.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */