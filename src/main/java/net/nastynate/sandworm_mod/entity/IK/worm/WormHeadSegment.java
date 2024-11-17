/*    */ package net.nastynate.sandworm_mod.entity.IK.worm;
/*    */ 
/*    */

import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.jelly.sandworm_mod.config.CommonConfigs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
/*    */ 
/*    */ public class WormHeadSegment
/*    */   extends WormSegment implements GeoEntity {
/* 13 */   private static final ParticleEmitterInfo SPLASH = new ParticleEmitterInfo(new ResourceLocation("sandworm_mod", "herald"));
/*    */   public WormHeadSegment(EntityType<?> pEntityType, Level pLevel) {
/* 15 */     super(pEntityType, pLevel);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8119_() {
/* 20 */     super.m_8119_();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected double getDamage() {
/* 26 */     return super.getDamage() * ((Double)CommonConfigs.HEAD_MULTIPLIER.get()).doubleValue();
/*    */   } protected Vec3 getKB() {
/* 28 */     return new Vec3(5.0D, 2.0D, 5.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\IK\worm\WormHeadSegment.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */