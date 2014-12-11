package com.zerono.essencecraft.client.renderer.model;

import com.zerono.essencecraft.reference.Models;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly (Side.CLIENT)
public class ModelFilterHousing 
{
	private IModelCustom modelFilterHousing;
	
	public ModelFilterHousing()
	{
		modelFilterHousing = AdvancedModelLoader.loadModel(Models.FILTER_HOUSING);
	}
	
	public void render()
	{
		modelFilterHousing.renderAll();
	}
	
	public void renderPart(String partName)
	{
		modelFilterHousing.renderPart(partName);
	}
}
