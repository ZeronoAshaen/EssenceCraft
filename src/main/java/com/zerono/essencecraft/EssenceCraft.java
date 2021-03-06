package com.zerono.essencecraft;

import com.zerono.essencecraft.handlers.ConfigurationHandler;
import com.zerono.essencecraft.init.ModBlocks;
import com.zerono.essencecraft.init.ModItems;
import com.zerono.essencecraft.init.Recipes;
import com.zerono.essencecraft.init.RegOre;
import com.zerono.essencecraft.network.PacketHandler;
import com.zerono.essencecraft.proxy.IProxy;
import com.zerono.essencecraft.reference.Reference;
import com.zerono.essencecraft.utility.LogHelper;
import com.zerono.essencecraft.reference.Messages;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, certificateFingerprint = Reference.FINGERPRINT, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class EssenceCraft 
{
    
    @Mod.Instance(Reference.MOD_NAME)
    public static EssenceCraft instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
    
    @Mod.EventHandler
    public void invalidFingerprint(FMLFingerprintViolationEvent event)
    {
        // Report (log) to the user that the version of Essence Craft
        // they are using has been changed/tampered with
        if (Reference.FINGERPRINT.equals("@FINGERPRINT@"))
        {
            LogHelper.info(Messages.NO_FINGERPRINT_MESSAGE);
        }
        else
        {
            LogHelper.warn(Messages.INVALID_FINGERPRINT_MESSAGE);
        }
    }
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        PacketHandler.init();
        proxy.registerKeybindings();
        ModItems.Init();
        ModBlocks.init();
        RegOre.init();
        LogHelper.info("PreInit Complete");

    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Register the GUI Handler
    	// TODO
    	// Initialize Tile Entities
    	// TODO
    	// Initialize custom rendering and pre-load textures (Client only)
    	proxy.initRenderingAndTextures();
    	// Register the Items Event Handler
    	proxy.registerEventHandlers();
    	
        Recipes.Init();
        // Register the Waila data provider
        // TODO
        
        LogHelper.info("Init Complete");
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Register recipes
    	
    	
    	LogHelper.info("postInit Complete");
    }
    
}
