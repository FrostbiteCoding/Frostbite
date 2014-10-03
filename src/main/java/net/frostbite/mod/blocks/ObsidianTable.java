package net.frostbite.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostbite.mod.Frostbite;
import net.frostbite.mod.TileEntity.TileEntityObsidianTable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ObsidianTable extends  BlockContainer{

	public ObsidianTable(Material material) {
		super(material);
		this.setHardness(0.1F);
		this.setResistance(5.0F);
		this.setBlockBounds(0f, 0f, 0f, 1F, 0.75F, 1F);
		this.setCreativeTab(Frostbite.frostbiteTab);
	}
	
	public int getRenderType() {
		return -1;
		
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityObsidianTable();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Frostbite.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}