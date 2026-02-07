package us.minecraftchest2.pyroclasm.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import us.minecraftchest2.pyroclasm.Pyroclasm;
import us.minecraftchest2.pyroclasm.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Pyroclasm.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PYROCLASM_TAB = CREATIVE_MODE_TABS.register("pyroclasm_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CORE_IRON.get()))
                    .title(Component.translatable("creativetab.pyroclasm_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //items
                        output.accept(ModItems.CORE_IRON.get());
                        output.accept(ModItems.RAW_CORE_IRON.get());

                        //blocks
                        output.accept(ModBlocks.CORE_IRON_BLOCK.get());
                        output.accept(ModBlocks.CORE_IRON_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
