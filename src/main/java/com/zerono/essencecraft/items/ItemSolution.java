package com.zerono.essencecraft.items;

import java.util.List;

import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.reference.Textures;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


// Possible replacement for individual Solution items

public class ItemSolution extends ItemEC
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
    public ItemSolution()
    {
        super();
        this.setMaxStackSize(16);
        this.setHasSubtypes(true);
        this.setUnlocalizedName(Names.Items.SOLUTION);
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, Names.Items.SOLUTION);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTab, List list)
    {
        for (int meta = 0; meta < Names.Items.SOLUTION_SUBTYPES.length; ++meta)
        {
            list.add(new ItemStack(this, 1, meta));
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[Names.Items.SOLUTION_SUBTYPES.length];
        
        for (int i=0; i < Names.Items.SOLUTION_SUBTYPES.length; i++)
        {
            icons[i] = iconRegister.registerIcon(Textures.RESOURCE_PREFIX + Names.Items.SOLUTION + "." + Names.Items.SOLUTION_SUBTYPES[i]);
        }
    }
}
