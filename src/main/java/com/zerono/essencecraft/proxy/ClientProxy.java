package com.zerono.essencecraft.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.zerono.essencecraft.client.renderer.*;
import com.zerono.essencecraft.client.renderer.item.ItemRendererFilterHousing;
import com.zerono.essencecraft.init.ModBlocks;
import com.zerono.essencecraft.reference.RenderIds;
import com.zerono.essencecraft.tileEntity.TileEntityFilterHousing;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy
{
	@Override
	public void registerEventHandlers()
	{
		
	}
	
	@Override
	public void registerKeybindings()
	{
		
	}
	
	@Override
    public void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch)
    {
		
    }
	
	@Override
	public ClientProxy getClientProxy()
	{
		return this;
	}
	
	@Override
	public void initRenderingAndTextures()
	{
		RenderIds.filterHousing = RenderingRegistry.getNextAvailableRenderId();
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.filterHousing), new ItemRendererFilterHousing());
		
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilterHousing.class, new TileEntityFilterHousing());
	}
}
