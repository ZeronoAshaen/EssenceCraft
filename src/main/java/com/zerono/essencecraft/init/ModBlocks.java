package com.zerono.essencecraft.init;

import com.zerono.essencecraft.blocks.BlockEC;
import com.zerono.essencecraft.blocks.BlockEssenceExtractor;
import com.zerono.essencecraft.blocks.BlockInertStone;
import com.zerono.essencecraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockEC inertStone = new BlockInertStone();
    
    public static final BlockEC essenceExtractor = new BlockEssenceExtractor();
    
    public static void init()
    {
        GameRegistry.registerBlock(inertStone, "inertStone");
        
        GameRegistry.registerBlock(essenceExtractor, "essenceExtractor");
    }
}