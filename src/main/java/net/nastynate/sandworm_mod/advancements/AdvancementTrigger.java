/*    */ package net.nastynate.sandworm_mod.advancements;
/*    */ 
/*    */

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
/*    */ 
/*    */ public class AdvancementTrigger
/*    */   extends SimpleCriterionTrigger<AdvancementTrigger.Instance> {
/*    */   public final ResourceLocation resourceLocation;
/*    */   
/*    */   public AdvancementTrigger(ResourceLocation resourceLocation) {
/* 16 */     this.resourceLocation = resourceLocation;
/*    */   }
/*    */   
/*    */   public void trigger(ServerPlayer p_192180_1_) {
/* 20 */     m_66234_(p_192180_1_, p_226308_1_ -> true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Instance createInstance(JsonObject pJson, ContextAwarePredicate p_286603_, DeserializationContext pDeserializationContext) {
/* 27 */     return new Instance(p_286603_, this.resourceLocation);
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation m_7295_() {
/* 32 */     return this.resourceLocation;
/*    */   }
/*    */   
/*    */   public static class Instance
/*    */     extends AbstractCriterionTriggerInstance
/*    */   {
/*    */     public Instance(ContextAwarePredicate p_i231507_1_, ResourceLocation res) {
/* 39 */       super(res, p_i231507_1_);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\advancements\AdvancementTrigger.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */