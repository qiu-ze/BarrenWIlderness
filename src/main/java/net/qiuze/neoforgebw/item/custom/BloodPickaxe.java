package net.qiuze.neoforgebw.item.custom;

import net.minecraft.world.item.PickaxeItem;
import net.qiuze.neoforgebw.item.ModItemTiers;

public class BloodPickaxe extends PickaxeItem {
    public BloodPickaxe() {
        super(ModItemTiers.BLOOD,new Properties().attributes(
                PickaxeItem.createAttributes(
                        ModItemTiers.BLOOD,
                        200,
                        -0.8f
                )
        ));
    }
}
