package com.zerono.essencecraft.handlers;

import java.io.File;

import com.zerono.essencecraft.reference.Reference;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean testValue = false;
    
    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            loadConfiguration();
            configuration = new Configuration(configFile);
        }
        
        try
        {
            // Load the configuration file
            configuration.load();
            
            // Read in properties from Configuration file
            boolean configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config value").getBoolean(true);
        }
        catch (Exception e)
        {
            // Log the exception
        }
        finally
        {
            // Save the configuration file
            if (configuration.hasChanged())
            {
                configuration.save();
            }
        }
    }
    
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
            
        }
    }
    
    private static void loadConfiguration()
    {
        testValue = configuration.getBoolean("configValue",  Configuration.CATEGORY_GENERAL, false,  "This is an example configuration value");
        
        if (configuration.hasChanged());
        {
            configuration.save();
        }
    }
}
