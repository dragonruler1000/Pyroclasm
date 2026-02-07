package us.minecraftchest2.pyroclasm.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import us.minecraftchest2.pyroclasm.Pyroclasm;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Pyroclasm.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
        //                .add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES); example usage

    }
}
