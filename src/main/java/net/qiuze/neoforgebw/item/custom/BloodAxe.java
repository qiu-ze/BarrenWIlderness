package net.qiuze.neoforgebw.item.custom;

import net.minecraft.world.item.AxeItem;
import net.qiuze.neoforgebw.item.custom.tools.ModItemTiers;

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
