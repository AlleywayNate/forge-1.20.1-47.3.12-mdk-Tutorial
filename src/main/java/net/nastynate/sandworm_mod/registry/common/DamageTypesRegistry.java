/*    */ package net.nastynate.sandworm_mod.registry.common;
/*    */ 
/*    */

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
/*    */ 
/*    */ public class DamageTypesRegistry
/*    */ {
/* 11 */   public static final ResourceKey<DamageType> WORM = register("worm");
/*    */   
/*    */   private static ResourceKey<DamageType> register(String name) {
/* 14 */     return ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("sandworm_mod", name));
/*    */   }
/*    */   
/*    */   public static void bootstrap(BootstapContext<DamageType> context) {
/* 18 */     context.m_255272_(WORM, new DamageType("worm", 0.1F));
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\registry\common\DamageTypesRegistry.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */