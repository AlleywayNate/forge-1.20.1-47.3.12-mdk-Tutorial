/*    */ package net.nastynate.sandworm_mod.block;
/*    */ 
/*    */

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ public class ModBlockEntities
/*    */ {
/* 12 */   public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "sandworm_mod");
/*    */   
/* 14 */   public static final RegistryObject<BlockEntityType<ThumperBlockEntity>> THUMPER_ENTITY = BLOCK_ENTITIES
/* 15 */     .register("animated_block_entity", () -> BlockEntityType.Builder.m_155273_(ThumperBlockEntity::new, new Block[] { (Block)ModBlocks.THUMPER.get() }).m_58966_(null));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 21 */     BLOCK_ENTITIES.register(eventBus);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\block\ModBlockEntities.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */