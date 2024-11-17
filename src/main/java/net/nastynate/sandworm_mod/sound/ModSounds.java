/*    */ package net.nastynate.sandworm_mod.sound;
/*    */ 
/*    */

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ public class ModSounds
/*    */ {
/* 13 */   public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "sandworm_mod");
/*    */   
/* 15 */   public static final RegistryObject<SoundEvent> WORM_WARNING_1 = registerSoundEvents("worm_warning_1");
/* 16 */   public static final RegistryObject<SoundEvent> WORM_WARNING_2 = registerSoundEvents("worm_warning_2");
/* 17 */   public static final RegistryObject<SoundEvent> WORM_SPAWN = registerSoundEvents("worm_spawn");
/* 18 */   public static final RegistryObject<SoundEvent> WORM_BREACH = registerSoundEvents("worm_breach");
/* 19 */   public static final RegistryObject<SoundEvent> WORM_LAND = registerSoundEvents("worm_land");
/* 20 */   public static final RegistryObject<SoundEvent> WORM_BURROW = registerSoundEvents("worm_burrow");
/* 21 */   public static final RegistryObject<SoundEvent> WORM_ROAR = registerSoundEvents("worm_roar");
/* 22 */   public static final RegistryObject<SoundEvent> THUMPER = registerSoundEvents("thumper");
/*    */   
/*    */   private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
/* 25 */     return SOUND_EVENTS.register(name, () -> SoundEvent.m_262824_(new ResourceLocation("sandworm_mod", name)));
/*    */   }
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 29 */     SOUND_EVENTS.register(eventBus);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\sound\ModSounds.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */