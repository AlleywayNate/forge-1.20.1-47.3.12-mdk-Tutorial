/*    */ package net.nastynate.sandworm_mod.worldevents;
/*    */ 
/*    */

import com.mojang.blaze3d.vertex.PoseStack;
import net.jelly.sandworm_mod.registry.client.ParticleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.SimpleParticleOptions;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;
import team.lodestar.lodestone.systems.particle.render_types.LodestoneWorldParticleRenderType;
import team.lodestar.lodestone.systems.particle.world.LodestoneWorldParticle;
import team.lodestar.lodestone.systems.worldevent.WorldEventRenderer;

import java.awt.*;
import java.util.function.Consumer;
/*    */ 
/*    */ public class WormBreachRenderer
/*    */   extends WorldEventRenderer<WormBreachWorldEvent> {
/*    */   public void render(WormBreachWorldEvent instance, PoseStack poseStack, MultiBufferSource bufferSource, float partialTicks) {
/* 26 */     if (!instance.spawnedParticles) {
/* 27 */       Consumer<LodestoneWorldParticle> rise = p -> p.m_172260_((p.getParticleSpeed()).f_82479_, Math.pow(20.0D, ((instance.lifetime + 2) / -15)), (p.getParticleSpeed()).f_82481_);
/*    */       int i;
/* 29 */       for (i = 0; i < 36; i++)
/* 30 */         WorldParticleBuilder.create(ParticleRegistry.CRINGE_PARTICLE)
/* 31 */           .enableNoClip()
/* 32 */           .addRenderActor(rise)
/* 33 */           .enableForcedSpawn()
/* 34 */           .setRenderType((ParticleRenderType)LodestoneWorldParticleRenderType.TRANSPARENT.withDepthFade())
/* 35 */           .setSpritePicker(SimpleParticleOptions.ParticleSpritePicker.RANDOM_SPRITE)
/* 36 */           .setColorData(ColorParticleData.create(new Color(171, 128, 97), new Color(171, 128, 97)).build())
/* 37 */           .setTransparencyData(GenericParticleData.create(0.15F, 0.15F, 0.0F).setEasing(Easing.EXPO_IN_OUT).build())
/* 38 */           .setLifetime(480)
/* 39 */           .setSpinData(SpinParticleData.createRandomDirection(RandomSource.m_216327_(), 0.005F).build())
/* 40 */           .setRandomMotion(0.07500000298023224D, 0.029999999329447746D, 0.07500000298023224D)
/* 41 */           .setRandomOffset(12.0D, 2.0D, 12.0D)
/* 42 */           .setScaleData(GenericParticleData.create(10.0F, 10.0F).build())
/* 43 */           .setDiscardFunction(SimpleParticleOptions.ParticleDiscardFunctionType.ENDING_CURVE_INVISIBLE)
/* 44 */           .spawn((Level)(Minecraft.m_91087_()).f_91073_, instance.position.f_82479_, instance.position.f_82480_, instance.position.f_82481_); 
/* 45 */       for (i = 0; i < 27; i++)
/* 46 */         WorldParticleBuilder.create(ParticleRegistry.CRINGE_PARTICLE)
/* 47 */           .enableNoClip()
/* 48 */           .addRenderActor(rise)
/* 49 */           .enableForcedSpawn()
/* 50 */           .setRenderType((ParticleRenderType)LodestoneWorldParticleRenderType.TRANSPARENT.withDepthFade())
/* 51 */           .setSpritePicker(SimpleParticleOptions.ParticleSpritePicker.RANDOM_SPRITE)
/* 52 */           .setColorData(ColorParticleData.create(new Color(157, 136, 108), new Color(157, 136, 108)).build())
/* 53 */           .setTransparencyData(GenericParticleData.create(0.15F, 0.15F, 0.0F).setEasing(Easing.EXPO_IN_OUT).build())
/* 54 */           .setLifetime(450)
/* 55 */           .setSpinData(SpinParticleData.createRandomDirection(RandomSource.m_216327_(), 0.005F).build())
/* 56 */           .setRandomMotion(0.08500000089406967D, 0.029999999329447746D, 0.08500000089406967D)
/* 57 */           .setRandomOffset(20.0D, 2.0D, 20.0D)
/* 58 */           .setScaleData(GenericParticleData.create(8.0F, 8.0F).build())
/* 59 */           .setDiscardFunction(SimpleParticleOptions.ParticleDiscardFunctionType.ENDING_CURVE_INVISIBLE)
/* 60 */           .spawn((Level)(Minecraft.m_91087_()).f_91073_, instance.position.f_82479_, instance.position.f_82480_, instance.position.f_82481_); 
/* 61 */       for (i = 0; i < 36; i++)
/* 62 */         WorldParticleBuilder.create(ParticleRegistry.CRINGE_PARTICLE)
/* 63 */           .enableNoClip()
/* 64 */           .addRenderActor(rise)
/* 65 */           .enableForcedSpawn()
/* 66 */           .setRenderType((ParticleRenderType)LodestoneWorldParticleRenderType.TRANSPARENT.withDepthFade())
/* 67 */           .setSpritePicker(SimpleParticleOptions.ParticleSpritePicker.RANDOM_SPRITE)
/* 68 */           .setColorData(ColorParticleData.create(new Color(215, 194, 173), new Color(188, 155, 130)).build())
/* 69 */           .setTransparencyData(GenericParticleData.create(0.04F, 0.15F, 0.0F).setEasing(Easing.EXPO_IN_OUT).build())
/* 70 */           .setLifetime(450)
/* 71 */           .setSpinData(SpinParticleData.createRandomDirection(RandomSource.m_216327_(), 0.005F).build())
/* 72 */           .setRandomMotion(0.08500000089406967D, 0.03999999910593033D, 0.08500000089406967D)
/* 73 */           .setRandomOffset(12.0D, 2.0D, 12.0D)
/* 74 */           .setScaleData(GenericParticleData.create(3.0F, 10.0F).build())
/* 75 */           .setDiscardFunction(SimpleParticleOptions.ParticleDiscardFunctionType.ENDING_CURVE_INVISIBLE)
/* 76 */           .spawn((Level)(Minecraft.m_91087_()).f_91073_, instance.position.f_82479_, instance.position.f_82480_, instance.position.f_82481_); 
/* 77 */       instance.spawnedParticles = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRender(WormBreachWorldEvent instance) {
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\worldevents\WormBreachRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */