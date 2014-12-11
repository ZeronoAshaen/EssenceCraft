package com.zerono.essencecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.zerono.essencecraft.createiveTab.CreativeTabEC;
import com.zerono.essencecraft.init.ModBlocks;
import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLargeDecanter extends BlockEC
{
	@SideOnly(Side.CLIENT)
	private IIcon invertIcon;
	
	public BlockLargeDecanter()
	{
		super();
		this.setBlockName(Names.Blocks.LARGE_DECANTER);
		this.setHardness(0.2F);
		this.setResistance(2.0F);
		this.setStepSound(soundTypeGlass);
		this.setCreativeTab(CreativeTabEC.EC_NONBLOCKS_TAB);
	}
	
	private boolean isInverted(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y-1, z)==ModBlocks.filterHousing)
		{
			int newMeta = 1;
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
			this.setBlockTextureName(Names.Blocks.LARGE_DECANTER_INVERTED);
			return true;
		} 
		else
		{
			int meta = 0;
			world.setBlockMetadataWithNotify(x, y, z, meta, 3);
			this.setBlockTextureName(Names.Blocks.LARGE_DECANTER);
			return false;
		}
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (!world.isRemote)
		{
			isInverted(world, x, y, z);
		}
	}
	
}
