package com.zerono.essencecraft.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zerono.essencecraft.reference.Names;
import com.zerono.essencecraft.tileEntity.TileEntityBasicEssenceExtractor;

public class BlockBasicEssenceExtractor extends BlockEC implements ITileEntityProvider
{
    public BlockBasicEssenceExtractor()
    {
        super(Material.anvil);
        this.setHardness(2.5f);
        this.setBlockName(Names.Machines.ESSENCE_EXTRACTOR);
        this.setBlockTextureName(Names.Machines.ESSENCE_EXTRACTOR);
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityBasicEssenceExtractor();
    }
}
