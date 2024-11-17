/*    */ package net.nastynate.sandworm_mod.worldevents;
/*    */ 
/*    */

import net.jelly.sandworm_mod.registry.common.WorldEventRegistry;
import net.jelly.sandworm_mod.vfx.SonicBoomFx;
import net.jelly.sandworm_mod.vfx.SonicBoomPostProcessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import team.lodestar.lodestone.systems.postprocess.DynamicShaderFxInstance;
import team.lodestar.lodestone.systems.worldevent.WorldEventInstance;
/*    */ 
/*    */ public class SonicBoomWorldEvent extends WorldEventInstance {
/* 12 */   public int lifetime = 0;
/*    */   private Entity followEntity;
/*    */   public SonicBoomFx fx;
/* 15 */   private int in = 10;
/* 16 */   private int sustain = 30;
/* 17 */   private int out = 30;
/*    */   
/* 19 */   private static float maxRadius = 1.0F;
/* 20 */   private static float maxSpeed = 50.0F;
/* 21 */   private static float maxMagnitude = 0.03F;
/* 22 */   private static float maxFrequency = 160.0F;
/*    */   
/*    */   public SonicBoomWorldEvent() {
/* 25 */     super(WorldEventRegistry.WORM_BREACH);
/*    */   }
/*    */   
/*    */   public SonicBoomWorldEvent spawnRipple(Entity followEntity) {
/* 29 */     this.followEntity = followEntity;
/* 30 */     if (followEntity == null) {
/* 31 */       this.discarded = true;
/* 32 */       return this;
/*    */     } 
/* 34 */     this.fx = new SonicBoomFx(followEntity.m_20182_().m_252839_(), 0.0F, 0.0F, 0.0F, 0.0F);
/* 35 */     SonicBoomPostProcessor.INSTANCE.addFxInstance((DynamicShaderFxInstance)this.fx);
/* 36 */     SonicBoomPostProcessor.INSTANCE.setActive(true);
/* 37 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick(Level level) {
/* 42 */     if (this.level == null)
/* 43 */       return;  if (this.followEntity != null) this.fx.center = this.followEntity.m_20182_().m_252839_(); 
/* 44 */     if (this.lifetime <= this.in) {
/* 45 */       this.fx.radius = lerp(0.0F, maxRadius, this.lifetime / this.in);
/* 46 */       this.fx.speed = lerp(0.0F, maxSpeed, this.lifetime / this.in);
/* 47 */       this.fx.magnitude = lerp(0.0F, maxMagnitude, this.lifetime / this.in);
/* 48 */       this.fx.frequency = lerp(0.0F, maxFrequency, this.lifetime / this.in);
/*    */     }
/* 50 */     else if (this.lifetime >= this.in + this.sustain) {
/*    */ 
/*    */       
/* 53 */       this.fx.magnitude = lerp(maxMagnitude, 0.0F, this.lifetime / (this.in + this.sustain + this.out));
/*    */     } 
/*    */     
/* 56 */     this.lifetime++;
/* 57 */     if (this.lifetime >= this.in + this.sustain + this.out) {
/* 58 */       this.fx.remove();
/* 59 */       end(level);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   float lerp(float a, float b, float f) {
/* 65 */     return (float)(a * (1.0D - f)) + b * f;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\worldevents\SonicBoomWorldEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */