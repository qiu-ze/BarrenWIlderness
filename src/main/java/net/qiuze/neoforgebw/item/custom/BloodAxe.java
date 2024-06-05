package net.qiuze.neoforgebw.item.custom;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.PickaxeItem;
import net.qiuze.neoforgebw.item.ModItemTiers;

public class BloodAxe extends AxeItem {
    public BloodAxe(){
        super(ModItemTiers.BLOOD,new Properties().attributes(
                AxeItem.createAttributes(
                        ModItemTiers.BLOOD,
                        600,
                        -2.0f
                )
        ));
    }
}
