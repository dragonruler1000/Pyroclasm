package us.minecraftchest2.pyroclasm.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import us.minecraftchest2.pyroclasm.Pyroclasm;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, Pyroclasm.MOD_ID);

    public static final RegistryObject<Item> CORE_IRON = ITEMS.register("core_iron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CORE_IRON = ITEMS.register("raw_core_iron",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
