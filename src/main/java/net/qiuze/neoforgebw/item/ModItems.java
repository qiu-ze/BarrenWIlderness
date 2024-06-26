package net.qiuze.neoforgebw.item;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qiuze.neoforgebw.BarrenWilderness;
import net.qiuze.neoforgebw.block.ModBlocks;
import net.qiuze.neoforgebw.item.custom.*;
import net.qiuze.neoforgebw.item.custom.tools.ModItemTiers;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, BarrenWilderness.MODID);

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION,BarrenWilderness.MODID);

    public static final Supplier<Item> STONECOIN = ITEMS.register("stonecoin",()-> new StoneCoinItem(new Item.Properties()));

    public static final Supplier<Item> STONECOIN_BLOCK = ITEMS.register("stonecoin_block",()-> new BlockItem(ModBlocks.STONECOIN_BLOCK.get(),new Item.Properties()));

    public static final Supplier<Item> BLOOD = ITEMS.register("blood",()-> new BloodItem(new Item.Properties()));

    public static final Supplier<Item> STAR_APPLE = ITEMS.register("star_apple", StarAppleItem::new);

    public static final Supplier<Potion> BLOOD_POTION = POTIONS.register("blood",()->new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST,3600)));

    public static final Supplier<Item> BLOOD_DEVIL_SWORD = ITEMS.register("blood_devil_sword", BloodDevilSword::new);

    public static final Supplier<Item> BLOOD_PICKAXE = ITEMS.register("blood_pickaxe", BloodPickaxe::new);

    public static final Supplier<Item> BLOOD_AXE = ITEMS.register("blood_axe",BloodAxe::new);

    public static final Supplier<Item> BLOOD_SHOVEL = ITEMS.register("blood_shovel",BloodShovel::new);

    public static final Supplier<Item> BLOOD_HOE = ITEMS.register("blood_hoe",BloodHoe::new);

    public static final Supplier<ArmorItem> BLOOD_HELMET = ITEMS.register("blood_helmet",()->new ArmorItem(
             Holder.direct(ModItemTiers.BLOOD_ARMOR_MATERIAL),
            ArmorItem.Type.HELMET,
            (new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33)))
    ));

    public static final Supplier<ArmorItem> BLOOD_CHESTPLATE = ITEMS.register("blood_chestplate",()->new ArmorItem(
            Holder.direct(ModItemTiers.BLOOD_ARMOR_MATERIAL),
            ArmorItem.Type.CHESTPLATE,
            (new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(33)))
    ));

    public static final Supplier<ArmorItem> BLOOD_LEGGINGS = ITEMS.register("blood_leggings",()->new ArmorItem(
            Holder.direct(ModItemTiers.BLOOD_ARMOR_MATERIAL),
            ArmorItem.Type.LEGGINGS,
            (new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(33)))
    ));

    public static final Supplier<ArmorItem> BLOOD_BOOTS = ITEMS.register("blood_boots",()->new ArmorItem(
            Holder.direct(ModItemTiers.BLOOD_ARMOR_MATERIAL),
            ArmorItem.Type.BOOTS,
            (new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(33))))
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
