/*    */ package net.nastynate.sandworm_mod.worldevents;
/*    */ 
/*    */

import net.jelly.sandworm_mod.registry.common.WorldEventRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import team.lodestar.lodestone.systems.worldevent.WorldEventInstance;
/*    */ 
/*    */ public class WormBreachWorldEvent extends WorldEventInstance {
/*    */   public Vec3 position;
/*    */   public boolean spawnedParticles;
/* 12 */   public int lifetime = 0;
/*    */   
/*    */   public WormBreachWorldEvent() {
/* 15 */     super(WorldEventRegistry.WORM_BREACH);
/*    */   }
/*    */   
/*    */   public WormBreachWorldEvent setPosition(Vec3 pos) {
/* 19 */     this.position = pos;
/* 20 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick(Level level) {
/* 25 */     if (this.level == null) {
/* 26 */       this.discarded = true;
/*    */       return;
/*    */     } 
/* 29 */     this.lifetime++;
/* 30 */     if (this.lifetime >= 480) {
/* 31 */       this.discarded = true;
/* 32 */       end(level);
/*    */     } 
/* 34 */     super.tick(level);
/*    */   }
/*    */ 
/*    */   
/*    */   public CompoundTag serializeNBT(CompoundTag tag) {
/* 39 */     tag.m_128347_("x", this.position.f_82479_);
/* 40 */     tag.m_128347_("y", this.position.f_82480_);
/* 41 */     tag.m_128347_("z", this.position.f_82481_);
/* 42 */     tag.m_128379_("spawnedparticles", this.spawnedParticles);
/* 43 */     tag.m_128347_("age", this.lifetime);
/* 44 */     return super.serializeNBT(tag);
/*    */   }
/*    */ 
/*    */   
/*    */   public WorldEventInstance deserializeNBT(CompoundTag tag) {
/* 49 */     this.position = new Vec3(tag.m_128459_("x"), tag.m_128459_("y"), tag.m_128459_("z"));
/* 50 */     this.spawnedParticles = tag.m_128471_("spawnedparticles");
/* 51 */     this.lifetime = tag.m_128451_("age");
/* 52 */     return super.deserializeNBT(tag);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isClientSynced() {
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\worldevents\WormBreachWorldEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */