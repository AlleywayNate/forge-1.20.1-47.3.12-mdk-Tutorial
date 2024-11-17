/*    */ package net.nastynate.sandworm_mod.capabilities.wormsign;
/*    */

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public class WormSignProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
/* 15 */   public static Capability<WormSign> WS = CapabilityManager.get(new CapabilityToken<WormSign>() {  }
/* 16 */     ); private WormSign wormSign = null;
/* 17 */   private final LazyOptional<WormSign> optional = LazyOptional.of(this::createWormSignCap);
/*    */   
/*    */   private WormSign createWormSignCap() {
/* 20 */     if (this.wormSign == null) {
/* 21 */       this.wormSign = new WormSign();
/*    */     }
/*    */     
/* 24 */     return this.wormSign;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
/* 29 */     if (cap == WS) {
/* 30 */       return this.optional.cast();
/*    */     }
/*    */     
/* 33 */     return LazyOptional.empty();
/*    */   }
/*    */ 
/*    */   
/*    */   public CompoundTag serializeNBT() {
/* 38 */     CompoundTag nbt = new CompoundTag();
/* 39 */     createWormSignCap().saveNBTData(nbt);
/* 40 */     return nbt;
/*    */   }
/*    */ 
/*    */   
/*    */   public void deserializeNBT(CompoundTag nbt) {
/* 45 */     createWormSignCap().loadNBTData(nbt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\capabilities\wormsign\WormSignProvider.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */