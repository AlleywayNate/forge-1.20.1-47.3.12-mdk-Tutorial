/*    */ package net.nastynate.sandworm_mod.entity.IK;
/*    */ 
/*    */

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry;
import team.lodestar.lodestone.systems.rendering.VFXBuilders;
import team.lodestar.lodestone.systems.rendering.rendeertype.RenderTypeToken;

import java.awt.*;
/*    */ 
/*    */ public class ChainSegmentRenderer
/*    */   extends EntityRenderer<ChainSegment> {
/*    */   public ChainSegmentRenderer(EntityRendererProvider.Context pContext) {
/* 19 */     super(pContext);
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTextureLocation(ChainSegment pEntity) {
/* 24 */     return null;
/*    */   }
/*    */   
/* 27 */   protected static final ResourceLocation LIGHT_TRAIL = new ResourceLocation("sandworm_mod", "textures/vfx/light_trail.png");
/* 28 */   protected static final RenderType LIGHT_TYPE = (RenderType)LodestoneRenderTypeRegistry.ADDITIVE_TEXTURE.apply(RenderTypeToken.createToken(LIGHT_TRAIL));
/*    */ 
/*    */   
/*    */   public void render(ChainSegment pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
/* 32 */     super.m_7392_(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
/*    */ 
/*    */     
/* 35 */     VFXBuilders.WorldVFXBuilder builder = VFXBuilders.createWorld();
/* 36 */     builder.setColor(new Color(255, 0, 0));
/*    */ 
/*    */     
/* 39 */     pPoseStack.m_85836_();
/* 40 */     Vec3 position = pEntity.m_20318_(pPartialTick);
/* 41 */     pPoseStack.m_85837_(-position.f_82479_, -position.f_82480_, -position.f_82481_);
/*    */     
/* 43 */     Vec3 startPosition = position.m_82549_(pEntity.getDirectionVector().m_82541_().m_82490_(-pEntity.getLength()));
/*    */ 
/*    */ 
/*    */     
/* 47 */     pPoseStack.m_85849_();
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\IK\ChainSegmentRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */