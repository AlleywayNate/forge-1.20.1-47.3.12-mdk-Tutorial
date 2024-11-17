/*    */ package net.nastynate.sandworm_mod.block.thumper;
/*    */ 
/*    */

import net.jelly.sandworm_mod.block.ThumperBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/*    */ 
/*    */ 
/*    */ public class ThumperModel
/*    */   extends GeoModel<ThumperBlockEntity>
/*    */ {
/*    */   public ResourceLocation getModelResource(ThumperBlockEntity thumperBlockEntity) {
/* 13 */     return new ResourceLocation("sandworm_mod", "geo/thumper.geo.json");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTextureResource(ThumperBlockEntity thumperBlockEntity) {
/* 18 */     return new ResourceLocation("minecraft", "textures/block/piston_side.png");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getAnimationResource(ThumperBlockEntity thumperBlockEntity) {
/* 23 */     return new ResourceLocation("sandworm_mod", "animations/thumper.animation.json");
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\block\thumper\ThumperModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */