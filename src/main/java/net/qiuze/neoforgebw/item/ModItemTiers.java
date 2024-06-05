package net.qiuze.neoforgebw.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.block.custom.BloodBlock;

import java.util.function.Supplier;

public enum ModItemTiers implements Tier {
    BLOOD(4,10000,15F,500F,60,()->Ingredient.of(Items.NETHERITE_INGOT));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModItemTiers(int pLevel, int pUses, float pSpeed, float pDamage,int pEnchantmentValue,Supplier<Ingredient> pRepairIngredient) {
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
}
