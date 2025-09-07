package net.nasty289.mailmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import java.awt.*;

public class MailboxBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public static final MapCodec<MailboxBlock> CODEC = createCodec(MailboxBlock::new);

    @Override
    public MapCodec<MailboxBlock> getCodec() {
        return CODEC;
    }

    private static final VoxelShape SHAPE_NORTH;
    static {
        VoxelShape nbody = Block.createCuboidShape(0, 2, 0, 16, 13, 16);
        VoxelShape ntop1 = Block.createCuboidShape(0,13,0,2,19,16);
        VoxelShape ntop2 = Block.createCuboidShape(14,13,0,16,19,16);
        VoxelShape ntop3 = Block.createCuboidShape(0,13,8,15,19,16);
        VoxelShape ntop4 = Block.createCuboidShape(0,19,1,2,21,6);
        VoxelShape ntop5 = Block.createCuboidShape(14,19,1,16,21,6);
        VoxelShape ntop6 = Block.createCuboidShape(0,19,6,16,21,15);
        VoxelShape ntop7 = Block.createCuboidShape(2,20,1,15,21,7);
        VoxelShape ntop8 = Block.createCuboidShape(0,21,2,16,22,14);
        VoxelShape ntop9 = Block.createCuboidShape(0,22,4,16,23,12);
        VoxelShape nfoot1 = Block.createCuboidShape(0, 0, 0, 2, 2, 2);
        VoxelShape nfoot2 = Block.createCuboidShape(0, 0, 14, 2, 2, 16);
        VoxelShape nfoot3 = Block.createCuboidShape(14, 0, 0, 16, 2, 2);
        VoxelShape nfoot4 = Block.createCuboidShape(14, 0, 14, 16, 2, 16);

        SHAPE_NORTH = VoxelShapes.union(nbody,nfoot1,nfoot2,nfoot3,nfoot4,ntop1,ntop2,ntop3,ntop4,ntop5,ntop6,ntop7,ntop8,ntop9);
    }

    private static final VoxelShape SHAPE_EAST;
    static {
        VoxelShape ebody = Block.createCuboidShape(0, 2, 0, 16, 13, 16);
        VoxelShape etop1 = Block.createCuboidShape(0, 13, 0, 16, 19, 2);
        VoxelShape etop2 = Block.createCuboidShape(0, 13, 14, 16, 19, 16);
        VoxelShape etop3 = Block.createCuboidShape(0, 13, 0, 8, 19, 15);
        VoxelShape etop4 = Block.createCuboidShape(10, 19, 0, 15, 21, 2);
        VoxelShape etop5 = Block.createCuboidShape(10, 19, 14, 15, 21, 16);
        VoxelShape etop6 = Block.createCuboidShape(1, 19, 0, 10, 21, 16);
        VoxelShape etop7 = Block.createCuboidShape(9, 20, 0, 15, 21, 14);
        VoxelShape etop8 = Block.createCuboidShape(2, 21, 0, 14, 22, 16);
        VoxelShape etop9 = Block.createCuboidShape(4, 22, 0, 12, 23, 16);
        VoxelShape efoot1 = Block.createCuboidShape(0, 0, 0, 2, 2, 2);
        VoxelShape efoot2 = Block.createCuboidShape(14, 0, 0, 16, 2, 2);
        VoxelShape efoot3 = Block.createCuboidShape(0, 0, 14, 2, 2, 16);
        VoxelShape efoot4 = Block.createCuboidShape(14, 0, 14, 16, 2, 16);

        SHAPE_EAST = VoxelShapes.union(ebody, efoot1, efoot2, efoot3, efoot4, etop1, etop2, etop3, etop4, etop5, etop6, etop7, etop8, etop9);
    }

    private static final VoxelShape SHAPE_SOUTH;
    static {
        VoxelShape sbody = Block.createCuboidShape(0, 2, 0, 16, 13, 16);
        VoxelShape stop1 = Block.createCuboidShape(14, 13, 0, 16, 19, 16);
        VoxelShape stop2 = Block.createCuboidShape(0, 13, 0, 2, 19, 16);
        VoxelShape stop3 = Block.createCuboidShape(1, 13, 0, 16, 19, 8);
        VoxelShape stop4 = Block.createCuboidShape(14, 19, 8, 16, 21, 15);
        VoxelShape stop5 = Block.createCuboidShape(0, 19, 8, 2, 21, 15);
        VoxelShape stop6 = Block.createCuboidShape(0, 19, 1, 16, 21, 8);
        VoxelShape stop7 = Block.createCuboidShape(1, 20, 9, 14, 21, 15);
        VoxelShape stop8 = Block.createCuboidShape(0, 21, 2, 16, 22, 14);
        VoxelShape stop9 = Block.createCuboidShape(0, 22, 4, 16, 23, 12);
        VoxelShape sfoot1 = Block.createCuboidShape(14, 0, 14, 16, 2, 16);
        VoxelShape sfoot2 = Block.createCuboidShape(14, 0, 0, 16, 2, 2);
        VoxelShape sfoot3 = Block.createCuboidShape(0, 0, 14, 2, 2, 16);
        VoxelShape sfoot4 = Block.createCuboidShape(0, 0, 0, 2, 2, 2);

        SHAPE_SOUTH = VoxelShapes.union(sbody, sfoot1, sfoot2, sfoot3, sfoot4, stop1, stop2, stop3, stop4, stop5, stop6, stop7, stop8, stop9);
    }

    private static final VoxelShape SHAPE_WEST;
    static {
        VoxelShape wbody = Block.createCuboidShape(0,2,0,16,13,16);
        VoxelShape wtop1 = Block.createCuboidShape(0,13,0,16,19,2);
        VoxelShape wtop2 = Block.createCuboidShape(0,13,14,16,19,16);
        VoxelShape wtop3 = Block.createCuboidShape(8,13,2,16,19,14);
        VoxelShape wtop4 = Block.createCuboidShape(1,19,14,6,21,16);
        VoxelShape wtop5 = Block.createCuboidShape(1,19,0,6,21,2);
        VoxelShape wtop6 = Block.createCuboidShape(6,19,0,15,21,16);
        VoxelShape wtop7 = Block.createCuboidShape(1,20,2,6,21,14);
        VoxelShape wtop8 = Block.createCuboidShape(2,21,0,14,22,16);
        VoxelShape wtop9 = Block.createCuboidShape(4,22,0,12,23,16);
        VoxelShape wfoot1 = Block.createCuboidShape(0,0,14,2,2,16);
        VoxelShape wfoot2 = Block.createCuboidShape(14,0,14,16,2,16);
        VoxelShape wfoot3 = Block.createCuboidShape(14,0,0,16,2,2);
        VoxelShape wfoot4 = Block.createCuboidShape(0,0,0,2,2,2);

        SHAPE_WEST = VoxelShapes.union(wbody, wfoot1, wfoot2, wfoot3, wfoot4, wtop1, wtop2, wtop3, wtop4, wtop5, wtop6, wtop7, wtop8, wtop9);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case EAST -> SHAPE_EAST;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    public MailboxBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
