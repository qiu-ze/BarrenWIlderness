package net.qiuze.neoforgebw.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class StoneCoinBlock extends Block {
    public StoneCoinBlock() {
        super(Properties.ofFullCopy(Blocks.GOLD_BLOCK).strength(5F));    }
}
