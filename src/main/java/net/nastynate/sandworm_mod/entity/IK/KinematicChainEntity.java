/*     */ package net.nastynate.sandworm_mod.entity.IK;
/*     */ 
/*     */

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/*     */ 
/*     */ public class KinematicChainEntity
/*     */   extends Entity
/*     */ {
/*  16 */   public float tolerance = 0.01F;
/*  17 */   public Vec3 target = new Vec3(0.0D, 0.0D, 0.0D);
/*  18 */   protected Vec3 targetV = new Vec3(0.0D, 0.0D, 0.0D);
/*  19 */   public Vec3 goal = null;
/*  20 */   public int segmentCount = 0;
/*  21 */   public List<ChainSegment> segments = new ArrayList<>();
/*  22 */   public List<UUID> segmentsUUIDs = new ArrayList<>();
/*  23 */   public int stage = 0;
/*     */   public KinematicChainEntity(EntityType<?> pEntityType, Level pLevel) {
/*  25 */     super(pEntityType, pLevel);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  30 */     super.m_8119_();
/*  31 */     if (!m_9236_().m_5776_()) {
/*     */       
/*  33 */       if (this.segmentCount != 0 && this.segments.isEmpty()) {
/*     */         
/*  35 */         List<ChainSegment> nearbyChainSegs = m_9236_().m_45976_(ChainSegment.class, new AABB(
/*     */               
/*  37 */               m_20182_().m_82520_(100.0D, 100.0D, 100.0D), m_20182_().m_82520_(-100.0D, -100.0D, -100.0D)));
/*     */         
/*  39 */         for (int i = 0; i < this.segmentCount; i++) {
/*  40 */           UUID thisUUID = this.segmentsUUIDs.get(i);
/*  41 */           this.segments.add(nearbyChainSegs
/*  42 */               .stream()
/*  43 */               .filter(obj -> obj.m_20149_().equals(thisUUID.toString()))
/*  44 */               .findFirst()
/*  45 */               .orElse(null));
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  51 */       if (!this.segments.isEmpty()) {
/*  52 */         m_146884_(((ChainSegment)this.segments.get(0)).m_20182_());
/*  53 */         Vec3 rootToEnd = ((ChainSegment)this.segments.get(this.segmentCount - 1)).m_20182_().m_82546_(((ChainSegment)this.segments.get(0)).m_20182_()).m_82537_(new Vec3(0.0D, 0.0D, 1.0D));
/*  54 */         for (int i = 0; i < this.segmentCount; i++) {
/*  55 */           if (this.segments.get(i) != null) ((ChainSegment)this.segments.get(i)).setUpVector(rootToEnd);
/*     */         
/*     */         } 
/*     */       } 
/*  59 */       if (this.segmentCount == 0) {
/*  60 */         for (int i = 0; i < 100; ) { addSegment(1.75F, new Vec3(0.0D, 1.0D, 0.0D)); i++; }
/*     */       
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fabrik() {
/*  71 */     float totalLength = 0.0F;
/*  72 */     float distToTarget = (float)this.target.m_82546_(m_20182_()).m_82553_(); int i;
/*  73 */     for (i = 0; i < this.segmentCount; ) { totalLength += ((ChainSegment)this.segments.get(i)).getLength(); i++; }
/*  74 */      if (distToTarget > totalLength) {
/*     */       
/*  76 */       Vec3 rootToTarget = this.target.m_82546_(m_20182_()).m_82541_();
/*  77 */       for (int j = 0; j < this.segmentCount; j++) {
/*  78 */         Vec3 lastPosition; ChainSegment currentSegment = this.segments.get(j);
/*     */         
/*  80 */         Vec3 root = m_20182_();
/*  81 */         float length = currentSegment.getLength();
/*  82 */         if (j == 0) { lastPosition = root; }
/*     */         else
/*  84 */         { lastPosition = ((ChainSegment)this.segments.get(j - 1)).m_20182_(); }
/*     */ 
/*     */         
/*  87 */         currentSegment.m_146884_(lastPosition.m_82549_(rootToTarget.m_82490_(length)));
/*  88 */         currentSegment.setDirectionVector(rootToTarget);
/*     */       } 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  95 */     i = 0;
/*  96 */     while (Math.abs(this.target.m_82546_(((ChainSegment)this.segments.get(this.segmentCount - 1)).m_20182_()).m_82553_()) > this.tolerance && i <= 10) {
/*  97 */       fabrikForward();
/*     */       
/*  99 */       i++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void fabrikForward() {
/* 105 */     for (int i = this.segmentCount - 1; i >= 0; i--) {
/* 106 */       Vec3 lastPosition; ChainSegment currentSegment = this.segments.get(i);
/*     */       
/* 108 */       Vec3 root = m_20182_();
/* 109 */       if (i == 0) {
/* 110 */         lastPosition = root;
/*     */       } else {
/*     */         
/* 113 */         ChainSegment lastSegment = this.segments.get(i - 1);
/* 114 */         lastPosition = lastSegment.m_20182_();
/*     */       } 
/*     */ 
/*     */       
/* 118 */       if (i == this.segmentCount - 1) { currentSegment.m_146884_(this.target); }
/*     */       else
/*     */       
/* 121 */       { ChainSegment nextSegment = this.segments.get(i + 1);
/* 122 */         Vec3 nextTail = nextSegment.m_20182_().m_82546_(nextSegment.getDirectionVector().m_82490_(nextSegment.getLength()));
/* 123 */         currentSegment.m_146884_(nextTail); }
/*     */       
/* 125 */       currentSegment.setDirectionVector(currentSegment.m_20182_().m_82546_(lastPosition));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void fabrikBackward() {
/* 130 */     for (int i = 0; i < this.segmentCount; i++) {
/* 131 */       Vec3 lastPosition; ChainSegment currentSegment = this.segments.get(i);
/*     */       
/* 133 */       Vec3 root = m_20182_();
/* 134 */       if (i == 0) {
/* 135 */         lastPosition = root;
/*     */       } else {
/*     */         
/* 138 */         ChainSegment lastSegment = this.segments.get(i - 1);
/* 139 */         lastPosition = lastSegment.m_20182_();
/*     */       } 
/*     */       
/* 142 */       currentSegment.setDirectionVector(currentSegment.m_20182_().m_82546_(lastPosition));
/* 143 */       currentSegment.m_146884_(lastPosition.m_82549_(currentSegment.getDirectionVector().m_82490_(currentSegment.getLength())));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addSegment(float length, Vec3 dirVec) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyAcceleration(Vec3 accel) {
/* 175 */     this.targetV = this.targetV.m_82549_(accel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_8097_() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_7378_(CompoundTag pCompound) {
/* 187 */     this.segmentCount = pCompound.m_128451_("segment_count");
/* 188 */     this.segmentsUUIDs = new ArrayList<>();
/*     */     
/* 190 */     for (int i = 0; i < this.segmentCount; i++) {
/* 191 */       UUID thisUUID = pCompound.m_128342_("segment_" + i);
/* 192 */       this.segmentsUUIDs.add(thisUUID);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7380_(CompoundTag pCompound) {
/* 198 */     pCompound.m_128405_("segment_count", this.segmentCount);
/* 199 */     if (this.segmentCount != 0 && this.segmentsUUIDs.isEmpty()) {
/* 200 */       m_7378_(pCompound);
/*     */     }
/* 202 */     for (int i = 0; i < this.segmentCount; i++)
/* 203 */       pCompound.m_128362_("segment_" + i, this.segmentsUUIDs.get(i)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\IK\KinematicChainEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */