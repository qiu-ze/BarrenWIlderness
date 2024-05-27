package net.qiuze.neoforgebw.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class BloodBlock extends Block {
    public static final BooleanProperty FIRE = BooleanProperty.create("fire");

    public BloodBlock(Properties p_2200_) {
        super(p_2200_);
        this.registerDefaultState(this.defaultBlockState().setValue(FIRE, false));

    }

    public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

    if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
        pLevel.setBlock(pPos, pState.cycle(FIRE), 3);
    }

    return super.useWithoutItem(pState,pLevel,pPos,pPlayer,pHit);

    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FIRE);
    }
}
