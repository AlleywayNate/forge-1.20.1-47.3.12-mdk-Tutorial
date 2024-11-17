/*    */ package net.nastynate.sandworm_mod.entity.IK.worm;
/*    */ 
/*    */

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WormHeadSegmentModel
/*    */   extends GeoModel<WormHeadSegment>
/*    */ {
/*    */   public ResourceLocation getModelResource(WormHeadSegment wormHeadSegment) {
/* 13 */     return new ResourceLocation("sandworm_mod", "geo/worm_segment_head.geo.json");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTextureResource(WormHeadSegment wormHeadSegment) {
/* 18 */     return new ResourceLocation("sandworm_mod", "textures/entity/worm_head_segment_texture.png");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getAnimationResource(WormHeadSegment wormHeadSegment) {
/* 23 */     return new ResourceLocation("sandworm_mod", "animations/no_animation.json");
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\IK\worm\WormHeadSegmentModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */