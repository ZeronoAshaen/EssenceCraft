package com.zerono.essencecraft.items;

import java.util.List;

import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.reference.Textures;
import com.zerono.essencecraft.utility.MathHelperEC;
import com.zerono.essencecraft.utility.TextFormatHelper;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


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
    
    public static int getType(int meta)
    {
		double d = Math.floor(meta/Names.Items.SOLUTION_ESSENCE_SUBTYPES.length);
		int i = (int) d;
		return i;
    }
    
    public static int getSubtype(int meta)
    {
		double d = (meta - (Math.floor(meta/Names.Items.SOLUTION_ESSENCE_SUBTYPES.length)*Names.Items.SOLUTION_ESSENCE_SUBTYPES.length));
		int subtype = (int) d;
		return subtype;
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, Names.Items.SOLUTION);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
    	int type = getType(itemStack.getItemDamage());
    	return String.format("item.%s%s.%s", Textures.RESOURCE_PREFIX, Names.Items.SOLUTION, Names.Items.SOLUTION_TYPES[type]);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTab, List list)
    {
    	for (int meta = 0; meta < ((Names.Items.SOLUTION_TYPES.length * Names.Items.SOLUTION_ESSENCE_SUBTYPES.length)); ++meta)
        {
    		list.add(new ItemStack(this, 1, meta));
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List info, boolean useExtraInformation)
    {
    	int type = getType(itemStack.getItemDamage());
    	int subtype = getSubtype(itemStack.getItemDamage());
    	String starter = "a ";
    	if (subtype == 0){starter = "an ";};
    	info.add(TextFormatHelper.Colors.WHITE + Character.toUpperCase(Names.Items.SOLUTION_TYPES[type].charAt(0)) + Names.Items.SOLUTION_TYPES[type].substring(1) + TextFormatHelper.Formatting.RESET + ": " + TextFormatHelper.Rarity.ITEM_RARITY_COLORS[subtype] + Character.toUpperCase(Names.Items.SOLUTION_ESSENCE_SUBTYPES[subtype].charAt(0)) + Names.Items.SOLUTION_ESSENCE_SUBTYPES[subtype].substring(1));
    	if (type == 0)
    	{
    		info.add(TextFormatHelper.Colors.LIGHT_PURPLE + Character.toUpperCase(starter.charAt(0)) + starter.substring(1) + Names.Items.SOLUTION_ESSENCE_SUBTYPES[subtype] + " saline solution ready for something to be dissolved within it.");
    	}
    	else
    	{
    		info.add(TextFormatHelper.Colors.LIGHT_PURPLE + "A phial filled with " + starter + Names.Items.SOLUTION_ESSENCE_SUBTYPES[subtype] + " solution of dissolved " + Character.toUpperCase(Names.Items.SOLUTION_TYPES[type].charAt(0)) + Names.Items.SOLUTION_TYPES[type].substring(1) + ".");
    	}
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
    	return icons[MathHelper.clamp_int(meta, 0, ((Names.Items.SOLUTION_TYPES.length * Names.Items.SOLUTION_ESSENCE_SUBTYPES.length) - 1))];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[(Names.Items.SOLUTION_TYPES.length * Names.Items.SOLUTION_ESSENCE_SUBTYPES.length)];
        int iconNumber = 0;
    	for (int j=0; j < Names.Items.SOLUTION_TYPES.length; j++)
    	{
        	for (int k=0; k < Names.Items.SOLUTION_ESSENCE_SUBTYPES.length; k++)
            {
        		icons[iconNumber] = iconRegister.registerIcon(Textures.RESOURCE_PREFIX + Names.Items.SOLUTION + Character.toUpperCase(Names.Items.SOLUTION_TYPES[j].charAt(0)) + Names.Items.SOLUTION_TYPES[j].substring(1));
        		iconNumber++;
            }
    	}
    }
}
