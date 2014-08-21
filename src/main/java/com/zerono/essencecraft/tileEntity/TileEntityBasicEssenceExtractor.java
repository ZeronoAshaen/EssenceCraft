package com.zerono.essencecraft.tileEntity;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityBasicEssenceExtractor extends TileEntityEC implements ISidedInventory
{
    public static final int INVENTORY_SIZE = 4;
    public static final int FUEL_INVENTORY_INDEX = 0;
    public static final int INVENTORY_TOP = 1;
    public static final int INVENTORY_LEFT = 2;
    public static final int INVENTORY_RIGHT = 3;
    
    public int deviceSpingTime; // How much longer the extractor will spin
    public int fuelBurnTime;    // The fuel value for the currently burning fuel
    public int itemSpinTime;    // How long the current item has been "spinning"
    
    public ItemStack outputItemStack;
    
    private ItemStack[] inventory;
    
    public TileEntityBasicEssenceExtractor()
    {
        inventory = new ItemStack[INVENTORY_SIZE];
    }
    
    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return side == ForgeDirection.DOWN.ordinal() ? new int[]{FUEL_INVENTORY_INDEX} : new int[]{INVENTORY_TOP, INVENTORY_RIGHT, INVENTORY_LEFT};
    }
    
    @Override
    public boolean canInsertItem(int slotIndex, ItemStack itemStack, int side)
    {
        
    }
}
