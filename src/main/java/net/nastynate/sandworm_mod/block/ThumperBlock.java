/*    */ package net.nastynate.sandworm_mod.block;
/*    */ 
/*    */

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThumperBlock
/*    */   extends BaseEntityBlock
/*    */ {
/* 35 */   public static final VoxelShape SHAPE = Block.m_49796_(5.0D, 0.0D, 5.0D, 11.0D, 17.0D, 11.0D);
/* 36 */   public static final BooleanProperty THUMPING = BooleanProperty.m_61465_("thumping");
/*    */   
/*    */   public ThumperBlock(Properties pProperties) {
/* 39 */     super(pProperties);
/* 40 */     m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_())
/* 41 */         .m_61124_((Property)THUMPING, Boolean.valueOf(false)));
/*    */   }
/*    */ 
/*    */   
/*    */   public VoxelShape m_5940_(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
/* 46 */     return SHAPE;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void m_7926_(StateDefinition.Builder<Block, BlockState> pBuilder) {
/* 51 */     pBuilder.m_61104_(new Property[] { (Property)THUMPING });
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public BlockEntity m_142194_(BlockPos pPos, BlockState pState) {
/* 57 */     return ((BlockEntityType)ModBlockEntities.THUMPER_ENTITY.get()).m_155264_(pPos, pState);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public InteractionResult m_6227_(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
/* 63 */     if (!pLevel.m_5776_() && pHand == InteractionHand.MAIN_HAND) {
/* 64 */       boolean currentState = ((Boolean)pState.m_61143_((Property)THUMPING)).booleanValue();
/* 65 */       pLevel.m_7731_(pPos, (BlockState)pState.m_61124_((Property)THUMPING, Boolean.valueOf(!currentState)), 8);
/*    */     } 
/*    */     
/* 68 */     return InteractionResult.SUCCESS;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
/* 73 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_7898_(BlockState pState, LevelReader pLevel, BlockPos pPos) {
/* 78 */     return pLevel.m_8055_(pPos.m_7495_()).m_280296_();
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
/* 84 */     return m_152132_(pBlockEntityType, (BlockEntityType)ModBlockEntities.THUMPER_ENTITY.get(), ThumperBlockEntity::tick);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\block\ThumperBlock.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */