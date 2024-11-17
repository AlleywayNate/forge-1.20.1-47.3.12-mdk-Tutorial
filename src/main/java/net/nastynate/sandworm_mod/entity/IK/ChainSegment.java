/*    */ package net.nastynate.sandworm_mod.entity.IK;
/*    */ 
/*    */

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;
/*    */ 
/*    */ public class ChainSegment extends Entity {
/* 14 */   private static final EntityDataAccessor<Vector3f> DIR_VEC = SynchedEntityData.m_135353_(ChainSegment.class, EntityDataSerializers.f_268676_);
/* 15 */   private static final EntityDataAccessor<Float> LENGTH = SynchedEntityData.m_135353_(ChainSegment.class, EntityDataSerializers.f_135029_);
/* 16 */   private static final EntityDataAccessor<Vector3f> VISUAL_SCALE = SynchedEntityData.m_135353_(ChainSegment.class, EntityDataSerializers.f_268676_);
/* 17 */   private static final EntityDataAccessor<Vector3f> UP_VEC = SynchedEntityData.m_135353_(ChainSegment.class, EntityDataSerializers.f_268676_);
/*    */   
/*    */   public ChainSegment(EntityType<?> pEntityType, Level pLevel) {
/* 20 */     super(pEntityType, pLevel);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void m_8097_() {
/* 27 */     this.f_19804_.m_135372_(LENGTH, Float.valueOf(10.0F));
/* 28 */     this.f_19804_.m_135372_(VISUAL_SCALE, (new Vec3(1.0D, 1.0D, 1.0D)).m_252839_());
/* 29 */     this.f_19804_.m_135372_(DIR_VEC, (new Vec3(0.0D, 2.0D, 0.0D)).m_252839_());
/* 30 */     this.f_19804_.m_135372_(UP_VEC, (new Vec3(0.0D, 1.0D, 0.0D)).m_252839_());
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8119_() {
/* 35 */     super.m_8119_();
/*    */   }
/*    */   
/* 38 */   public float getLength() { return ((Float)this.f_19804_.m_135370_(LENGTH)).floatValue(); }
/* 39 */   public void setLength(float length) { this.f_19804_.m_135381_(LENGTH, Float.valueOf(length)); } public Vec3 getVisualScale() {
/* 40 */     return new Vec3((Vector3f)this.f_19804_.m_135370_(VISUAL_SCALE));
/*    */   } public void setVisualScale(Vec3 scaleVec) {
/* 42 */     this.f_19804_.m_135381_(VISUAL_SCALE, scaleVec.m_252839_());
/*    */   }
/* 44 */   public Vec3 getDirectionVector() { return new Vec3((Vector3f)this.f_19804_.m_135370_(DIR_VEC)); }
/* 45 */   public void setDirectionVector(Vec3 dirVec) { this.f_19804_.m_135381_(DIR_VEC, dirVec.m_82541_().m_252839_()); }
/* 46 */   public Vec3 getUpVector() { return new Vec3((Vector3f)this.f_19804_.m_135370_(UP_VEC)); } public void setUpVector(Vec3 upVec) {
/* 47 */     this.f_19804_.m_135381_(UP_VEC, upVec.m_82541_().m_252839_());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void m_7378_(CompoundTag pCompound) {
/* 57 */     this.f_19804_.m_135381_(LENGTH, Float.valueOf(pCompound.m_128457_("segment_length")));
/* 58 */     this.f_19804_.m_135381_(DIR_VEC, new Vector3f(pCompound.m_128457_("dir_vec_x"), pCompound
/* 59 */           .m_128457_("dir_vec_y"), pCompound
/* 60 */           .m_128457_("dir_vec_z")));
/* 61 */     this.f_19804_.m_135381_(VISUAL_SCALE, new Vector3f(pCompound.m_128457_("scale_vec_x"), pCompound
/* 62 */           .m_128457_("scale_vec_y"), pCompound
/* 63 */           .m_128457_("scale_vec_z")));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void m_7380_(CompoundTag pCompound) {
/* 69 */     pCompound.m_128350_("segment_length", ((Float)this.f_19804_.m_135370_(LENGTH)).floatValue());
/* 70 */     Vector3f dir_vec = (Vector3f)this.f_19804_.m_135370_(DIR_VEC);
/* 71 */     pCompound.m_128350_("dir_vec_x", dir_vec.get(0));
/* 72 */     pCompound.m_128350_("dir_vec_y", dir_vec.get(1));
/* 73 */     pCompound.m_128350_("dir_vec_z", dir_vec.get(2));
/* 74 */     Vector3f scale_vec = (Vector3f)this.f_19804_.m_135370_(VISUAL_SCALE);
/* 75 */     pCompound.m_128350_("scale_vec_x", scale_vec.get(0));
/* 76 */     pCompound.m_128350_("scale_vec_y", scale_vec.get(1));
/* 77 */     pCompound.m_128350_("scale_vec_z", scale_vec.get(2));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_5825_() {
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\entity\IK\ChainSegment.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */