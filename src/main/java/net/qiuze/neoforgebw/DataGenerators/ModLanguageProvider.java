package net.qiuze.neoforgebw.DataGenerators;

import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.qiuze.neoforgebw.item.ModItems;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output,String modid,String locale){
        super(output, modid, locale);
    }

    @Override
    public void addTranslations(){
        this.add(ModItems.BLOOD_DEVIL_SWORD.get(),"Blood Devil Sword");
        this.add(ModItems.BLOOD.get(),"blood");
        this.add("object.neoforgebw.example_object","Neoforgebw Object");
    }
}
