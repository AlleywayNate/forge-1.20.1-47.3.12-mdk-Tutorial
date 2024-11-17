/*    */ package net.nastynate.sandworm_mod.helper;
/*    */ 
/*    */

import net.jelly.sandworm_mod.config.CommonConfigs;
import net.jelly.sandworm_mod.registry.common.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.biome.Biome;
/*    */ 
/*    */ public class BiomeHelper
/*    */ {
/*    */   public static boolean isDesertBiome(ServerLevel level, BlockPos blockPos) {
/* 15 */     Holder<Biome> thisBiome = level.m_7062_().m_204214_(blockPos);
/* 16 */     return ((((Boolean)CommonConfigs.DEFAULT_SPAWNING.get()).booleanValue() && thisBiome.m_203656_(BiomeTags.f_263796_)) || thisBiome.m_203656_(TagRegistry.SANDWORM_SPAWNABLE));
/*    */   }
/*    */   
/*    */   public static boolean isDesertBiome(Entity entity) {
/* 20 */     return isDesertBiome(entity.m_20194_().m_129880_(entity.m_9236_().m_46472_()), entity.m_20183_());
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\helper\BiomeHelper.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */