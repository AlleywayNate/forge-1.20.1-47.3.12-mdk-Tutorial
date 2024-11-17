/*     */ package net.nastynate.sandworm_mod.entity.IK.worm;
/*     */

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.jelly.sandworm_mod.block.ModBlockEntities;
import net.jelly.sandworm_mod.config.CommonConfigs;
import net.jelly.sandworm_mod.entity.IK.ChainSegment;
import net.jelly.sandworm_mod.entity.IK.KinematicChainEntity;
import net.jelly.sandworm_mod.entity.ModEntities;
import net.jelly.sandworm_mod.helper.BiomeHelper;
import net.jelly.sandworm_mod.item.ModItems;
import net.jelly.sandworm_mod.sound.ModSounds;
import net.jelly.sandworm_mod.worldevents.SonicBoomWorldEvent;
import net.jelly.sandworm_mod.worldevents.WormBreachWorldEvent;
import net.jelly.sandworm_mod.worldevents.WormRippleWorldEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PacketDistributor;
import team.lodestar.lodestone.handlers.WorldEventHandler;
import team.lodestar.lodestone.network.screenshake.PositionedScreenshakePacket;
import team.lodestar.lodestone.registry.common.LodestonePacketRegistry;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.worldevent.WorldEventInstance;

import java.util.List;
import java.util.UUID;
/*     */ 
/*     */ public class WormChainEntity extends KinematicChainEntity {
/*  46 */   private static float SPEED_SCALE = 1.3F;
/*     */   private boolean breaching = false;
/*  48 */   private int soundFrequencyCount = 0;
/*  49 */   private static final ParticleEmitterInfo SAND_IMPACT = new ParticleEmitterInfo(new ResourceLocation("sandworm_mod", "sandimpact"));
/*  50 */   private static final ParticleEmitterInfo SLOWER_SAND_IMPACT = new ParticleEmitterInfo(new ResourceLocation("sandworm_mod", "slowersandimpact"));
/*  51 */   private static final ParticleEmitterInfo SAND_SMOKE = new ParticleEmitterInfo(new ResourceLocation("sandworm_mod", "sandsmoke"));
/*     */   public LivingEntity aggroTargetEntity;
/*     */   public boolean removed = false;
/*  54 */   private int discardTimer = 0;
/*  55 */   private int noTargetEscapeTimer = 0;
/*     */   private boolean escaping = false;
/*  57 */   private int noPlayerDiscardTimer = 0;
/*     */   private boolean isChasing = false;
/*  59 */   public int explodedTimes = 0;
/*     */   private WormHeadSegment head;
/*  61 */   public Vec3 thumperTarget = null;
/*  62 */   private int despawnTimer = 0;
/*     */   private int smokeCount;
/*     */   
/*  65 */   public WormChainEntity(EntityType<?> pEntityType, Level pLevel) { super(pEntityType, pLevel);
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
/* 486 */     this.smokeCount = 0; }
/*     */   private void initWorm() { if (this.segmentCount == 0) { int i; for (i = 0; i < 10; ) { addWormSegment(1.75F, new Vec3(1.0D, 0.0D, 0.0D), new Vec3(7.5D * ((i + 2) / 11.0F), 7.5D * ((i + 2) / 11.0F), 5.0D)); i++; }  for (i = 0; i < 80; ) { addWormSegment(1.75F, new Vec3(1.0D, 0.0D, 0.0D), new Vec3(7.5D, 7.5D, 5.0D)); i++; }  addHeadSegment(1.75F, new Vec3(1.0D, 0.0D, 0.0D), new Vec3(7.5D, 7.5D, 5.0D)); if (this.aggroTargetEntity == null && this.thumperTarget == null) retarget(30.0F);  Vec3 targetedObjectPos = getTargetedObjectPos(); if (targetedObjectPos != null) { Vec3 lookAtAggroEntity = targetedObjectPos.m_82546_(m_20182_()).m_82541_(); for (int j = 0; j < this.segmentCount; j++) ((ChainSegment)this.segments.get(j)).setDirectionVector(lookAtAggroEntity);  }  }  }
/*     */   private void loadSavedSegments() { if (this.segmentCount != 0 && this.segments.isEmpty()) { List<ChainSegment> nearbyChainSegs = m_9236_().m_45976_(ChainSegment.class, new AABB(m_20182_().m_82520_(200.0D, 200.0D, 200.0D), m_20182_().m_82520_(-200.0D, -200.0D, -200.0D))); for (int i = 0; i < this.segmentCount; i++) { UUID thisUUID = this.segmentsUUIDs.get(i); this.segments.add(nearbyChainSegs.stream().filter(obj -> obj.m_20149_().equals(thisUUID.toString())).findFirst().orElse(null)); }  }  }
/* 489 */   private int despawnBehavior() { for (int j = 0; j < this.segments.size(); j++) { if (this.segments.get(j) == null) { if (this.discardTimer < 100) { this.discardTimer++; } else { m_146870_(); }  return 1; }  }  this.discardTimer = 0; if (m_9236_().m_45930_((Entity)this, 400.0D) == null) { if (this.noPlayerDiscardTimer < 60) { this.noPlayerDiscardTimer++; } else { m_146870_(); }  return 1; }  this.noPlayerDiscardTimer = 0; return 0; } private void fikBehavior() { if (!this.segments.isEmpty()) { m_146884_(((ChainSegment)this.segments.get(0)).m_20182_()); Vec3 rootToEnd = ((ChainSegment)this.segments.get(this.segmentCount - 1)).m_20182_().m_82546_(((ChainSegment)this.segments.get(0)).m_20182_()).m_82537_(new Vec3(0.0D, 0.0D, 1.0D)); for (int i = 0; i < this.segmentCount; i++) { if (this.segments.get(i) != null) ((ChainSegment)this.segments.get(i)).setUpVector(rootToEnd);  }  }  } private void dolphinBehavior() { Vec3 targetedObjectPos = getTargetedObjectPos(); if (!this.isChasing) { Vec3 towardTarget = targetedObjectPos.m_82546_(this.head.m_20182_()).m_82541_().m_82542_(20.0D, 0.0D, 20.0D); this.goal = this.head.m_20182_().m_82520_(towardTarget.f_82479_, 0.0D, towardTarget.f_82481_); this.goal = new Vec3(this.goal.f_82479_, targetedObjectPos.f_82480_, this.goal.f_82481_); this.isChasing = true; } else if (this.head.m_20182_().m_82546_(this.goal).m_165924_() <= 10.0D) { Vec3 towardTarget = targetedObjectPos.m_82546_(this.head.m_20182_()).m_82541_().m_82542_(20.0D, 0.0D, 20.0D); this.goal = this.head.m_20182_().m_82520_(towardTarget.f_82479_, 0.0D, towardTarget.f_82481_); this.goal = new Vec3(this.goal.f_82479_, targetedObjectPos.f_82480_, this.goal.f_82481_); }  } private void VFXSFXBehavior() { List<Player> players = m_9236_().m_6907_(); if (m_9236_().m_186437_(null, this.head.m_20191_())) { for (int i = 0; i < players.size(); i++) { Player thisPlayer = players.get(i); float dist = thisPlayer.m_20270_((Entity)this.head); if (dist <= 100.0F) { float intensity = (float)Math.pow(1.0D + Math.pow(1.100000023841858D, (dist - 17.5F)), -1.0D) + 0.2F; LodestonePacketRegistry.LODESTONE_CHANNEL.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)thisPlayer), (new PositionedScreenshakePacket(20, this.head.m_20182_(), 200.0F, 100.0F)).setEasing(Easing.CUBIC_OUT).setIntensity(0.65F * intensity, 0.0F)); }  }  Vec3 targetedObjectPos = getTargetedObjectPos(); if (targetedObjectPos != null) { double dist = targetedObjectPos.m_82554_(this.head.m_20182_()); float intensity = (float)Math.pow(1.0D + Math.pow(1.100000023841858D, dist - 17.5D), -1.0D) + 0.2F; if (this.soundFrequencyCount >= 10.0F - intensity * 10.0F) { m_9236_().m_6269_(null, (Entity)this.head, SoundEvents.f_12331_, SoundSource.HOSTILE, 80.0F * intensity, intensity); this.head.m_5496_((SoundEvent)ModSounds.WORM_BURROW.get(), 80.0F * intensity, intensity); this.soundFrequencyCount = 0; } else { this.soundFrequencyCount++; }  }  }  if (!this.breaching && predictBreach(m_9236_(), this.head)) { this.breaching = true; Vec3 particlePos = this.head.m_20182_().m_82549_(this.head.getDirectionVector().m_82490_(8.0D)); AAALevel.addParticle(m_9236_(), true, SLOWER_SAND_IMPACT.clone().scale(1.25F).position(particlePos)); smokeParticles(m_9236_(), particlePos.m_82520_(0.0D, -9.0D, 0.0D)); if (!this.escaping) m_5496_((SoundEvent)ModSounds.WORM_BREACH.get(), 10.0F, 1.0F);  } else if (this.breaching && !predictBreach(m_9236_(), this.head)) { this.breaching = false; Vec3 particlePos = this.head.m_20182_().m_82549_(this.head.getDirectionVector().m_82490_(8.0D)); AAALevel.addParticle(m_9236_(), true, SLOWER_SAND_IMPACT.clone().scale(1.25F).position(particlePos)); smokeParticles(m_9236_(), particlePos.m_82520_(0.0D, -9.0D, 0.0D)); if (!this.escaping) m_5496_((SoundEvent)ModSounds.WORM_LAND.get(), 10.0F, 1.0F);  }  } private void wormAIBehavior() { if (this.thumperTarget == null && (this.aggroTargetEntity == null || this.aggroTargetEntity.m_213877_() || this.aggroTargetEntity.m_21224_() || !BiomeHelper.isDesertBiome((Entity)this.aggroTargetEntity))) { retarget(30.0F); if (this.noTargetEscapeTimer >= 20) this.escaping = true;  } else if (!this.escaping) { Vec3 targetedObjectPos = getTargetedObjectPos(); if (targetedObjectPos == null) { this.target = this.head.m_20182_().m_82549_(this.targetV); return; }  if (this.head.m_20182_().m_82546_(targetedObjectPos).m_165924_() > 50.0D) { dolphinBehavior(); } else { this.isChasing = false; }  if (!this.isChasing) if (this.stage != 0 || targetedObjectPos.m_82554_(this.head.m_20182_()) >= (22.0F * SPEED_SCALE)) { this.goal = targetedObjectPos; } else if (this.goal == null) { this.goal = targetedObjectPos; } else if (this.stage == 0) { sinkHole(m_9236_(), this.goal); }   this.target = this.head.m_20182_().m_82549_(this.targetV); Vec3 moveTowardVec = this.goal.m_82546_(this.head.m_20182_()).m_82541_(); if (this.stage == 0) { applyAcceleration(moveTowardVec.m_82490_(0.1D * SPEED_SCALE)); if (moveTowardVec.m_82526_(this.head.getDirectionVector()) < 0.25D || !m_9236_().m_186437_(null, this.head.m_20191_())) this.stage = 1;  }  if (this.stage == 1) if (!m_9236_().m_186437_(null, this.head.m_20191_())) { if (targetedObjectPos.f_82480_ - (this.head.m_20182_()).f_82480_ > 30.0D) retarget(30.0F);  applyAcceleration(new Vec3(0.0D, -0.0375D, 0.0D)); if (moveTowardVec.f_82480_ < 0.0D) moveTowardVec = new Vec3(moveTowardVec.f_82479_, 0.0D, moveTowardVec.f_82481_);  if (this.goal.f_82480_ - (this.head.m_20182_()).f_82480_ < 20.0D) applyAcceleration(moveTowardVec.m_82490_(0.01D));  } else if (this.head.m_20182_().m_82554_(this.goal) > (4.0F * SPEED_SCALE) && this.goal.f_82480_ - (this.head.m_20182_()).f_82480_ >= (20.0F * SPEED_SCALE)) { this.stage = 0; } else { applyAcceleration(new Vec3(0.0D, -0.02D * SPEED_SCALE, 0.0D)); }   }  if (this.escaping) { applyAcceleration(new Vec3(0.0D, -0.0375D, 0.0D)); this.target = this.head.m_20182_().m_82549_(this.targetV); }  } public void m_8119_() { if (!m_9236_().m_5776_()) { loadSavedSegments(); if (despawnBehavior() == 1) return;  initWorm(); fikBehavior(); if (this.aggroTargetEntity != null) { if (!(this.aggroTargetEntity instanceof Player)) { this.despawnTimer++; } else if (((Player)this.aggroTargetEntity).m_7500_()) { this.despawnTimer++; } else { this.despawnTimer = 0; }  if (this.despawnTimer >= ((Integer)CommonConfigs.DESPAWN_TIMER.get()).intValue() * 20) this.escaping = true;  }  if (!this.segments.isEmpty()) { if (this.head == null && ((ChainSegment)this.segments.get(this.segmentCount - 1)).getClass() == WormHeadSegment.class) this.head = this.segments.get(this.segmentCount - 1);  if (this.thumperTarget != null) { BlockPos thumperBPos = BlockPos.m_274561_(this.thumperTarget.f_82479_, this.thumperTarget.f_82480_, this.thumperTarget.f_82481_); if (this.head.m_20039_(thumperBPos, m_9236_().m_8055_(thumperBPos))) m_9236_().m_46961_(thumperBPos, false);  }  wormAIBehavior(); VFXSFXBehavior(); fabrik(); }  }  } private void smokeParticles(Level level, Vec3 pos) { this.smokeCount++;
/* 490 */     WormBreachWorldEvent breachEvent = (new WormBreachWorldEvent()).setPosition(pos);
/* 491 */     breachEvent.start(level);
/* 492 */     breachEvent.setDirty();
/* 493 */     WorldEventHandler.addWorldEvent(level, (WorldEventInstance)breachEvent); }
/*     */   private void retarget(float yRange) { Player player1; LivingEntity livingEntity1; Player player2; LivingEntity livingEntity2; Vec3 headPos = ((ChainSegment)this.segments.get(this.segmentCount - 1)).m_20182_(); List<LivingEntity> nearbyEntities = m_9236_().m_45976_(LivingEntity.class, new AABB(headPos.f_82479_ + 150.0D, headPos.f_82480_ + 150.0D, headPos.f_82481_ + 150.0D, headPos.f_82479_ - 150.0D, headPos.f_82480_ - 150.0D, headPos.f_82481_ - 150.0D)); List<Player> nearbyPlayers = m_9236_().m_45955_(TargetingConditions.m_148353_(), null, new AABB(headPos.f_82479_ + 150.0D, headPos.f_82480_ + 150.0D, headPos.f_82481_ + 150.0D, headPos.f_82479_ - 150.0D, headPos.f_82480_ - 150.0D, headPos.f_82481_ - 150.0D)); LivingEntity closestEntity = null; double closestDistanceSq = Double.MAX_VALUE; LivingEntity farthestTooCloseEntity = null; double fartestTooCloseDistanceSq = 0.0D; for (Player entity : nearbyPlayers) { if (!BiomeHelper.isDesertBiome((Entity)entity) || m_9236_().m_45517_(LightLayer.SKY, entity.m_20183_()) <= 0 || entity.m_5833_() || entity.m_7500_()) continue;  double deltaX = entity.m_20185_() - headPos.f_82479_; double deltaZ = entity.m_20189_() - headPos.f_82481_; double distanceSq = deltaX * deltaX + deltaZ * deltaZ; double deltaY = entity.m_20186_() - headPos.f_82480_; if (distanceSq >= 400.0D && deltaY <= yRange) { if (distanceSq < closestDistanceSq) { closestDistanceSq = distanceSq; player1 = entity; }  continue; }  if (deltaY <= yRange && distanceSq > fartestTooCloseDistanceSq) { fartestTooCloseDistanceSq = distanceSq; player2 = entity; }  }  if ((((player1 == null) ? 1 : 0) & ((player2 == null) ? 1 : 0)) != 0) { closestDistanceSq = Double.MAX_VALUE; fartestTooCloseDistanceSq = 0.0D; for (LivingEntity entity : nearbyEntities) { if (!BiomeHelper.isDesertBiome((Entity)entity) || m_9236_().m_45517_(LightLayer.SKY, entity.m_20183_()) <= 0) continue;  double deltaX = entity.m_20185_() - headPos.f_82479_; double deltaZ = entity.m_20189_() - headPos.f_82481_; double distanceSq = deltaX * deltaX + deltaZ * deltaZ; double deltaY = entity.m_20186_() - headPos.f_82480_; if (distanceSq >= 400.0D && deltaY <= yRange) { if (distanceSq < closestDistanceSq) { closestDistanceSq = distanceSq; livingEntity1 = entity; }  continue; }  if (deltaY <= yRange && distanceSq > fartestTooCloseDistanceSq) { fartestTooCloseDistanceSq = distanceSq; livingEntity2 = entity; }  }  }  if (livingEntity1 == null) livingEntity1 = livingEntity2;  this.aggroTargetEntity = livingEntity1; if (livingEntity1 == null) { this.noTargetEscapeTimer++; } else { this.noTargetEscapeTimer = 0; }  }
/*     */   private boolean predictBreach(Level level, WormSegment head) { Vec3 targetedObjectPos = getTargetedObjectPos(); if (targetedObjectPos != null && targetedObjectPos.f_82480_ - head.m_20186_() > 20.0D) return false;  Vec3 futurePos = head.m_20182_().m_82549_(head.getDirectionVector().m_82490_(10.0D)); BlockPos futureBPos = new BlockPos((int)futurePos.f_82479_, (int)futurePos.f_82480_, (int)futurePos.f_82481_); return (!level.m_8055_(futureBPos).m_60828_((BlockGetter)level, futureBPos) && !level.m_8055_(futureBPos).m_60713_(Blocks.f_50627_)); }
/*     */   private void addWormSegment(float length, Vec3 dirVec, Vec3 scale) { if (!m_9236_().m_5776_()) if (this.segments.isEmpty()) { WormSegment chainSegment = new WormSegment((EntityType)ModEntities.WORM_SEGMENT.get(), m_9236_()); chainSegment.setLength(length); chainSegment.setDirectionVector(dirVec); chainSegment.setVisualScale(scale); chainSegment.setOwnerEntityUUID(m_20148_()); Vec3 pos = m_20182_(); chainSegment.m_20219_(pos); this.segments.add(chainSegment); this.segmentsUUIDs.add(chainSegment.m_20148_()); m_9236_().m_7967_((Entity)chainSegment); } else { WormSegment chainSegment = new WormSegment((EntityType)ModEntities.WORM_SEGMENT.get(), m_9236_()); chainSegment.setLength(length); chainSegment.setDirectionVector(dirVec); chainSegment.setVisualScale(scale); chainSegment.setOwnerEntityUUID(m_20148_()); Vec3 pos = ((ChainSegment)this.segments.get(this.segments.size() - 1)).m_20182_(); chainSegment.m_20219_(pos); this.segments.add(chainSegment); this.segmentsUUIDs.add(chainSegment.m_20148_()); m_9236_().m_7967_((Entity)chainSegment); }   this.segmentCount++; }
/* 497 */   private void addHeadSegment(float length, Vec3 dirVec, Vec3 scale) { if (!m_9236_().m_5776_()) { if (this.segments.isEmpty()) { System.err.println("worm head spawned not as last segment"); return; }  WormSegment chainSegment = new WormHeadSegment((EntityType)ModEntities.WORM_HEAD_SEGMENT.get(), m_9236_()); chainSegment.setLength(length); chainSegment.setDirectionVector(dirVec); chainSegment.setVisualScale(scale); chainSegment.setOwnerEntityUUID(m_20148_()); Vec3 pos = ((ChainSegment)this.segments.get(this.segments.size() - 1)).m_20182_().m_82549_(dirVec.m_82541_().m_82490_(length)); chainSegment.m_20219_(pos); this.segments.add(chainSegment); this.segmentsUUIDs.add(chainSegment.m_20148_()); m_9236_().m_7967_((Entity)chainSegment); }  this.segmentCount++; } public void fabrik() { int i = 0; while (Math.abs(this.target.m_82546_(((ChainSegment)this.segments.get(this.segmentCount - 1)).m_20182_()).m_82553_()) > this.tolerance && i <= 10) { fabrikForward(); i++; }  } public void applyAcceleration(Vec3 accel) { super.applyAcceleration(accel); if (this.targetV.m_82553_() > SPEED_SCALE) this.targetV = this.targetV.m_82541_().m_82490_(SPEED_SCALE);  } public void blastHit() { this.targetV = new Vec3(this.targetV.f_82479_ * 0.075D, this.targetV.f_82480_ + 1.2D, this.targetV.f_82481_ * 0.075D); sonicBoom(); this.explodedTimes++; if (this.explodedTimes >= ((Integer)CommonConfigs.HEALTH.get()).intValue()) { ItemEntity toothItem = new ItemEntity(m_9236_(), this.head.m_20185_(), this.head.m_20186_(), this.head.m_20189_(), new ItemStack((ItemLike)ModItems.WORM_TOOTH.get(), 1)); m_9236_().m_7967_((Entity)toothItem); this.escaping = true; }  } public void setAggroTargetEntity(LivingEntity target) { this.aggroTargetEntity = target; } public void m_142687_(Entity.RemovalReason pReason) { if (!m_9236_().m_5776_()) for (int i = 0; i < this.segments.size(); ) { if (this.segments.get(i) != null) ((ChainSegment)this.segments.get(i)).m_146870_();  i++; }   super.m_142687_(pReason); } private void sinkHole(Level level, Vec3 pos) { WormRippleWorldEvent breachEvent = (new WormRippleWorldEvent()).spawnRipple(pos);
/* 498 */     breachEvent.start(level);
/* 499 */     breachEvent.setDirty();
/* 500 */     WorldEventHandler.addWorldEvent(level, (WorldEventInstance)breachEvent); }
/*     */ 
/*     */   
/*     */   private void sonicBoom() {
/* 504 */     if (this.head == null)
/* 505 */       return;  SonicBoomWorldEvent breachEvent = (new SonicBoomWorldEvent()).spawnRipple((Entity)this.head);
/* 506 */     breachEvent.start(m_9236_());
/* 507 */     breachEvent.setDirty();
/* 508 */     WorldEventHandler.addWorldEvent(m_9236_(), (WorldEventInstance)breachEvent);
/*     */     
/* 510 */     List<Player> players = m_9236_().m_6907_();
/*     */     
/* 512 */     players.forEach(player -> {
/*     */           float dist = player.m_20270_((Entity)this.head);
/*     */           if (dist <= 100.0F) {
/*     */             LodestonePacketRegistry.LODESTONE_CHANNEL.send(PacketDistributor.PLAYER.with(()), (new PositionedScreenshakePacket(80, this.head.m_20182_(), 200.0F, 100.0F)).setEasing(Easing.CUBIC_OUT).setIntensity(0.85F));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   private Vec3 getTargetedObjectPos() {
/* 522 */     if (this.thumperTarget != null) {
/* 523 */       BlockEntity thumper = m_9236_().getExistingBlockEntity(BlockPos.m_274561_(this.thumperTarget.f_82479_, this.thumperTarget.f_82480_, this.thumperTarget.f_82481_));
/* 524 */       if (thumper == null || thumper.m_58903_() != ModBlockEntities.THUMPER_ENTITY.get()) this.thumperTarget = null; 
/* 525 */       return this.thumperTarget;
/*     */     } 
/* 527 */     if (this.aggroTargetEntity != null) return this.aggroTargetEntity.m_20182_(); 
/* 528 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7378_(CompoundTag pCompound) {
/* 533 */     super.m_7378_(pCompound);
/* 534 */     this.removed = pCompound.m_128471_("removed");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7380_(CompoundTag pCompound) {
/* 539 */     super.m_7380_(pCompound);
/* 540 */     pCompound.m_128379_("removed", this.removed);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\IK\worm\WormChainEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */