package net.qiuze.neoforgebw.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.block.ModBlocks;
import net.qiuze.neoforgebw.item.custom.BloodItem;
import net.qiuze.neoforgebw.item.custom.StoneCoinItem;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, BarrenWilderness.MODID);

    public static final Supplier<Item> STONECOIN = ITEMS.register("stonecoin",()-> new StoneCoinItem(new Item.Properties()));

    public static final Supplier<Item> STONECOIN_BLOCK = ITEMS.register("stonecoin_block",()-> new BlockItem(ModBlocks.STONECOIN_BLOCK.get(),new Item.Properties()));

    public static final Supplier<Item> BLOOD = ITEMS.register("blood",()-> new BloodItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
