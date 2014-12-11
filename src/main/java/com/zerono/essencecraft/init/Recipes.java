package com.zerono.essencecraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
    public static void Init()
    {
    	initModRecipes();
    }
    
    private static void initModRecipes()
    {
    	// Block Recipes
    	GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.inertStone), "iii", "iii", "iii", 'i', new ItemStack(ModItems.inertDust));
    	GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.basicCentrifuge), "bbb", " c ", "sss", 'b', new ItemStack(Items.glass_bottle), 'c', new ItemStack(Items.compass), 's', new ItemStack(Blocks.stone_slab));
    	// Filter Recipes
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.filterCloth, 2, 0), "sss", "sws", "sss", 's', new ItemStack(Items.string), 'w', new ItemStack(Blocks.web)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.filterCloth, 1, 1), "sfs", "fff", "sfs", 's', new ItemStack(Items.string), 'f', new ItemStack(ModItems.filterCloth, 1, 0)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.filterCloth, 1, 2), "sfs", "fcf", "sfs", 'f', new ItemStack(ModItems.filterCloth, 1, 1), 'c', "dustCoal", 's', new ItemStack(ModItems.filterCloth, 1, 1)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.filterCloth, 1, 3), "sfs", "fcf", "sfs", 'f', new ItemStack(ModItems.filterCloth, 1, 1), 'c', new ItemStack(ModItems.filterCloth, 1, 2), 's', new ItemStack(Items.string)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.filterFrame), "sws", "w w", "sws", 's', new ItemStack(Items.string), 'w', "stickWood"));
    	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.filterBasic), new ItemStack(ModItems.filterCloth, 1, 0), new ItemStack(ModItems.filterFrame));
    	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.filterFine), new ItemStack(ModItems.filterCloth, 1, 1), new ItemStack(ModItems.filterFrame));
    	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.filterCoal), new ItemStack(ModItems.filterCloth, 1, 2), new ItemStack(ModItems.filterFrame));
    	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.filterSturdy), new ItemStack(ModItems.filterCloth, 1, 3), new ItemStack(ModItems.filterFrame));
    	
    	// Solution Recipes
    	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.solution, 1, 0), "oreSalt", new ItemStack(Items.potionitem, 1, 0)));
    	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.solution, 1, 1), "oreSalt", new ItemStack(Items.potionitem, 1, 0), new ItemStack(ModItems.filterCloth, 1, 0)));
    }
}
