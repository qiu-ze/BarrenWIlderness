package net.qiuze.neoforgebw.item.custom;

import net.minecraft.world.item.HoeItem;
import net.qiuze.neoforgebw.item.custom.tools.ModItemTiers;

public class BloodHoe extends HoeItem {
    public BloodHoe(){
        super(ModItemTiers.BLOOD,new Properties().attributes(
                HoeItem.createAttributes(
                        ModItemTiers.BLOOD,
                        100,
                        -0.9f
                )
        ));
    }
}
