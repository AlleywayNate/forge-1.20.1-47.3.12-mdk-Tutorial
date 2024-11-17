/*    */ package net.nastynate.sandworm_mod.item;
/*    */ 
/*    */

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/*    */ 
/*    */ public class ThumperItemModel
/*    */   extends GeoModel<ThumperItem>
/*    */ {
/*    */   public ResourceLocation getModelResource(ThumperItem thumperItem) {
/* 11 */     return new ResourceLocation("sandworm_mod", "geo/thumper.geo.json");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTextureResource(ThumperItem thumperItem) {
/* 16 */     return new ResourceLocation("minecraft", "textures/block/piston_side.png");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getAnimationResource(ThumperItem thumperItem) {
/* 21 */     return new ResourceLocation("sandworm_mod", "animations/thumper.animation.json");
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\item\ThumperItemModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */