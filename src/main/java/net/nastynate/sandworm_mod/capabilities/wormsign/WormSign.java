/*    */ package net.nastynate.sandworm_mod.capabilities.wormsign;
/*    */ 
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ 
/*    */ public class WormSign {
/*    */   private int wormSign;
/*    */   private int lastJumpTime;
/*    */   private int thisJumpTime;
/*  9 */   private double multiplier = 1.0D;
/* 10 */   private int playSignTimer = 0;
/* 11 */   private int stage = 0;
/* 12 */   private int stageTimer = 0;
/* 13 */   private int respawnTimer = 0;
/*    */ 
/*    */   
/*    */   public int getWS() {
/* 17 */     return this.wormSign;
/*    */   }
/*    */   public void addWS(int add) {
/* 20 */     this.wormSign += add;
/*    */   }
/*    */   
/* 23 */   public void subWS(int sub) { if (this.wormSign - sub > 0) { this.wormSign -= sub; }
/* 24 */     else { this.wormSign = 0; }
/*    */      } public void setWS(int ws) {
/* 26 */     this.wormSign = ws;
/*    */   }
/*    */   
/*    */   public void addMultiplier(double mult) {
/* 30 */     this.multiplier += mult;
/* 31 */     if (this.multiplier > 3.0D) this.multiplier = 3.0D; 
/* 32 */     if (this.multiplier < 0.0D) this.multiplier = 0.0D; 
/* 33 */     if (this.multiplier == Double.NaN) this.multiplier = 0.0D; 
/*    */   }
/*    */   
/*    */   public void setMultiplier(double mult) {
/* 37 */     this.multiplier = mult;
/*    */   }
/*    */   public double getMultiplier() {
/* 40 */     return this.multiplier;
/*    */   }
/*    */   
/* 43 */   public int getLastJumpTime() { return this.lastJumpTime; } public void setLastJumpTime(int val) {
/* 44 */     this.lastJumpTime = val;
/*    */   }
/*    */   
/*    */   public int getThisJumpTime() {
/* 48 */     return this.thisJumpTime;
/*    */   }
/*    */   public void addThisJumpTime(int add) {
/* 51 */     this.thisJumpTime += add;
/*    */   }
/* 53 */   public void setThisJumpTime(int val) { this.thisJumpTime = val; }
/* 54 */   public void decrementSignTimer() { if (this.playSignTimer > 0) this.playSignTimer--;  }
/* 55 */   public void setSignTimer() { this.playSignTimer = 1100; }
/* 56 */   public int getSignTimer() { return this.playSignTimer; }
/* 57 */   public int getStage() { return this.stage; }
/* 58 */   public void setStage(int stage) { this.stage = stage; }
/* 59 */   public void setStageTimer(int timer) { this.stageTimer = timer; }
/* 60 */   public void decrementStageTimer() { if (this.stageTimer > 0) this.stageTimer--;  }
/* 61 */   public boolean canRespawn() { return (this.respawnTimer <= 0); }
/* 62 */   public void setRespawnTimer(int respawnTimer) { this.respawnTimer = respawnTimer; } public void decrementRespawnTimer() {
/* 63 */     this.respawnTimer--;
/*    */   } public boolean dropStage() {
/* 65 */     return (this.stageTimer <= 0);
/*    */   }
/*    */   public void saveNBTData(CompoundTag nbt) {
/* 68 */     nbt.m_128405_("worm_sign", this.wormSign);
/*    */   }
/*    */   
/*    */   public void loadNBTData(CompoundTag nbt) {
/* 72 */     this.wormSign = nbt.m_128451_("thirst");
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\capabilities\wormsign\WormSign.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */