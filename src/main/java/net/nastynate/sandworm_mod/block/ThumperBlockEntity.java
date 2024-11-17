/*     */ package net.nastynate.sandworm_mod.block;
/*     */

import net.jelly.sandworm_mod.advancements.AdvancementTriggerRegistry;
import net.jelly.sandworm_mod.config.CommonConfigs;
import net.jelly.sandworm_mod.entity.IK.worm.WormChainEntity;
import net.jelly.sandworm_mod.helper.WarningSpawnHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
/*     */ 
/*     */ public class ThumperBlockEntity extends BlockEntity implements GeoBlockEntity {
/*  27 */   private AnimatableInstanceCache cache = (AnimatableInstanceCache)new SingletonAnimatableInstanceCache((GeoAnimatable)this);
/*     */   private boolean thumping = false;
/*  29 */   private int wormSign = 0;
/*  30 */   private int pauseTicks = 0;
/*  31 */   private int soundTimer = 50;
/*     */   private boolean startAnimation = false;
/*     */   
/*     */   public ThumperBlockEntity(BlockPos pPos, BlockState pBlockState) {
/*  35 */     super((BlockEntityType)ModBlockEntities.THUMPER_ENTITY.get(), pPos, pBlockState);
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
/*  40 */     controllerRegistrar.add(new AnimationController[] { new AnimationController((GeoAnimatable)this, "controller", 0, this::predicate) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
/*  46 */     if (this.startAnimation) { tAnimationState.getController().setAnimation(RawAnimation.begin().thenPlay("thump")); }
/*  47 */     else { tAnimationState.getController().setAnimation(RawAnimation.begin().thenWait(2)); }
/*  48 */      return PlayState.CONTINUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnimatableInstanceCache getAnimatableInstanceCache() {
/*  53 */     return this.cache;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void tick(Level level, BlockPos blockPos, BlockState blockState, ThumperBlockEntity e) {
/*  58 */     e.thumping = ((Boolean)blockState.m_61143_((Property)ThumperBlock.THUMPING)).booleanValue();
/*     */ 
/*     */     
/*  61 */     if (e.thumping)
/*  62 */     { if (e.soundTimer == 40) {
/*  63 */         e.startAnimation = false;
/*     */       }
/*  65 */       else if (e.soundTimer == 52) {
/*  66 */         level.m_5594_(null, blockPos, (SoundEvent)ModSounds.THUMPER.get(), SoundSource.BLOCKS, 7.0F, 1.0F);
/*     */       } 
/*  68 */       if (e.soundTimer >= 55) {
/*  69 */         e.startAnimation = true;
/*  70 */         e.soundTimer = 0;
/*     */       } else {
/*  72 */         e.soundTimer++;
/*     */       }  }
/*  74 */     else { e.soundTimer = 39; }
/*     */ 
/*     */     
/*  77 */     if (level.m_5776_())
/*  78 */       return;  if (!level.m_8055_(blockPos.m_7495_()).m_280296_()) level.m_46961_(blockPos, true);
/*     */ 
/*     */     
/*  81 */     if (e.pauseTicks > 0) {
/*  82 */       e.pauseTicks--;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  88 */     if (!level.m_45976_(WormChainEntity.class, new AABB(blockPos.m_252807_().m_82520_(600.0D, 200.0D, 600.0D), blockPos.m_252807_().m_82492_(600.0D, 200.0D, 600.0D))).isEmpty()) {
/*  89 */       e.wormSign = 0;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  94 */     if (e.thumping && BiomeHelper.isDesertBiome((ServerLevel)level, blockPos)) { e.wormSign++; }
/*     */     else
/*  96 */     { if (e.wormSign > 0) e.wormSign--;
/*     */       
/*     */       return; }
/*     */     
/* 100 */     if (e.thumping && e.wormSign == ((Integer)CommonConfigs.SPAWNWORM_WORMSIGN.get()).intValue() / 20) {
/*     */       
/* 102 */       e.pauseTicks = 500;
/* 103 */       e.wormSign++;
/* 104 */       WarningSpawnHelper.thumperWarning(level, blockPos.m_252807_());
/*     */     }
/* 106 */     else if (e.wormSign >= ((Integer)CommonConfigs.SPAWNWORM_WORMSIGN.get()).intValue() / 10) {
/* 107 */       e.wormSign = 0;
/* 108 */       e.pauseTicks = 500;
/* 109 */       WarningSpawnHelper.spawnWormThumper(level, blockPos);
/* 110 */       level.m_45955_(TargetingConditions.m_148353_(), null, new AABB(blockPos
/* 111 */             .m_7918_(50, 200, 50), blockPos.m_7918_(-50, -200, -50))).forEach(player -> AdvancementTriggerRegistry.THUMPER.trigger((ServerPlayer)player));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\block\ThumperBlockEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */