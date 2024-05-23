package net.qiuze.neoforgebw.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.block.custom.StoneCoinBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, BarrenWilderness.MODID);

    public static final Supplier<Block> STONECOIN_BLOCK = BLOCKS.register("stonecoin_block", StoneCoinBlock::new);

    public static final void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
