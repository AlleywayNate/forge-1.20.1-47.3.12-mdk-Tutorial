/*    */ package net.nastynate.sandworm_mod.worldevents;
/*    */ 
/*    */

import net.jelly.sandworm_mod.registry.common.WorldEventRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import team.lodestar.lodestone.systems.worldevent.WorldEventInstance;
/*    */ 
/*    */ public class WormRippleWorldEvent extends WorldEventInstance {
/* 15 */   public int lifetime = 30; public Vec3 position;
/* 16 */   public int scale = 2;
/*    */   
/* 18 */   public int in = 100;
/* 19 */   public int out = 30;
/*    */   
/*    */   public WormRippleWorldEvent() {
/* 22 */     super(WorldEventRegistry.WORM_RIPPLE);
/*    */   }
/*    */   
/*    */   public WormRippleWorldEvent spawnRipple(Vec3 pos) {
/* 26 */     this.position = pos;
/* 27 */     return this;
/*    */   }
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
/*    */   
/*    */   public void tick(Level level) {
/* 45 */     if (this.level == null)
/*    */       return; 
/* 47 */     if (this.lifetime <= 0) {
/* 48 */       end(level);
/*    */     }
/*    */     
/* 51 */     if (!this.level.f_46443_ && this.lifetime > 0) {
/* 52 */       spawnSpiralParticles(this.position, this.lifetime);
/*    */     }
/* 54 */     this.lifetime--;
/*    */     
/* 56 */     super.tick(level);
/*    */   }
/*    */   
/*    */   private void spawnSpiralParticles(Vec3 pos, int lifetime) {
/* 60 */     for (int t = 0; t < 360; t++) {
/* 61 */       if (t % 10 == 0) {
/* 62 */         int theta = t - 12 * lifetime;
/* 63 */         spawnParticle(new Vec3(pos.f_82479_ + this.scale * lifetime / 30.0D * t / 20.0D * Math.cos(Math.toRadians(theta)), pos.f_82480_, pos.f_82481_ + this.scale * lifetime / 30.0D * t / 20.0D * Math.sin(Math.toRadians(theta))));
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void spawnParticle(Vec3 pos) {
/* 69 */     int heightDecrement = 0;
/* 70 */     BlockPos blockPos = BlockPos.m_274561_(pos.f_82479_, pos.f_82480_ - 1.0D, pos.f_82481_);
/* 71 */     BlockState blockState = this.level.m_8055_(blockPos);
/* 72 */     while (blockState.m_60795_()) {
/* 73 */       blockPos = BlockPos.m_274561_(pos.f_82479_, pos.f_82480_ - 1.0D - heightDecrement, pos.f_82481_);
/* 74 */       blockState = this.level.m_8055_(blockPos);
/* 75 */       heightDecrement++;
/* 76 */       if (heightDecrement >= 20)
/*    */         break; 
/*    */     } 
/* 79 */     BlockParticleOption blockParticle = new BlockParticleOption(ParticleTypes.f_123794_, blockState);
/*    */     
/* 81 */     ((ServerLevel)this.level).m_8767_((ParticleOptions)blockParticle, pos.f_82479_, (blockPos
/*    */ 
/*    */         
/* 84 */         .m_123342_() + 1), pos.f_82481_, 1, 0.2D, 0.0D, 0.2D, 0.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   float lerp(float a, float b, float f) {
/* 96 */     return (float)(a * (1.0D - f)) + b * f;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\worldevents\WormRippleWorldEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */