package com.zerono.essencecraft.blocks;

import com.zerono.essencecraft.createiveTab.CreativeTabEC;
import com.zerono.essencecraft.reference.Names;

public class BlockInertStone extends BlockEC
{
    public BlockInertStone()
    {
        super();
        this.setBlockName(Names.Blocks.INERT_STONE);
        this.setBlockTextureName(Names.Blocks.INERT_STONE);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
    }
}
