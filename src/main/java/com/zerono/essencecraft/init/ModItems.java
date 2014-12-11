package com.zerono.essencecraft.init;

import com.zerono.essencecraft.items.ItemDustCoal;
import com.zerono.essencecraft.items.ItemEC;
import com.zerono.essencecraft.items.ItemDustEnder;
import com.zerono.essencecraft.items.ItemEssence;
import com.zerono.essencecraft.items.ItemFilterBasic;
import com.zerono.essencecraft.items.ItemFilterCloth;
import com.zerono.essencecraft.items.ItemFilterCoal;
import com.zerono.essencecraft.items.ItemFilterFine;
import com.zerono.essencecraft.items.ItemFilterFrame;
import com.zerono.essencecraft.items.ItemFilterSturdy;
import com.zerono.essencecraft.items.ItemInertPearl;
import com.zerono.essencecraft.items.ItemSaltPile;
import com.zerono.essencecraft.items.ItemInertDust;
import com.zerono.essencecraft.items.ItemSolution;
import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemEC inertDust = new ItemInertDust();
	public static final ItemEC dustEnderPearl = new ItemDustEnder();
	public static final ItemEC inertPearl = new ItemInertPearl();
	public static final ItemEC dustCoal = new ItemDustCoal();
	public static final ItemEC saltPile = new ItemSaltPile();
	
	public static final ItemEC filterCloth = new ItemFilterCloth();
	public static final ItemEC filterFrame = new ItemFilterFrame();
	public static final ItemEC filterBasic = new ItemFilterBasic();
	public static final ItemEC filterFine = new ItemFilterFine();
	public static final ItemEC filterCoal = new ItemFilterCoal();
	public static final ItemEC filterSturdy = new ItemFilterSturdy();
	
	public static final ItemEC solution = new ItemSolution();
	public static final ItemEC essence = new ItemEssence();
	
    public static void Init()
    {
    	GameRegistry.registerItem(inertDust, Names.Items.INERT_DUST);
    	GameRegistry.registerItem(dustEnderPearl, Names.Items.ENDER_PEARL_DUST);
    	GameRegistry.registerItem(inertPearl, Names.Items.INERT_PEARL);
    	GameRegistry.registerItem(filterCloth, Names.Items.FILTER);
    	GameRegistry.registerItem(dustCoal, Names.Items.COAL_DUST);
    	
    	GameRegistry.registerItem(filterFrame, Names.Items.FILTER_FRAME);
    	GameRegistry.registerItem(filterBasic, Names.Items.FILTER_BASIC);
    	GameRegistry.registerItem(filterFine, Names.Items.FILTER_FINE);
    	GameRegistry.registerItem(filterCoal, Names.Items.FILTER_COAL);
    	GameRegistry.registerItem(filterSturdy, Names.Items.FILTER_STURDY);
    	GameRegistry.registerItem(saltPile, Names.Items.SALT_PILE);
    	
    	GameRegistry.registerItem(solution, Names.Items.SOLUTION);
    	GameRegistry.registerItem(essence, Names.Items.ESSENCE);
    }
}
