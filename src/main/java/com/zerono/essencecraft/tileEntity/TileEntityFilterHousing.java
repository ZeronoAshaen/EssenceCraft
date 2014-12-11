package com.zerono.essencecraft.tileEntity;

import com.zerono.essencecraft.init.ModBlocks;
import com.zerono.essencecraft.items.ItemFilterBasic;
import com.zerono.essencecraft.items.ItemFilterCoal;
import com.zerono.essencecraft.items.ItemFilterFine;
import com.zerono.essencecraft.items.ItemFilterFrame;
import com.zerono.essencecraft.items.ItemFilterSturdy;
import com.zerono.essencecraft.items.ItemSaltPile;
import com.zerono.essencecraft.reference.Names;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityFilterHousing extends TileEntityEC implements ISidedInventory
{
	// Calculated in miliBuckets
	public static final int INPUT_TANK_SIZE = 2000;
	public static final int OUTPUT_TANK_SIZE = 2000;
	
	public static final int INVENTORY_SIZE = 6;
	public static final int FILTER_INVENTORY_INDEX = 0;
	public static final int INPUT_TANK_INPUT_INDEX = 1;
	public static final int INPUT_TANK_OUTPUT_INDEX = 2;
	public static final int OUTPUT_TANK_INPUT_INDEX = 3;
	public static final int OUTPUT_TANK_OUTPUT_INDEX = 4;
	public static final int SALT_INVENTORY_INDEX = 5;
	
	public int BASE_DRIP_TIME; // How long it takes to make a base solution
	public int FILTER_MODIFIER; // Modifier for which filter is being used
	public int DRIP_TIME = (BASE_DRIP_TIME * FILTER_MODIFIER);
	
	public int numUsingPlayers;
	
	public ItemStack outputItemStack;
	private ItemStack[] inventory;
	
	public TileEntityFilterHousing()
	{
		inventory = new ItemStack[INVENTORY_SIZE];
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		
		NBTTagList tagList = nbtTagCompound.getTagList(Names.NBT.ITEMS, 10);
		inventory = new ItemStack[this.getSizeInventory()];
		for (int i=0; i < tagList.tagCount(); ++i)
		{
			NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
			byte slotIndex = tagCompound.getByte("Slot");
			if (slotIndex >= 0 && slotIndex < inventory.length)
			{
				inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}
		
	}
	
	@Override
	public int getSizeInventory() 
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotIndex) 
	{
		return inventory[slotIndex];
	}
	
	@Override
	public ItemStack decrStackSize(int slotIndex, int decrementAmount) 
	{
		ItemStack itemStack = getStackInSlot(slotIndex);
		if (itemStack !=null)
		{
			if (itemStack.stackSize <= decrementAmount)
			{
				setInventorySlotContents(slotIndex, null);
			} else {
				itemStack = itemStack.splitStack(decrementAmount);
				if (itemStack.stackSize == 0)
				{
					setInventorySlotContents(slotIndex, null);
				}
			}
		}
		return itemStack;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) 
	{
		if (inventory[slotIndex] != null)
		{
			ItemStack itemStack = inventory[slotIndex];
			inventory[slotIndex] = null;
			return itemStack;
		} else {
			return null;
		}
	}
	
	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemStack) 
	{
		inventory[slotIndex] = itemStack;
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
		{
			itemStack.stackSize = getInventoryStackLimit();
		}
	}
	
	@Override
	public String getInventoryName() 
	{
		return this.hasCustomName() ? this.getCustomName() : Names.Blocks.DRIP_FILTER;
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return this.hasCustomName();
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) 
	{
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityPlayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	
	@Override
	public void openInventory() 
	{
		++numUsingPlayers;
		worldObj.addBlockEvent(xCoord, yCoord, zCoord, ModBlocks.filterHousing, 1, numUsingPlayers);
	}

	@Override
	public void closeInventory() 
	{
		--numUsingPlayers;
		worldObj.addBlockEvent(xCoord, yCoord, zCoord, ModBlocks.filterHousing, 1, numUsingPlayers);
	}
	
	@Override
	public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack)
	{
		switch (slotIndex)
		{
			case FILTER_INVENTORY_INDEX:
			{
				return itemStack.getItem() instanceof ItemFilterBasic || itemStack.getItem() instanceof ItemFilterFine || itemStack.getItem() instanceof ItemFilterCoal || itemStack.getItem() instanceof ItemFilterSturdy;
			}
			case SALT_INVENTORY_INDEX:
			{
				return itemStack.getItem() instanceof ItemSaltPile;
			}
			case INPUT_TANK_INPUT_INDEX:
			{
				return itemStack.getItem() instanceof ItemBucket;
			}
			case OUTPUT_TANK_OUTPUT_INDEX:
			{
				return itemStack.getItem() instanceof ItemBucket;
			}
			default:
			{
				return false;
			}
		}
	}
	
	@Override
	public boolean canInsertItem(int slotIndex, ItemStack itemStack, int side) {
		return isItemValidForSlot(slotIndex, itemStack);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		
		// Write the ItemStacks in the inventory to NBT
		NBTTagList tagList = new NBTTagList();
		for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex)
		{
			if (inventory[currentIndex] != null)
			{
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte) currentIndex);
				inventory[currentIndex].writeToNBT(tagCompound);
				tagList.appendTag(tagCompound);
			}
		}
		nbtTagCompound.setTag(Names.NBT.ITEMS, tagList);
	}
	
	@Override
	public boolean receiveClientEvent(int eventID, int numUsingPlayers)
	{
		if (eventID == 1)
		{
			this.numUsingPlayers = numUsingPlayers;
			return true;
		} else {
			return super.receiveClientEvent(eventID, numUsingPlayers);
		}
	}
	
	@Override
	public void updateEntity()
	{
		if (inventory[FILTER_INVENTORY_INDEX].getItem() instanceof ItemFilterBasic || inventory[FILTER_INVENTORY_INDEX].getItem() instanceof ItemFilterFine || inventory[FILTER_INVENTORY_INDEX].getItem() instanceof ItemFilterCoal || inventory[FILTER_INVENTORY_INDEX].getItem() instanceof ItemFilterSturdy)
		{
			if (DRIP_TIME == 0 && !worldObj.isRemote)
			{
				// Appropriate solution in output
				if (inventory[FILTER_INVENTORY_INDEX].getItemDamage() > 1)
				{
					if (inventory[FILTER_INVENTORY_INDEX].getItemDamage() > 2)
					{
						inventory[FILTER_INVENTORY_INDEX].setItemDamage(inventory[FILTER_INVENTORY_INDEX].getItemDamage() - 1);
					}
					else
					{
						
					}
				}
			}
			DRIP_TIME--;
		}
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) 
	{
		if (side == ForgeDirection.DOWN.ordinal())
		{
			return null;
		}
		else if (side == ForgeDirection.UP.ordinal())
		{
			return null;
		}
		else
		{
			return new int[]{FILTER_INVENTORY_INDEX, INPUT_TANK_INPUT_INDEX, INPUT_TANK_OUTPUT_INDEX, OUTPUT_TANK_INPUT_INDEX, OUTPUT_TANK_OUTPUT_INDEX, SALT_INVENTORY_INDEX};
		}
	}

	@Override
	public boolean canExtractItem(int slotIndex, ItemStack itemStack, int side) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}
