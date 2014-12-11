package com.zerono.essencecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.zerono.essencecraft.tileEntity.TileEntityDripFilter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerDripFilter extends ContainerEC
{
	private TileEntityDripFilter tileEntityDripFilter;
	private int lastDripTime; 			// How much longer the Filter will "filter"
	private int lastSolutionDripTime; 	// How long the current liquid has been "filtering"
	private int INPUT_X_POSITION = 10;
	private int INPUT_Y_POSITION = 1;
	private int SALT_X_POSITION = 5;
	private int SALT_Y_POSITION = 10;
	private int FILTER_X_POSITION = 10;
	private int FILTER_Y_POSITION = 10;
	private int OUTPUT_X_POSITION = 10;
	private int OUTPUT_Y_POSITION = 20;
	
	public ContainerDripFilter(InventoryPlayer inventoryPlayer, TileEntityDripFilter tileEntityDripFilter)
	{
		this.tileEntityDripFilter = tileEntityDripFilter;
		
		// Add Input Slot to the container
		this.addSlotToContainer(new Slot(tileEntityDripFilter, TileEntityDripFilter.INPUT_INVENTORY_INDEX, this.INPUT_X_POSITION, this.INPUT_Y_POSITION));

		// Add the salt slot to the container
		this.addSlotToContainer(new Slot(tileEntityDripFilter, TileEntityDripFilter.SALT_INVENTORY_INDEX, this.SALT_X_POSITION, this.SALT_Y_POSITION));
		
		// Add the filter slot to the container
		this.addSlotToContainer(new Slot(tileEntityDripFilter, TileEntityDripFilter.FILTER_INVENTORY_INDEX, this.FILTER_X_POSITION, this.FILTER_Y_POSITION));
		
		// Add Output Slot to the Container
		this.addSlotToContainer(new Slot(tileEntityDripFilter, TileEntityDripFilter.OUTPUT_INVENTORY_INDEX, this.OUTPUT_X_POSITION, this.OUTPUT_Y_POSITION));
		
        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex)
        {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 94 + inventoryRowIndex * 18));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 152));
        }
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting iCrafting)
	{
		super.addCraftingToCrafters(iCrafting);
		iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityDripFilter.deviceDripTime);
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
	{
		ItemStack itemStack = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack slotItemStack = slot.getStack();
			itemStack = slotItemStack.copy();
			
			if (slotIndex < TileEntityDripFilter.INVENTORY_SIZE)
			{
				if (!this.mergeItemStack(slotItemStack, TileEntityDripFilter.INVENTORY_SIZE, inventorySlots.size(), false))
				{
					return null;
				}
			} 
			else 
			{
				if (!this.mergeItemStack(slotItemStack, TileEntityDripFilter.INPUT_INVENTORY_INDEX, TileEntityDripFilter.OUTPUT_INVENTORY_INDEX, false))
				{
					return null;
				}
			}
			
			if (slotItemStack.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}
		}
		return itemStack;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int valueType, int updatedValue)
	{
		if (valueType == 0)
		{
			this.tileEntityDripFilter.deviceDripTime = updatedValue;
		}
	}
	
}
