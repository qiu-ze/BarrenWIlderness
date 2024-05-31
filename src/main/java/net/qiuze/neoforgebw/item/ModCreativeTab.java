package net.qiuze.neoforgebw.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BarrenWilderness.MODID);

    public static final String BARREN_WILDERNESS_TAB_STRING = "creativetab.barren_tab";

    public static final Supplier<CreativeModeTab> BARREN_TAB = CREATIVE_MODE_TABS.register("barren_tab",() -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable(BARREN_WILDERNESS_TAB_STRING))
            .icon(() ->ModItems.STONECOIN.get().getDefaultInstance())
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.STONECOIN.get());
                pOutput.accept(ModItems.BLOOD.get());
                pOutput.accept(ModItems.STAR_APPLE.get());
                pOutput.accept(ModItems.BLOOD_DEVIL_SWORD.get());
                pOutput.accept(ModItems.STONECOIN_BLOCK.get());
                pOutput.accept(ModBlocks.BLOOD_BLOCK.get());

            })
            .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
