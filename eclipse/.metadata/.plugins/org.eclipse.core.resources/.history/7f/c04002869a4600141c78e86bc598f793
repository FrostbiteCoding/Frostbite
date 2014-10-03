package com.cyborgJenn.terraDimensions.Items;

import com.cyborgJenn.terraDimensions.TerraDimensions;
import com.cyborgJenn.terraDimensions.blocks.ModBlocks;
import com.cyborgJenn.terraDimensions.utils.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGalifreyPortalKey extends Item{
	public ItemGalifreyPortalKey(int par1) {
        super();
        maxStackSize = 1;
        this.setMaxDamage(64);
        this.setCreativeTab(TerraDimensions.tabTerraDimensions);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(Reference.TEXTURE
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer,
            World par3World, int par4, int par5, int par6, int par7, float par8, float par9,
            float par10) {
        Block blockID = par3World.getBlock(par4, par5, par6);
        if (blockID == ModBlocks.gateGalifrey){
            ModBlocks.galifreyPortal.func_150000_e(par3World, par4, par5 + 1, par6);
        }
        return true;

    }
}
