package net.qiuze.neoforgebw.event.client;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.item.ModItems;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = BarrenWilderness.MODID,bus = EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class PropertyRegistry {


    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
        ItemProperties.register(ModItems.BLOOD.get(),new ResourceLocation(BarrenWilderness.MODID,"size"),(itemStack,level,livingEntity,int_num)->{
            return itemStack.getCount();
        });
    });
    }
}
