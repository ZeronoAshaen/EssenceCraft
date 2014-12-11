package com.zerono.essencecraft.items;

import com.zerono.essencecraft.reference.Names;

public class ItemFilterSturdy extends ItemEC
{
	public ItemFilterSturdy()
	{
		super();
		this.setMaxDamage(5);
		this.setNoRepair();
		this.setUnlocalizedName(Names.Items.FILTER_STURDY);
	}
}
