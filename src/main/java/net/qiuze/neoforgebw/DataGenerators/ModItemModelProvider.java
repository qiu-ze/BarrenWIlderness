package net.qiuze.neoforgebw.DataGenerators;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.item.ModItems;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper){
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels(){
        this.basicItem(ModItems.BLOOD_DEVIL_SWORD.get());
    }

    public ResourceLocation getResourceLocation(Item item){
        return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
    }

    public void bloodModel(ResourceLocation item){
        this.getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0",new ResourceLocation("item/blood"))
                .override().predicate(new ResourceLocation(BarrenWilderness.MODID,"size"),32).model(new ModelFile.UncheckedModelFile("item/blood_fire")).end();
    }

}
