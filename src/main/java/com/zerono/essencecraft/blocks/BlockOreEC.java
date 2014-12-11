package com.zerono.essencecraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;

import com.zerono.essencecraft.init.ModBlocks;
import com.zerono.essencecraft.init.ModItems;
import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.reference.Reference;
import com.zerono.essencecraft.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOreEC extends BlockEC
{
	@SideOnly(Side.CLIENT)
	private IIcon[] blockTop, blockSide;

	public BlockOreEC()
	{
		super();
		this.setBlockName(Names.Blocks.ORE);
		this.setStepSound(soundTypePiston);	
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(1.5F);
		this.setResistance(0.5F);
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return meta == 0 ? ModItems.saltPile : Item.getItemFromBlock(this);
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random rand)
	{
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, rand, fortune))
		{
			int j = rand.nextInt(fortune + 2) - 1;
			if (j < 0)
			{
				j = 0;
			}
			return this.quantityDropped(rand) * (j+1);
		}
		else
		{
			return this.quantityDropped(rand);
		}
	}
	
	@Override
	public int damageDropped (int meta)
	{
		return meta;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int meta = 0; meta < Names.Blocks.ORE_SUBYTPES.length; meta++)
		{
			list.add(new ItemStack(item, 1, meta));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockTop = new IIcon[Names.Blocks.ORE_SUBYTPES.length];
		this.blockSide = new IIcon[Names.Blocks.ORE_SUBYTPES.length];
		for (int i=0; i < Names.Blocks.ORE_SUBYTPES.length; i++)
		{
			blockTop[i] = iconRegister.registerIcon(String.format("%s.%s_top", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), Names.Blocks.ORE_SUBYTPES[i]));
			blockSide[i] = iconRegister.registerIcon(String.format("%s.%s_side", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), Names.Blocks.ORE_SUBYTPES[i]));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		meta = MathHelper.clamp_int(meta, 0, Names.Blocks.ORE_SUBYTPES.length);
		
		if (ForgeDirection.getOrientation(side) == ForgeDirection.UP || ForgeDirection.getOrientation(side) == ForgeDirection.DOWN)
		{
			return blockTop[meta];
		}
		else
		{
			return blockSide[meta];
		}
	}
	
}
