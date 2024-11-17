/*    */ package net.nastynate.sandworm_mod.registry.common;
/*    */ 
/*    */

import net.minecraft.resources.ResourceLocation;
import team.lodestar.lodestone.registry.common.LodestoneWorldEventTypeRegistry;
import team.lodestar.lodestone.systems.worldevent.WorldEventType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldEventRegistry
/*    */ {
/* 12 */   public static WorldEventType WORM_BREACH = LodestoneWorldEventTypeRegistry.registerEventType(new WorldEventType(new ResourceLocation("sandworm_mod", "worm_breach"), net.jelly.sandworm_mod.worldevents.WormBreachWorldEvent::new));
/* 13 */   public static WorldEventType WORM_RIPPLE = LodestoneWorldEventTypeRegistry.registerEventType(new WorldEventType(new ResourceLocation("sandworm_mod", "worm_ripple"), net.jelly.sandworm_mod.worldevents.WormRippleWorldEvent::new));
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\registry\common\WorldEventRegistry.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */