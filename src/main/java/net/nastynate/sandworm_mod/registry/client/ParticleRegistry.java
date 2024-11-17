/*    */ package net.nastynate.sandworm_mod.registry.client;
/*    */

/*    */

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import team.lodestar.lodestone.systems.particle.world.type.LodestoneWorldParticleType;
/*    */ 
/*    */ public class ParticleRegistry {
/* 14 */   public static DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "sandworm_mod");
/* 15 */   public static RegistryObject<LodestoneWorldParticleType> CRINGE_PARTICLE = PARTICLES.register("cringe", LodestoneWorldParticleType::new);
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 18 */     PARTICLES.register(eventBus);
/*    */   }
/*    */   
/*    */   public static void registerParticleFactory(RegisterParticleProvidersEvent event) {
/* 22 */     (Minecraft.m_91087_()).f_91061_.m_107378_((ParticleType)CRINGE_PARTICLE.get(), team.lodestar.lodestone.systems.particle.world.type.LodestoneWorldParticleType.Factory::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\registry\client\ParticleRegistry.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */