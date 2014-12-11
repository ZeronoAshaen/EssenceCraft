package com.zerono.essencecraft.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.zerono.essencecraft.client.renderer.model.ModelFilterHousing;
import com.zerono.essencecraft.reference.Textures;
import com.zerono.essencecraft.tileEntity.TileEntityFilterHousing;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityRendererFilterHousing extends TileEntitySpecialRenderer
{
	private final ModelFilterHousing modelFilterHousing = new ModelFilterHousing();

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) 
	{
		if (tileEntity instanceof TileEntityFilterHousing)
		{
			TileEntityFilterHousing tileEntityFilterHousing = (TileEntityFilterHousing) tileEntity;
			ForgeDirection direction = null;
			
			if (tileEntityFilterHousing.getWorldObj() != null)
			{
				direction = tileEntityFilterHousing.getOrientation();
			}
			
			// Bind Texture
			if (tileEntityFilterHousing.getState() == 1)
			{
				this.bindTexture(Textures.Model.FILTER_HOUSING);
			}
			else
			{
				this.bindTexture(Textures.Model.FILTER_HOUSING);
			}
			
            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short angle = 0;
			
            if (direction != null)
            {
                if (direction == ForgeDirection.NORTH)
                {
                    angle = 180;
                }
                else if (direction == ForgeDirection.SOUTH)
                {
                    angle = 0;
                }
                else if (direction == ForgeDirection.WEST)
                {
                    angle = 90;
                }
                else if (direction == ForgeDirection.EAST)
                {
                    angle = -90;
                }
            }
			
            float red = 1.0F;
            float green = 1.0F;
            float blue = 1.0F;
            float alpha = 1.0F;
            
            GL11.glRotatef(angle, 0.0F, 0.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(red, green, blue, alpha);
		}
	}
}
