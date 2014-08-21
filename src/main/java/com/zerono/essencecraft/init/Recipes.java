package com.zerono.essencecraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
    public static void Init()
    {
        /* Depreciated
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.redstoneSolution), new ItemStack(Items.redstone), new ItemStack(Items.water_bucket), new ItemStack(Items.glass_bottle));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.glowstoneSolution), new ItemStack(Items.glowstone_dust), new ItemStack(Items.water_bucket), new ItemStack(Items.glass_bottle));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.enderSolution), "dustEnderPearl", new ItemStack(Items.water_bucket), new ItemStack(Items.glass_bottle)));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.redstoneSolution), new ItemStack(Items.redstone), new ItemStack(Items.potionitem));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.glowstoneSolution), new ItemStack(Items.redstone), new ItemStack(Items.potionitem));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.enderSolution), "dustEnderPearl", new ItemStack(Items.potionitem)));
        */
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.essenceExtractor), "bsb", "scs", "sbs", 'b', new ItemStack(Items.glass_bottle), 's', new ItemStack(Blocks.stone), 'c', new ItemStack(Items.compass));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.inertDust,  9), new ItemStack(ModBlocks.inertStone));
        
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.solution, 1, 0), new ItemStack(Items.redstone), new ItemStack(Items.potionitem) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.solution, 1, 1), new ItemStack(Items.glowstone_dust), new ItemStack(Items.potionitem));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.solution, 1, 2), "dustEnderPearl"));
        
    }
}
