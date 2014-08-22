package com.zerono.essencecraft.network.message;

import com.zerono.essencecraft.tileEntity.TileEntityEC;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessageTileEntityEC implements IMessage, IMessageHandler<MessageTileEntityEC, IMessage>
{
    public int x, y, z;
    public byte orientation, state;
    public String customName, owner;

    public MessageTileEntityEC()
    {
    }

    public MessageTileEntityEC(TileEntityEC tileEntityEC)
    {
        this.x = tileEntityEC.xCoord;
        this.y = tileEntityEC.yCoord;
        this.z = tileEntityEC.zCoord;
        this.orientation = (byte) tileEntityEC.getOrientation().ordinal();
        this.state = (byte) tileEntityEC.getState();
        this.customName = tileEntityEC.getCustomName();
        this.owner = tileEntityEC.getOwner();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        int ownerLength = buf.readInt();
        this.owner = new String(buf.readBytes(ownerLength).array());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        buf.writeInt(owner.length());
        buf.writeBytes(owner.getBytes());
    }

    @Override
    public IMessage onMessage(MessageTileEntityEC message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityEC)
        {
            ((TileEntityEC) tileEntity).setOrientation(message.orientation);
            ((TileEntityEC) tileEntity).setState(message.state);
            ((TileEntityEC) tileEntity).setCustomName(message.customName);
            ((TileEntityEC) tileEntity).setOwner(message.owner);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileEntityEE - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
    }
}