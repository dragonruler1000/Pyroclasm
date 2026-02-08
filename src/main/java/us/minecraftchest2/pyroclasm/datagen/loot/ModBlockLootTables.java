package us.minecraftchest2.pyroclasm.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import us.minecraftchest2.pyroclasm.block.ModBlocks;
import us.minecraftchest2.pyroclasm.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CORE_IRON_BLOCK.get());
        //ores
        this.add(ModBlocks.CORE_IRON_ORE.get(),
                block -> createOreDrop(ModBlocks.CORE_IRON_ORE.get(), ModItems.RAW_CORE_IRON.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
