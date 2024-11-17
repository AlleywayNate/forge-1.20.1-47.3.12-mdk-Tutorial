/*    */ package net.nastynate.sandworm_mod.vfx;
/*    */ 
/*    */

import org.joml.Vector3f;
import team.lodestar.lodestone.systems.postprocess.DynamicShaderFxInstance;

import java.util.function.BiConsumer;
/*    */ 
/*    */ public class SonicBoomFx extends DynamicShaderFxInstance {
/*    */   public Vector3f center;
/*    */   public float radius;
/*    */   public float speed;
/*    */   public float magnitude;
/*    */   public float frequency;
/*    */   
/*    */   public SonicBoomFx(Vector3f center, float radius, float speed, float magnitude, float frequency) {
/* 15 */     this.center = center;
/* 16 */     this.radius = radius;
/* 17 */     this.speed = speed;
/* 18 */     this.magnitude = magnitude;
/* 19 */     this.frequency = frequency;
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeDataToBuffer(BiConsumer<Integer, Float> writer) {
/* 24 */     writer.accept(Integer.valueOf(0), Float.valueOf(this.center.x()));
/* 25 */     writer.accept(Integer.valueOf(1), Float.valueOf(this.center.y()));
/* 26 */     writer.accept(Integer.valueOf(2), Float.valueOf(this.center.z()));
/* 27 */     writer.accept(Integer.valueOf(3), Float.valueOf(this.radius));
/* 28 */     writer.accept(Integer.valueOf(4), Float.valueOf(this.speed));
/* 29 */     writer.accept(Integer.valueOf(5), Float.valueOf(this.magnitude));
/* 30 */     writer.accept(Integer.valueOf(6), Float.valueOf(this.frequency));
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\vfx\SonicBoomFx.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */