package net.qiuze.neoforgebw.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;


public class SwordRackBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 0.125, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.125, 0.0625, 0.9375, 0.25, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.25, 0.3125, 0.6875, 0.375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.25, 0.3125, 0.4375, 0.375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.25, 0.1875, 0.5625, 0.375, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.25, 0.6875, 0.5625, 0.375, 0.8125), BooleanOp.OR);

        return shape;
    }

    public SwordRackBlock(){
        super(Properties.ofFullCopy(Blocks.STONE).strength(5));
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED,Boolean.valueOf(false)));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext){
        return makeShape();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> pBuilder){
        pBuilder.add(WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext){
        BlockPos blockPos = pContext.getClickedPos();
        BlockState blockState = pContext.getLevel().getBlockState(blockPos);
        if (blockState.is(this)){
            return blockState.setValue(WATERLOGGED,Boolean.valueOf(false));
        }else {
            FluidState fluidState =pContext.getLevel().getFluidState(blockPos);
            BlockState blockState1 = this.defaultBlockState()
                    .setValue(WATERLOGGED,Boolean.valueOf(fluidState.getType() == Fluids.WATER));
            return blockState1;
        }
    }

    @Override
    public FluidState getFluidState(BlockState pState){
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) :super.getFluidState(pState);
    }


    public boolean isPathfindable(BlockState pState,BlockGetter pLevel, BlockPos pPos, PathComputationType pType){
        switch (pType){
            case WATER:
                return pLevel.getFluidState(pPos).is(FluidTags.WATER);
            case LAND, AIR:
            default:
                return false;
        }
    }
}

