package net.qiuze.neoforgebw.item.custom.tools;

import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.item.ModItems;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public enum ModItemTiers implements Tier {
    BLOOD(4,10000,15F,500F,60,()->Ingredient.of(Items.NETHERITE_INGOT));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModItemTiers(int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
        this.level = pLevel;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue =  pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }
    @Override
    public float getAttackDamageBonus() {
        return this.damage;//返回额外伤害加成
    }


    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return TagKey.create(BuiltInRegistries.BLOCK.key(),new ResourceLocation(BarrenWilderness.MODID,"empty"));
    }
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public static final ArmorMaterial BLOOD_ARMOR_MATERIAL = new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 30);
                map.put(ArmorItem.Type.LEGGINGS, 60);
                map.put(ArmorItem.Type.CHESTPLATE, 80);
                map.put(ArmorItem.Type.HELMET, 30);
                map.put(ArmorItem.Type.BODY, 20);
            }),

            30,

            SoundEvents.ARMOR_EQUIP_NETHERITE,

            () -> Ingredient.of(ModItems.BLOOD.get()),

            List.of(

                    new ArmorMaterial.Layer(
                            new ResourceLocation(BarrenWilderness.MODID, "blood")
                    ),

                    new ArmorMaterial.Layer(
                            new ResourceLocation(BarrenWilderness.MODID, "blood"), "_overlay", true
                    )
            ),
            1.0F,
            10.0F
    );
}
