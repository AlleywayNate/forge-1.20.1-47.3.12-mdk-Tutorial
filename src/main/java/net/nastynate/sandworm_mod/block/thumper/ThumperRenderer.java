/*    */ package net.nastynate.sandworm_mod.block.thumper;
/*    */ 
/*    */

import net.jelly.sandworm_mod.block.ThumperBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
/*    */ 
/*    */ public class ThumperRenderer
/*    */   extends GeoBlockRenderer<ThumperBlockEntity>
/*    */ {
/*    */   public ThumperRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
/* 16 */     super(new ThumperModel());
/*    */   }
/*    */ 
/*    */   
/*    */   public RenderType getRenderType(ThumperBlockEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
/* 21 */     return RenderType.m_110473_(getTextureLocation((GeoAnimatable)animatable));
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\block\thumper\ThumperRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */