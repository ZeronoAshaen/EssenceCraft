package com.zerono.essencecraft.network;

import com.zerono.essencecraft.network.message.MessageTileEntityEC;
import com.zerono.essencecraft.reference.Reference;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileEntityEC.class, MessageTileEntityEC.class, 0, Side.CLIENT);
    }
}
