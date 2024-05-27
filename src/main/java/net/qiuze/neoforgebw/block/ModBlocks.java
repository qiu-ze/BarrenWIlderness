package net.qiuze.neoforgebw.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.block.custom.BloodBlock;
import net.qiuze.neoforgebw.block.custom.StoneCoinBlock;
import java.util.function.Supplier;

import static net.qiuze.neoforgebw.item.ModItems.ITEMS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, BarrenWilderness.MODID);

    public static final Supplier<Block> STONECOIN_BLOCK = BLOCKS.register("stonecoin_block", StoneCoinBlock::new);

    public static final Supplier<Block> BLOOD_BLOCK = registerBlock("blood_block",()->new
            BloodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(6f).requiresCorrectToolForDrops()
            .lightLevel(state->state.getValue(BloodBlock.FIRE)?15:0)));



    public static Supplier<Block> registerBlock(String name,Supplier<Block> block){
        Supplier<Block> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    public static void registerBlockItem(String name,Supplier<Block> block){
        registerBlockItem(name, block, new Item.Properties());
    }

    public static void registerBlockItem(String name, Supplier<Block> block, Item.Properties properties){
        ITEMS.register(name, () -> new BlockItem(block.get(),properties));
    }

    public static final void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}

