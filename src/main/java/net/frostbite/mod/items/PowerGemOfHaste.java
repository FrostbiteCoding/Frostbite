package net.frostbite.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostbite.mod.Frostbite;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PowerGemOfHaste
  extends Item
{
  public PowerGemOfHaste()
  {
    setMaxStackSize(64);
    setCreativeTab(Frostbite.frostbiteTab);
    
  }
  
  @SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Frostbite.modid + ":" + this.getUnlocalizedName().substring(5));
	}
  public boolean func_77636_d(ItemStack par1ItemStack)
  {
    return true;
  }
  
  @SideOnly(Side.CLIENT)
  public EnumRarity func_77613_e(ItemStack par1ItemStack)
  {
    return EnumRarity.rare;
  }
}
