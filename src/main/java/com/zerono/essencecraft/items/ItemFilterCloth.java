package com.zerono.essencecraft.items;

import java.util.List;

import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.reference.Textures;
import com.zerono.essencecraft.utility.MathHelperEC;
import com.zerono.essencecraft.utility.TextFormatHelper;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemFilterCloth extends ItemEC
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
    public ItemFilterCloth()
    {
        super();
        this.setMaxStackSize(16);
        this.setHasSubtypes(true);
        this.setUnlocalizedName(Names.Items.FILTER_CLOTH);
    }
   
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, Names.Items.FILTER_CLOTH);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
    	return String.format("item.%s%s", Textures.RESOURCE_PREFIX, Names.Items.FILTER_CLOTH);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTab, List list)
    {
        for (int meta = 0; meta < Names.Items.FILTER_SUBTYPES.length; ++meta)
        {
            list.add(new ItemStack(this, 1, meta));
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[Names.Items.FILTER_SUBTYPES.length];
        
        for (int i=0; i < Names.Items.FILTER_SUBTYPES.length; i++)
        {
            icons[i] = iconRegister.registerIcon(Textures.RESOURCE_PREFIX + Names.Items.FILTER_CLOTH + "." + Names.Items.FILTER_SUBTYPES[i]);
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List info, boolean useExtraInformation)
    {
    	int meta = itemStack.getItemDamage();
    	info.add(TextFormatHelper.Rarity.ITEM_RARITY_COLORS[meta] + Names.Items.FILTER_SUBTYPES[meta]);
    }
}
