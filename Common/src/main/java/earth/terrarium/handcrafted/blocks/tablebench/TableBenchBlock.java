package earth.terrarium.handcrafted.blocks.tablebench;

import earth.terrarium.handcrafted.blocks.SimpleBlock;
import earth.terrarium.handcrafted.blocks.property.TableBenchShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class TableBenchBlock extends SimpleBlock {
    public static final EnumProperty<TableBenchShape> TABLE_BENCH_SHAPE = EnumProperty.create("shape", TableBenchShape.class);

    public TableBenchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TABLE_BENCH_SHAPE, TableBenchShape.SINGLE).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TableBenchBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TABLE_BENCH_SHAPE, FACING, WATERLOGGED);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().isHorizontal() ? state.setValue(TABLE_BENCH_SHAPE, getBenchShape(state, level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState blockState = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return blockState.setValue(TABLE_BENCH_SHAPE, getBenchShape(blockState, context.getLevel(), blockPos));
    }

    private TableBenchShape getBenchShape(BlockState state, BlockGetter level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockState blockState3 = level.getBlockState(pos.relative(direction.getClockWise()));
        BlockState blockState4 = level.getBlockState(pos.relative(direction.getClockWise().getOpposite()));
        if (!blockState3.is(this) && !blockState4.is(this)) {
            return TableBenchShape.SINGLE;
        } else if (!blockState3.is(this)) {
            return TableBenchShape.RIGHT;
        } else if (!blockState4.is(this)) {
            return TableBenchShape.LEFT;
        } else {
            return TableBenchShape.MIDDLE;
        }
    }
}
