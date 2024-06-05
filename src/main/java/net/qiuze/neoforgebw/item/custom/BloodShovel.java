package net.qiuze.neoforgebw.item.custom;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.qiuze.neoforgebw.item.ModItemTiers;

public class BloodShovel extends ShovelItem {
    public BloodShovel (){
        super(ModItemTiers.BLOOD,new Properties().attributes(
                ShovelItem.createAttributes(
                        ModItemTiers.BLOOD,
                        100,
                        -0.8f
                )
        ));
    }
}
