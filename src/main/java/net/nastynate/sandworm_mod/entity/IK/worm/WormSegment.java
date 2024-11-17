/*     */ package net.nastynate.sandworm_mod.entity.IK.worm;
/*     */ 
/*     */

import net.jelly.sandworm_mod.config.CommonConfigs;
import net.jelly.sandworm_mod.entity.IK.ChainSegment;
import net.jelly.sandworm_mod.registry.common.DamageTypesRegistry;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

import java.util.List;
import java.util.UUID;
/*     */ 
/*     */ public class WormSegment extends ChainSegment implements GeoEntity {
/*  29 */   private static int STAGE_TRACK = 0;
/*  30 */   private static int STAGE_BURROW = 1;
/*  31 */   private int stage = 0;
/*  32 */   private AnimatableInstanceCache cache = (AnimatableInstanceCache)new SingletonAnimatableInstanceCache((GeoAnimatable)this);
/*     */   private UUID ownerEntityUUID;
/*  34 */   private int discardTimer = 0;
/*  35 */   private DamageSource dmgSource = new DamageSource((Holder)
/*  36 */       m_9236_().m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypesRegistry.WORM));
/*     */   
/*     */   public WormSegment(EntityType<?> pEntityType, Level pLevel) {
/*  39 */     super(pEntityType, pLevel);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  44 */     super.m_8119_();
/*  45 */     m_7618_(EntityAnchorArgument.Anchor.FEET, m_20182_().m_82549_(getDirectionVector()));
/*     */     
/*  47 */     if (!m_9236_().m_5776_()) {
/*     */       
/*  49 */       if (getOwner() == null)
/*  50 */       { if (this.discardTimer < 120) { this.discardTimer++; }
/*  51 */         else { m_146870_(); }
/*     */          }
/*  53 */       else { this.discardTimer = 0; }
/*     */ 
/*     */       
/*  56 */       List<Entity> collidingEntities = m_9236_().m_45933_((Entity)this, m_20191_());
/*  57 */       for (int i = 0; i < collidingEntities.size(); i++) {
/*  58 */         if (collidingEntities.get(i) instanceof LivingEntity) {
/*  59 */           LivingEntity target = (LivingEntity)collidingEntities.get(i);
/*  60 */           if (target.f_20916_ == 0) {
/*  61 */             Vec3 vec3 = target.m_20182_().m_82546_(m_20182_()).m_82541_();
/*  62 */             target.m_6469_(this.dmgSource, (float)getDamage());
/*  63 */             Vec3 knockback = getKB();
/*  64 */             target.m_246865_(new Vec3(vec3.f_82479_ * knockback.f_82479_, vec3.f_82480_ * knockback.f_82480_, vec3.f_82481_ * knockback.f_82481_));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected double getDamage() {
/*  72 */     return 10.0D * ((Double)CommonConfigs.DAMAGE_SCALE.get()).doubleValue(); } protected Vec3 getKB() {
/*  73 */     return new Vec3(3.0D, 2.0D, 3.0D);
/*     */   }
/*     */   
/*     */   protected void m_8097_() {
/*  77 */     super.m_8097_();
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
/*  82 */     controllerRegistrar.add(new AnimationController[] { new AnimationController((GeoAnimatable)this, "controller", 0, this::predicate) });
/*     */   }
/*     */   private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
/*  85 */     return PlayState.CONTINUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnimatableInstanceCache getAnimatableInstanceCache() {
/*  90 */     return this.cache;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7378_(CompoundTag pCompound) {
/*  95 */     super.m_7378_(pCompound);
/*  96 */     this.ownerEntityUUID = pCompound.m_128342_("chain_entity_UUID");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7380_(CompoundTag pCompound) {
/* 101 */     super.m_7380_(pCompound);
/* 102 */     pCompound.m_128362_("chain_entity_UUID", this.ownerEntityUUID);
/*     */   }
/*     */   
/*     */   public void setOwnerEntityUUID(UUID uuid) {
/* 106 */     this.ownerEntityUUID = uuid;
/*     */   }
/*     */   public WormChainEntity getOwner() {
/* 109 */     List<WormChainEntity> nearbyChainEntities = m_9236_().m_45976_(WormChainEntity.class, new AABB(
/*     */           
/* 111 */           m_20182_().m_82520_(200.0D, 200.0D, 200.0D), m_20182_().m_82520_(-200.0D, -200.0D, -200.0D)));
/*     */     
/* 113 */     return nearbyChainEntities
/* 114 */       .stream()
/* 115 */       .filter(obj -> obj.m_20149_().equals(this.ownerEntityUUID.toString()))
/* 116 */       .findFirst()
/* 117 */       .orElse(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6783_(double pDistance) {
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\IK\worm\WormSegment.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */