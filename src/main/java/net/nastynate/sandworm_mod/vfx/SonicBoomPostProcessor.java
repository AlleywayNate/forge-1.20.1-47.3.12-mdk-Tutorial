/*    */ package net.nastynate.sandworm_mod.vfx;
/*    */ 
/*    */

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.resources.ResourceLocation;
import team.lodestar.lodestone.systems.postprocess.MultiInstancePostProcessor;
/*    */ 
/*    */ public class SonicBoomPostProcessor
/*    */   extends MultiInstancePostProcessor<SonicBoomFx> {
/* 10 */   public static final SonicBoomPostProcessor INSTANCE = new SonicBoomPostProcessor();
/*    */   
/*    */   private EffectInstance effectGlow;
/*    */   
/*    */   public ResourceLocation getPostChainLocation() {
/* 15 */     return new ResourceLocation("sandworm_mod", "sonic_boom_post");
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getMaxInstances() {
/* 20 */     return 16;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected int getDataSizePerInstance() {
/* 26 */     return 7;
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {
/* 31 */     super.init();
/* 32 */     if (this.postChain != null) {
/* 33 */       this.effectGlow = this.effects[0];
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void beforeProcess(PoseStack viewModelStack) {
/* 39 */     super.beforeProcess(viewModelStack);
/* 40 */     setDataBufferUniform(this.effectGlow, "DataBuffer", "InstanceCount");
/*    */   }
/*    */   
/*    */   public void afterProcess() {}
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\vfx\SonicBoomPostProcessor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */