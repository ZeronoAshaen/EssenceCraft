package com.zerono.essencecraft.init;

import com.zerono.essencecraft.blocks.BlockBasicCentrifuge;
import com.zerono.essencecraft.blocks.BlockDripFilter;
import com.zerono.essencecraft.blocks.BlockEC;
import com.zerono.essencecraft.blocks.BlockFilterHousing;
import com.zerono.essencecraft.blocks.BlockInertStone;
import com.zerono.essencecraft.blocks.BlockLargeDecanter;
import com.zerono.essencecraft.blocks.BlockOreEC;
import com.zerono.essencecraft.blocks.BlockOreEC;
import com.zerono.essencecraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockEC inertStone = new BlockInertStone();
    public static final BlockEC basicCentrifuge = new BlockBasicCentrifuge();
    public static final BlockEC oreSalt = new BlockOreEC();
    public static final BlockEC filterHousing = new BlockFilterHousing();
    public static final BlockEC largeDecanter = new BlockLargeDecanter();
    
    public static void init()
    {
    	initBlocks();
    	initMachines();
    }
    
    public static void initBlocks()
    {
        GameRegistry.registerBlock(inertStone, "inertStone");
        GameRegistry.registerBlock(oreSalt, "oreSalt");
        GameRegistry.registerBlock(filterHousing, "filterHousing");
        GameRegistry.registerBlock(largeDecanter, "largeDecanter");
    }
    
    public static void initMachines()
    {
        GameRegistry.registerBlock(basicCentrifuge, "basicExtractor");
        //GameRegistry.registerBlock(dripFilter, "dripFilter");
    }
    
}
