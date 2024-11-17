/*    */ package net.nastynate.sandworm_mod.datagen;
/*    */ 
/*    */

import net.jelly.sandworm_mod.registry.common.DamageTypesRegistry;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.Set;
/*    */ 
/*    */ @EventBusSubscriber(modid = "sandworm_mod", bus = EventBusSubscriber.Bus.MOD)
/*    */ public class ModDataGenHandler {
/* 18 */   private static final RegistrySetBuilder BUILDER = (new RegistrySetBuilder()).m_254916_(Registries.f_268580_, DamageTypesRegistry::bootstrap);
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void gatherDataEvent(GatherDataEvent event) {
/* 22 */     DataGenerator dataGenerator = event.getGenerator();
/* 23 */     PackOutput packOutput = dataGenerator.getPackOutput();
/* 24 */     dataGenerator.addProvider(event.includeServer(), (DataProvider)new DatapackBuiltinEntriesProvider(packOutput, event
/* 25 */           .getLookupProvider(), BUILDER, Set.of("sandworm_mod")));
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\datagen\ModDataGenHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */