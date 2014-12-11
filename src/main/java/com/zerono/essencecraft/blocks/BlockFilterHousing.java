package com.zerono.essencecraft.blocks;

import com.zerono.essencecraft.createiveTab.CreativeTabEC;
import com.zerono.essencecraft.init.ModBlocks;
import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.reference.RenderIds;
import com.zerono.essencecraft.tileEntity.TileEntityFilterHousing;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFilterHousing extends BlockEC implements ITileEntityProvider
{
	public BlockFilterHousing()
	{
		super(Material.iron);
		this.setBlockName(Names.Blocks.FILTER_HOUSING);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeWood);
		this.setCreativeTab(CreativeTabEC.EC_NONBLOCKS_TAB);
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return RenderIds.filterHousing;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	
	private boolean decanterTop(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y+1, z)==ModBlocks.largeDecanter)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean decanterBottom(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y-1, z)==ModBlocks.largeDecanter)
		{
			return true;
		}
		else
		{
			return false;
		}	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if(!world.isRemote)
		{
			if(decanterTop(world,x,y,z)&&decanterBottom(world,x,y,z))
			{
				this.setBlockTextureName(Names.Blocks.FILTER_HOUSING_BOTH);
			}
			else if(decanterTop(world,x,y,z))
			{
				this.setBlockTextureName(Names.Blocks.FILTER_HOUSING_TOP);
			}
			else if(decanterBottom(world,x,y,z))
			{
				this.setBlockTextureName(Names.Blocks.FILTER_HOUSING_BOTTOM);
			}
			else
			{
				this.setBlockTextureName(Names.Blocks.FILTER_HOUSING);
			}
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metaData) 
	{
		return null; //new TileEntityFilterHousing();
	}
	
}
