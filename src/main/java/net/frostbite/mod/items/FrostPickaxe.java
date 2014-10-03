package net.frostbite.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostbite.mod.Frostbite;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;


public class FrostPickaxe extends ItemPickaxe {


	public FrostPickaxe(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setCreativeTab(Frostbite.frostbiteTab);
		this.maxStackSize = 1;
		
	}
		
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Frostbite.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}


