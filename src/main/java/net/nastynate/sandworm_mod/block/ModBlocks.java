/*    */ package net.nastynate.sandworm_mod.block;
/*    */ 
/*    */

import net.jelly.sandworm_mod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModBlocks
/*    */ {
/* 20 */   public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "sandworm_mod");
/*    */   
/* 22 */   public static final RegistryObject<Block> THUMPER = registerBlock("thumper", () -> new ThumperBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)Blocks.f_50039_).m_60955_().m_60978_(0.5F).m_278166_(PushReaction.DESTROY)));
/*    */ 
/*    */   
/*    */   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
/* 26 */     RegistryObject<T> toReturn = BLOCKS.register(name, block);
/*    */     
/* 28 */     return toReturn;
/*    */   }
/*    */   
/*    */   private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
/* 32 */     return ModItems.ITEMS.register(name, () -> new BlockItem((Block)block.get(), new Item.Properties()));
/*    */   }
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 36 */     BLOCKS.register(eventBus);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\block\ModBlocks.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */