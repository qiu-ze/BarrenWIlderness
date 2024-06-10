package net.qiuze.neoforgebw.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BingBlock extends Block {
    public BingBlock(){
        super(Properties.ofFullCopy(Blocks.GLASS).strength(4).noOcclusion());
    }
}
