/*    */ package net.nastynate.sandworm_mod.entity.IK.worm;
/*    */ 
/*    */

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WormSegmentModel
/*    */   extends GeoModel<WormSegment>
/*    */ {
/*    */   public ResourceLocation getModelResource(WormSegment wormSegment) {
/* 13 */     return new ResourceLocation("sandworm_mod", "geo/worm_segment.geo.json");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTextureResource(WormSegment wormSegment) {
/* 18 */     return new ResourceLocation("sandworm_mod", "textures/entity/worm_segment_texture.png");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getAnimationResource(WormSegment wormSegment) {
/* 23 */     return new ResourceLocation("sandworm_mod", "animations/no_animation.json");
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\IK\worm\WormSegmentModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */