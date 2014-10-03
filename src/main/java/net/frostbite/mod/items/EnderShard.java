package net.frostbite.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostbite.mod.Frostbite;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class EnderShard extends Item {
	
	
	public EnderShard(){
		this.setCreativeTab(Frostbite.frostbiteTab);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Frostbite.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}
