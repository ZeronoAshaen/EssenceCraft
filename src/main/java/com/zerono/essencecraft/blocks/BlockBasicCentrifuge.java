package com.zerono.essencecraft.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zerono.essencecraft.createiveTab.CreativeTabEC;
import com.zerono.essencecraft.reference.Names;

public class BlockBasicCentrifuge extends BlockEC 
{
    public BlockBasicCentrifuge()
    {
        super(Material.anvil);
        this.setHardness(2.5f);
        this.setBlockName(Names.Blocks.BASIC_CENTRIFUGE);
        this.setBlockTextureName(Names.Blocks.BASIC_CENTRIFUGE);
        this.setCreativeTab(CreativeTabEC.EC_NONBLOCKS_TAB);
    }
}
