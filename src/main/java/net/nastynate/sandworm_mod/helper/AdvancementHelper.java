/*    */ package net.nastynate.sandworm_mod.helper;
/*    */ 
/*    */

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdvancementHelper
/*    */ {
/*    */   public static void grantAdvancement(ServerPlayer player, ResourceLocation advancementId) {
/* 15 */     Optional<Advancement> advancementOptional = player.f_8924_.m_129889_().m_136028_().stream().filter(adv -> adv.m_138327_().equals(advancementId)).findFirst();
/*    */     
/* 17 */     if (advancementOptional.isPresent()) {
/* 18 */       Advancement advancement = advancementOptional.get();
/* 19 */       PlayerAdvancements advancements = player.m_8960_();
/* 20 */       AdvancementProgress progress = advancements.m_135996_(advancement);
/*    */       
/* 22 */       if (!progress.m_8193_())
/* 23 */         for (String criterion : progress.m_8219_())
/* 24 */           advancements.m_135988_(advancement, criterion);  
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\helper\AdvancementHelper.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */