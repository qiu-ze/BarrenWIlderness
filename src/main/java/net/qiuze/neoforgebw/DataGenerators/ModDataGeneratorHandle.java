package net.qiuze.neoforgebw.DataGenerators;

import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.qiuze.neoforgebw.BarrenWilderness;

@EventBusSubscriber(modid = BarrenWilderness.MODID,bus = EventBusSubscriber.Bus.MOD)

public class ModDataGeneratorHandle {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        ExistingFileHelper efh =event.getExistingFileHelper();

        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModLanguageProvider>) pOutput -> new  ModLanguageProvider(pOutput,BarrenWilderness.MODID,"en_us")
        );

        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModBlockStateProvider>) pOutput -> new  ModBlockStateProvider(pOutput,BarrenWilderness.MODID,efh)
        );

        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModItemModelProvider>) pOutput -> new ModItemModelProvider(pOutput,BarrenWilderness.MODID,efh)
        );

    }
}
