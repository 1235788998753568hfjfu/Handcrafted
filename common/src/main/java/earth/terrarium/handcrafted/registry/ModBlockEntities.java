package earth.terrarium.handcrafted.registry;

import earth.terrarium.handcrafted.blocks.couch.CouchBlockEntity;
import earth.terrarium.handcrafted.blocks.gardenbench.GardenBenchBlockEntity;
import earth.terrarium.handcrafted.blocks.tablebench.TableBenchBlockEntity;
import earth.terrarium.handcrafted.blocks.tablechair.TableChairBlockEntity;
import earth.terrarium.handcrafted.blocks.woodengardenbench.WoodenGardenBenchBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntities {

    public static final Supplier<BlockEntityType<GardenBenchBlockEntity>> GARDEN_BENCH = register("garden_bench", () -> ModRegistryHelpers.createBlockEntityType(GardenBenchBlockEntity::new, ModBlocks.GARDEN_BENCH.get(), ModBlocks.FROZEN_GARDEN_BENCH.get()));
    public static final Supplier<BlockEntityType<CouchBlockEntity>> COUCH = register("couch", () -> ModRegistryHelpers.createBlockEntityType(CouchBlockEntity::new, ModBlocks.ACACIA_COUCH.get(), ModBlocks.BIRCH_COUCH.get(), ModBlocks.DARK_OAK_COUCH.get(), ModBlocks.JUNGLE_COUCH.get(), ModBlocks.MANGROVE_COUCH.get(), ModBlocks.OAK_COUCH.get(), ModBlocks.SPRUCE_COUCH.get(), ModBlocks.CRIMSON_COUCH.get(), ModBlocks.WARPED_COUCH.get()));
    public static final Supplier<BlockEntityType<TableBenchBlockEntity>> TABLE_BENCH = register("table_bench", () -> ModRegistryHelpers.createBlockEntityType(TableBenchBlockEntity::new, ModBlocks.ACACIA_TABLE_BENCH.get(), ModBlocks.BIRCH_TABLE_BENCH.get(), ModBlocks.DARK_OAK_TABLE_BENCH.get(), ModBlocks.JUNGLE_TABLE_BENCH.get(), ModBlocks.MANGROVE_TABLE_BENCH.get(), ModBlocks.OAK_TABLE_BENCH.get(), ModBlocks.SPRUCE_TABLE_BENCH.get(), ModBlocks.CRIMSON_TABLE_BENCH.get(), ModBlocks.WARPED_TABLE_BENCH.get()));
    public static final Supplier<BlockEntityType<TableChairBlockEntity>> TABLE_CHAIR = register("table_chair", () -> ModRegistryHelpers.createBlockEntityType(TableChairBlockEntity::new, ModBlocks.ACACIA_TABLE_CHAIR.get(), ModBlocks.BIRCH_TABLE_CHAIR.get(), ModBlocks.DARK_OAK_TABLE_CHAIR.get(), ModBlocks.JUNGLE_TABLE_CHAIR.get(), ModBlocks.MANGROVE_TABLE_CHAIR.get(), ModBlocks.OAK_TABLE_CHAIR.get(), ModBlocks.SPRUCE_TABLE_CHAIR.get(), ModBlocks.CRIMSON_TABLE_CHAIR.get(), ModBlocks.WARPED_TABLE_CHAIR.get()));
    public static final Supplier<BlockEntityType<WoodenGardenBenchBlockEntity>> WOODEN_GARDEN_BENCH = register("wooden_garden_bench", () -> ModRegistryHelpers.createBlockEntityType(WoodenGardenBenchBlockEntity::new, ModBlocks.ACACIA_GARDEN_BENCH.get(), ModBlocks.BIRCH_GARDEN_BENCH.get(), ModBlocks.DARK_OAK_GARDEN_BENCH.get(), ModBlocks.JUNGLE_GARDEN_BENCH.get(), ModBlocks.MANGROVE_GARDEN_BENCH.get(), ModBlocks.OAK_GARDEN_BENCH.get(), ModBlocks.SPRUCE_GARDEN_BENCH.get(), ModBlocks.CRIMSON_GARDEN_BENCH.get(), ModBlocks.WARPED_GARDEN_BENCH.get()));

    private static <T extends BlockEntityType<B>, B extends BlockEntity> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistryHelpers.register(Registry.BLOCK_ENTITY_TYPE, id, object);
    }

    public static void init() {
    }
}
