package com.zerono.essencecraft.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.tileEntity.TileEntityDripFilter;

import cpw.mods.fml.relauncher.Side;

public class BlockDripFilter extends BlockEC implements ITileEntityProvider
{
	public BlockDripFilter()
	{
		super();
		this.setBlockName(Names.Blocks.DRIP_FILTER);
		this.setBlockTextureName(Names.Blocks.DRIP_FILTER);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metaData)
	{
		return new TileEntityDripFilter();
	}
	
}
