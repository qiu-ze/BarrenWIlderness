package net.qiuze.neoforgebw;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.qiuze.neoforgebw.block.ModBlocks;
import net.qiuze.neoforgebw.item.ModCreativeTab;
import net.qiuze.neoforgebw.item.ModItems;
import org.slf4j.Logger;

@Mod(BarrenWilderness.MODID)
public class BarrenWilderness
{
    public static final String MODID = "neoforgebw";
    private static final Logger LOGGER = LogUtils.getLogger();
    public BarrenWilderness(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        ModItems.register(modEventBus);
        ModCreativeTab.register(modEventBus);
        ModBlocks.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }
}
