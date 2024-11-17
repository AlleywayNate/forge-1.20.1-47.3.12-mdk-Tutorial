/*    */ package net.nastynate.sandworm_mod.item;
/*    */ 
/*    */

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import java.util.function.Consumer;
/*    */ 
/*    */ public class ThumperItem extends BlockItem implements GeoItem {
/* 21 */   private AnimatableInstanceCache cache = (AnimatableInstanceCache)new SingletonAnimatableInstanceCache((GeoAnimatable)this);
/*    */   
/*    */   public ThumperItem(Block pBlock, Properties pProperties) {
/* 24 */     super(pBlock, pProperties);
/* 25 */     SingletonGeoAnimatable.registerSyncedAnimatable((GeoAnimatable)this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
/* 30 */     consumer.accept(new IClientItemExtensions()
/*    */         {
/*    */           private ThumperItemRenderer renderer;
/*    */           
/*    */           public BlockEntityWithoutLevelRenderer getCustomRenderer() {
/* 35 */             if (this.renderer == null) this.renderer = new ThumperItemRenderer(); 
/* 36 */             return (BlockEntityWithoutLevelRenderer)this.renderer;
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
/* 43 */     controllerRegistrar.add(new AnimationController[] { new AnimationController((GeoAnimatable)this, "controller", 0, this::predicate) });
/*    */   }
/*    */   
/*    */   private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
/* 47 */     return PlayState.STOP;
/*    */   }
/*    */ 
/*    */   
/*    */   public AnimatableInstanceCache getAnimatableInstanceCache() {
/* 52 */     return this.cache;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getTick(Object itemStack) {
/* 57 */     return RenderUtils.getCurrentTick();
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\item\ThumperItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */