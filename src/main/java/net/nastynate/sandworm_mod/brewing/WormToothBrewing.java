/*    */ package net.nastynate.sandworm_mod.brewing;
/*    */

import net.jelly.sandworm_mod.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;

import java.util.ArrayList;
import java.util.Collection;
/*    */ 
/*    */ public class WormToothBrewing implements IBrewingRecipe {
/*    */   public boolean isInput(ItemStack input) {
/* 20 */     return (PotionUtils.m_43547_(input) != null && (!PotionUtils.m_43547_(input).isEmpty() || input.m_41783_().m_128471_("duneElixir")));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isIngredient(ItemStack ingredient) {
/* 25 */     return ingredient.m_150930_((Item)ModItems.WORM_TOOTH.get());
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
/* 30 */     Potion potion = PotionUtils.m_43579_(input);
/* 31 */     Collection<MobEffectInstance> newEffects = new ArrayList<>();
/* 32 */     potion.m_43488_().forEach(effect -> newEffects.add(new MobEffectInstance(effect.m_19544_(), effect.m_19557_(), effect.m_19564_() + 1, effect.m_19571_(), effect.m_19572_(), effect.m_19575_(), null, effect.m_216895_())));
/*    */ 
/*    */ 
/*    */     
/* 36 */     ItemStack result = input.m_41777_();
/* 37 */     if (newEffects == null || newEffects.isEmpty()) return input; 
/* 38 */     setEffects(result, newEffects);
/* 39 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public static ItemStack setEffects(ItemStack pStack, Collection<MobEffectInstance> pEffects) {
/* 44 */     if (pEffects.isEmpty()) {
/* 45 */       return pStack;
/*    */     }
/* 47 */     CompoundTag compoundtag = pStack.m_41784_();
/* 48 */     int color = PotionUtils.m_43575_(pStack);
/* 49 */     MutableComponent mutableComponent = pStack.m_41786_().m_6879_();
/* 50 */     compoundtag.m_128379_("duneElixir", true);
/* 51 */     compoundtag.m_128473_("Potion");
/* 52 */     compoundtag.m_128473_("display");
/* 53 */     compoundtag.m_128473_("CustomPotionEffects");
/* 54 */     ListTag listtag = compoundtag.m_128437_("CustomPotionEffects", 9);
/*    */     
/* 56 */     for (MobEffectInstance mobeffectinstance : pEffects) {
/* 57 */       listtag.add(mobeffectinstance.m_19555_(new CompoundTag()));
/*    */     }
/*    */     
/* 60 */     compoundtag.m_128365_("CustomPotionEffects", (Tag)listtag);
/* 61 */     compoundtag.m_128405_("CustomPotionColor", color);
/* 62 */     pStack.m_41714_((Component)mutableComponent.m_6879_().m_130948_(mutableComponent.m_7383_().m_131155_(Boolean.valueOf(false)).m_131140_(Rarity.UNCOMMON.f_43022_)));
/*    */     
/* 64 */     return pStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\brewing\WormToothBrewing.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */