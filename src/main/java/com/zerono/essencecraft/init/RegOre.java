package com.zerono.essencecraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RegOre
{
    public static void init()
    {
        OreDictionary.registerOre("dustEnderPearl", new ItemStack(ModItems.dustEnderPearl));
        OreDictionary.registerOre("itemDustEnderPearl", new ItemStack(ModItems.dustEnderPearl));
    }
}