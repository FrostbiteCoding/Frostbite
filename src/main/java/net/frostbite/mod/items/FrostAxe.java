package net.frostbite.mod.items;

import java.util.Set;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostbite.mod.Frostbite;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;


public class FrostAxe extends ItemAxe {


	public FrostAxe(float p_i45333_1_, ToolMaterial p_i45333_2_,
			Set p_i45333_3_) {
		super(p_i45333_2_);
		this.setCreativeTab(Frostbite.frostbiteTab);
		
	}
		
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Frostbite.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}


