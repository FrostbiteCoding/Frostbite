package net.frostbite.mod.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostbite.mod.Frostbite;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;


public class EnderOre extends Block {
	
	public EnderOre(Material material){
		super(material);
		
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(Frostbite.frostbiteTab);
	
	}
	
	public Item getItemDropped(int i, Random random, int j){
		return this == Frostbite.orePoloriteOre ? Frostbite.itemPoloriteIngot : Item.getItemFromBlock(this);
	}
    
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Frostbite.modid + ":" + this.getUnlocalizedName().substring(5));
	}

	
	
}

