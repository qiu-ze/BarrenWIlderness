package net.qiuze.neoforgebw.DataGenerators;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.block.ModBlocks;
import net.qiuze.neoforgebw.block.custom.BloodBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper){
        super(output,modid,existingFileHelper);
    }

    protected void registerStatesAndModels(){
        this.simpleBlockWithItem(ModBlocks.STONECOIN_BLOCK.get(),cubeAll(ModBlocks.STONECOIN_BLOCK.get()));
        this.propertyBlock(ModBlocks.BLOOD_BLOCK.get());
    }
    public void propertyBlock(Block block){
        var block_off =models().cubeAll("blood_off",new ResourceLocation(BarrenWilderness.MODID, ModelProvider.BLOCK_FOLDER+"/"+"bloodwt_blood_off"));
        var block_on =models().cubeAll("blood_on",new ResourceLocation(BarrenWilderness.MODID, ModelProvider.BLOCK_FOLDER+"/"+"bloodwt_blood_on"));
        getVariantBuilder(block).partialState().with(BloodBlock.FIRE,true)
                .modelForState().modelFile(block_on).addModel()
                .partialState().with(BloodBlock.FIRE,false)
                .modelForState().modelFile(block_off).addModel();
            simpleBlockWithItem(block,block_off);
    }
}
