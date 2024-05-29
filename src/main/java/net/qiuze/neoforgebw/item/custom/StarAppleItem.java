package net.qiuze.neoforgebw.item.custom;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class StarAppleItem extends Item {
    private static final FoodProperties FOOD_PROPERTIES =new FoodProperties.Builder()
            .saturationModifier(50)
            .nutrition(50)
            .effect(()->new MobEffectInstance(MobEffects.HEAL),3)
            .build();
    public StarAppleItem(){
        super(new Properties().food(FOOD_PROPERTIES));
    }
}
