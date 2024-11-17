/*    */ package net.nastynate.sandworm_mod.advancements;
/*    */ 
/*    */

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.resources.ResourceLocation;
/*    */ 
/*    */ public class AdvancementTriggerRegistry {
/*  8 */   public static final AdvancementTrigger THUMPER = new AdvancementTrigger(new ResourceLocation("sandworm_mod", "thumper"));
/*  9 */   public static final AdvancementTrigger SHAI_HULUD = new AdvancementTrigger(new ResourceLocation("sandworm_mod", "shai_hulud"));
/* 10 */   public static final AdvancementTrigger FIRST_BLAST = new AdvancementTrigger(new ResourceLocation("sandworm_mod", "first_blast"));
/* 11 */   public static final AdvancementTrigger SANDWORM_FLEE = new AdvancementTrigger(new ResourceLocation("sandworm_mod", "sandworm_flee"));
/* 12 */   public static final AdvancementTrigger DUNE_ELIXIR = new AdvancementTrigger(new ResourceLocation("sandworm_mod", "dune_elixir"));
/*    */   
/*    */   public static void init() {
/* 15 */     CriteriaTriggers.m_10595_((CriterionTrigger)THUMPER);
/* 16 */     CriteriaTriggers.m_10595_((CriterionTrigger)SHAI_HULUD);
/* 17 */     CriteriaTriggers.m_10595_((CriterionTrigger)FIRST_BLAST);
/* 18 */     CriteriaTriggers.m_10595_((CriterionTrigger)SANDWORM_FLEE);
/* 19 */     CriteriaTriggers.m_10595_((CriterionTrigger)DUNE_ELIXIR);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\advancements\AdvancementTriggerRegistry.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */