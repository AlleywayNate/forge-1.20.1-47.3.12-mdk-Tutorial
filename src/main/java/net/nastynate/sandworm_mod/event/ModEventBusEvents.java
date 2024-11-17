/*    */ package net.nastynate.sandworm_mod.event;
/*    */ 
/*    */

import net.jelly.sandworm_mod.capabilities.wormsign.WormSign;
import net.jelly.sandworm_mod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.function.Supplier;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "sandworm_mod", bus = EventBusSubscriber.Bus.MOD)
/*    */ public class ModEventBusEvents
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void registerAttributes(EntityAttributeCreationEvent event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
/* 25 */     event.register(WormSign.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void buildContents(BuildCreativeModeTabContentsEvent event) {
/* 32 */     if (event.getTabKey() == CreativeModeTabs.f_256968_) {
/* 33 */       event.accept((Supplier)ModItems.WORM_TOOTH);
/*    */     }
/* 35 */     else if (event.getTabKey() == CreativeModeTabs.f_257028_ || event.getTabKey() == CreativeModeTabs.f_256731_) {
/* 36 */       event.accept((Supplier)ModItems.THUMPER_ITEM);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\event\ModEventBusEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */