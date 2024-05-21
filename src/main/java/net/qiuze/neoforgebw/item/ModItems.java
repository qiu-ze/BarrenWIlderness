package net.qiuze.neoforgebw.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.item.custom.StoneCoinItem;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, BarrenWilderness.MODID);

    public static final Supplier<Item> STONECOIN = ITEMS.register("stonecoin",()-> new StoneCoinItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
