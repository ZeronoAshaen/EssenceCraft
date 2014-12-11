package com.zerono.essencecraft.reference;

import net.minecraft.util.ResourceLocation;

import com.zerono.essencecraft.utility.ResourceLocationHelper;

public final class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";
    
    public static final class Model
    {
    	private static final String MODEL_TEXTURE_LOCATION = "textures/models/";
    	public static final ResourceLocation FILTER_HOUSING = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "filterHousing.png");
    }
    
    public static final class Gui
    {
        private static final String GUI_SHEET_LOCATION = "textures/gui/";

    }
}
