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

import javax.swing.text.html.BlockView;
import java.awt.*;

public class MailboxBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public static final MapCodec<MailboxBlock> CODEC = createCodec(MailboxBlock::new);

    @Override
    public MapCodec<MailboxBlock> getCodec() {
        return CODEC;
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
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }
}
