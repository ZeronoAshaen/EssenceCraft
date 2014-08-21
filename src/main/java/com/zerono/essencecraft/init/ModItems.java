package com.zerono.essencecraft.init;

import com.zerono.essencecraft.items.ItemEC;
import com.zerono.essencecraft.items.ItemDustEnder;
import com.zerono.essencecraft.items.ItemEnderEssence;
import com.zerono.essencecraft.items.ItemEnderSolution;
import com.zerono.essencecraft.items.ItemGlowstoneEssence;
import com.zerono.essencecraft.items.ItemGlowstoneSolution;
import com.zerono.essencecraft.items.ItemInertDust;
import com.zerono.essencecraft.items.ItemRedstoneEssence;
import com.zerono.essencecraft.items.ItemRedstoneSolution;
import com.zerono.essencecraft.items.ItemSolution;
import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemEC inertDust = new ItemInertDust();
    
    public static final ItemEC enderEssence = new ItemEnderEssence();
    public static final ItemEC redstoneEssence = new ItemRedstoneEssence();
    public static final ItemEC glowstoneEssence = new ItemGlowstoneEssence();
    
    public static final ItemEC enderSolution = new ItemEnderSolution();
    public static final ItemEC redstoneSolution = new ItemRedstoneSolution();
    public static final ItemEC glowstoneSolution = new ItemGlowstoneSolution();
    
    public static final ItemEC solution = new ItemSolution();
    
    public static final ItemEC dustEnderPearl = new ItemDustEnder();
    
    public static void Init()
    {
        GameRegistry.registerItem(inertDust, "inertDust");
        GameRegistry.registerItem(dustEnderPearl, "dustEnderPearl");
        
        GameRegistry.registerItem(solution, Names.Items.SOLUTION);
        
        GameRegistry.registerItem(enderEssence, "enderEssence");
        GameRegistry.registerItem(redstoneEssence, "redstoneEssence");
        GameRegistry.registerItem(glowstoneEssence, "glowstoneEssence");
        
        /*Depreciated
        GameRegistry.registerItem(enderSolution, "enderSolution");
        GameRegistry.registerItem(redstoneSolution, "redstoneSolution");
        GameRegistry.registerItem(glowstoneSolution, "glowstoneSolution");*/
    }
}