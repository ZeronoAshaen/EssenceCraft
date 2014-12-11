package com.zerono.essencecraft.blocks;

import com.zerono.essencecraft.createiveTab.CreativeTabEC;
import com.zerono.essencecraft.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockEC  extends Block
{
    public BlockEC()
    {
        this(Material.rock);
        this.setCreativeTab(CreativeTabEC.EC_BLOCKS_TAB);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
    }
    
    public BlockEC(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabEC.EC_BLOCKS_TAB);
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s",  getUnwrappedUnlocalizedName(super.getUnlocalizedName())));
    }
    
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
