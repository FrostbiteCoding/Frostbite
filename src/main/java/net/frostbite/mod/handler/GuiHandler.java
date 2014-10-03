package net.frostbite.mod.handler;

import net.frostbite.mod.Frostbite;
import net.frostbite.mod.TileEntity.TileEntityAlabasterOven;
import net.frostbite.mod.container.ContainerAlabasterOven;
import net.frostbite.mod.container.ContainerWorkSurface;
import net.frostbite.mod.gui.GuiAlabasterOven;
import net.frostbite.mod.gui.GuiWorkSurface;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case Frostbite.guiIDAlabasterOven:
				if (entity instanceof TileEntityAlabasterOven) {
					return new ContainerAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
				}
				return null;
				
			}
		}
		
		if(ID == Frostbite.guiIDWorkSurface) {
			return ID == Frostbite.guiIDWorkSurface && world.getBlock(x, y, z) == Frostbite.blockWorkSurface ? new ContainerWorkSurface(player.inventory, world, x, y, z) : null;
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case Frostbite.guiIDAlabasterOven:
				if (entity instanceof TileEntityAlabasterOven) {
					return new GuiAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
				}
				return null;
		
			}
		}
		
		if(ID == Frostbite.guiIDWorkSurface) {
			return ID == Frostbite.guiIDWorkSurface && world.getBlock(x, y, z) == Frostbite.blockWorkSurface ? new GuiWorkSurface(player.inventory, world, x, y, z) : null;
		}
		
		return null;
	}

}
