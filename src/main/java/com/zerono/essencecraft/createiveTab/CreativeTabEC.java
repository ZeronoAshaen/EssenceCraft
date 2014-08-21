package com.zerono.essencecraft.createiveTab;

import com.zerono.essencecraft.init.ModBlocks;
import com.zerono.essencecraft.init.ModItems;
import com.zerono.essencecraft.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabEC
{
    public static final CreativeTabs EC_ITEMS_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) 
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.inertDust;
        }
    };
    
    public static final CreativeTabs EC_BLOCKS_TAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.inertDust;
        }
    };
}