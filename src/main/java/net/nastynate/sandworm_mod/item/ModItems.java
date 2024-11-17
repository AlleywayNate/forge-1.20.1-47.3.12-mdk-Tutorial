/*    */ package net.nastynate.sandworm_mod.item;
/*    */ 
/*    */

import net.nastynate.sandworm_mod.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ public class ModItems
/*    */ {
/* 14 */   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "sandworm_mod");
/*    */ 
/*    */   
/* 17 */   public static final RegistryObject<Item> WORM_TOOTH = ITEMS.register("sandworm_tooth", () -> new WormToothItem((new Item.Properties()).m_41497_(Rarity.UNCOMMON)));
/* 18 */   public static final RegistryObject<Item> THUMPER_ITEM = ITEMS.register("thumper", () -> new ThumperItem((Block)ModBlocks.THUMPER.get(), new Item.Properties()));
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 21 */     ITEMS.register(eventBus);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\item\ModItems.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */