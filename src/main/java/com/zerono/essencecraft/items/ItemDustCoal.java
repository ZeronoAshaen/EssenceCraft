package com.zerono.essencecraft.items;

import net.minecraft.util.IIcon;

import com.zerono.essencecraft.reference.Names;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDustCoal extends ItemEC 
{
	public ItemDustCoal()
	{
		super();
		this.setMaxStackSize(64);
		this.setUnlocalizedName(Names.Items.COAL_DUST);
	}

}
