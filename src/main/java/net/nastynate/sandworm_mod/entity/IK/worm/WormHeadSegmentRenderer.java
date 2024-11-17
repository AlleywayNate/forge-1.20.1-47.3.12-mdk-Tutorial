/*    */ package net.nastynate.sandworm_mod.entity.IK.worm;
/*    */ 
/*    */

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Vector3fc;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
/*    */ 
/*    */ public class WormHeadSegmentRenderer extends GeoEntityRenderer<WormHeadSegment> {
/*    */   public WormHeadSegmentRenderer(EntityRendererProvider.Context renderManager) {
/* 15 */     super(renderManager, new WormHeadSegmentModel());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldRender(WormHeadSegment pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
/* 20 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(WormHeadSegment entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
/* 25 */     poseStack.m_85836_();
/* 26 */     Vec3 dirVec = entity.getDirectionVector();
/* 27 */     Vec3 upVec = entity.getUpVector();
/* 28 */     Matrix4f matrix = new Matrix4f();
/* 29 */     matrix.rotateTowards((Vector3fc)dirVec.m_252839_(), (Vector3fc)upVec.m_252839_());
/* 30 */     Vec3 scaleVec = entity.getVisualScale();
/*    */ 
/*    */     
/* 33 */     poseStack.m_85837_(0.0D, scaleVec.f_82480_ / 2.0D, 0.0D);
/* 34 */     poseStack.m_252931_(matrix);
/* 35 */     poseStack.m_85841_((float)scaleVec.f_82479_, (float)scaleVec.f_82480_, (float)scaleVec.f_82481_);
/*    */     
/* 37 */     super.m_7392_((Entity)entity, entityYaw, partialTick, poseStack, bufferSource, 15728640);
/* 38 */     poseStack.m_85849_();
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\IK\worm\WormHeadSegmentRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */