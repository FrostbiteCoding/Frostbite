package net.frostbite.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostbite.mod.Frostbite;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;


public class FrostBlock extends Block {
	
	public FrostBlock(Material material){
		super(material);
		
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.slipperiness = 0.98F;
		this.setCreativeTab(Frostbite.frostbiteTab);
	}
    
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Frostbite.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	
}