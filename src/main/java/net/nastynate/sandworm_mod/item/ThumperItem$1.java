/*    */ package net.jelly.sandworm_mod.item;
/*    */ 
/*    */

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements IClientItemExtensions
/*    */ {
/*    */   private ThumperItemRenderer renderer;
/*    */   
/*    */   public BlockEntityWithoutLevelRenderer getCustomRenderer() {
/* 35 */     if (this.renderer == null) this.renderer = new ThumperItemRenderer(); 
/* 36 */     return (BlockEntityWithoutLevelRenderer)this.renderer;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\item\ThumperItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */