/*    */ package net.nastynate.sandworm_mod.entity;
/*    */ 
/*    */

import net.jelly.sandworm_mod.entity.IK.worm.WormChainEntity;
import net.jelly.sandworm_mod.entity.IK.worm.WormHeadSegment;
import net.jelly.sandworm_mod.entity.IK.worm.WormSegment;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModEntities
/*    */ {
/* 18 */   public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "sandworm_mod");
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
/* 30 */   public static final RegistryObject<EntityType<WormSegment>> WORM_SEGMENT = ENTITY_TYPES.register("worm_segment", () -> EntityType.Builder.m_20704_(WormSegment::new, MobCategory.MISC).m_20699_(7.5F, 7.5F).m_20702_(400).m_20712_("worm_segment"));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 36 */   public static final RegistryObject<EntityType<WormHeadSegment>> WORM_HEAD_SEGMENT = ENTITY_TYPES.register("worm_head_segment", () -> EntityType.Builder.m_20704_(WormHeadSegment::new, MobCategory.MISC).m_20699_(7.5F, 7.5F).m_20702_(400).m_20712_("worm_head_segment"));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 42 */   public static final RegistryObject<EntityType<WormChainEntity>> WORM_CHAIN = ENTITY_TYPES.register("worm_chain", () -> EntityType.Builder.m_20704_(WormChainEntity::new, MobCategory.MISC).m_20699_(0.5F, 0.5F).m_20712_("worm_chain"));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 49 */     ENTITY_TYPES.register(eventBus);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\ModEntities.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */