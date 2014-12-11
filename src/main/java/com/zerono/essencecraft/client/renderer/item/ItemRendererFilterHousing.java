package com.zerono.essencecraft.client.renderer.item;

import org.lwjgl.opengl.GL11;

import com.zerono.essencecraft.client.renderer.model.ModelFilterHousing;
import com.zerono.essencecraft.reference.Textures;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRendererFilterHousing implements IItemRenderer
{
	private final ModelFilterHousing modelFilterHousing;
	
	public ItemRendererFilterHousing()
	{
		modelFilterHousing = new ModelFilterHousing();
	}
	
	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType)
	{
		return true;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRenderHelper)
	{
		return true;
	}
	
    @Override
    public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data)
    {
        switch (itemRenderType)
        {
            case ENTITY:
            {
                renderFilterHousing(-0.5F, 0.0F, 0.5F);
                return;
            }
            case EQUIPPED:
            {
            	renderFilterHousing(0.0F, 0.0F, 1.0F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
            	renderFilterHousing(0.0F, 0.0F, 1.0F);
                return;
            }
            case INVENTORY:
            {
            	renderFilterHousing(0.0F, -0.1F, 1.0F);
                return;
            }
            default:
            {
            }
        }
    }
	
    private void renderFilterHousing(float x, float y, float z)
    {
        GL11.glPushMatrix();

        // Scale, Translate, Rotate
        GL11.glScalef(1F, 1F, 1F);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(-90F, 1F, 0, 0);

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.FILTER_HOUSING);

        // Render
        modelFilterHousing.renderPart("filterHousing");

        GL11.glPopMatrix();
    }
    
}
