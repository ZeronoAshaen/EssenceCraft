package com.zerono.essencecraft.items;

import com.zerono.essencecraft.reference.Names;

public class ItemFilterBasic extends ItemEC 
{
	public ItemFilterBasic()
	{
		super();
		this.setMaxDamage(5);
		this.setNoRepair();
		this.setUnlocalizedName(Names.Items.FILTER_BASIC);
	}
}
