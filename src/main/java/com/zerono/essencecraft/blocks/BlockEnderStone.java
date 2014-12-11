package com.zerono.essencecraft.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import com.zerono.essencecraft.reference.Names;

public class BlockEnderStone extends BlockEC
{
	public BlockEnderStone()
	{
        super();
        this.setBlockName(Names.Blocks.INERT_STONE);
        this.setBlockTextureName(Names.Blocks.INERT_STONE);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z))
		{
			int powerLevel = world.getBlockPowerInput(x, y, z);
			// Make entity "jump" x amount in facing direction based upon powerLevel
			// moveEntity in Entity class
			entity.moveEntity(x, y, z); entity.getLookVec();
		}
	}
	
	
	
}
