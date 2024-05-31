package net.qiuze.neoforgebw.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.qiuze.neoforgebw.item.ModItemTiers;
import net.qiuze.neoforgebw.item.ModItems;

public class BloodDevilSword extends SwordItem {
    public BloodDevilSword(){
        super(ModItemTiers.BLOOD,new Item.Properties().attributes(
                SwordItem.createAttributes(
                        ModItemTiers.BLOOD,
                        500,
                        -2.4f
                )
        ));
    }
}
