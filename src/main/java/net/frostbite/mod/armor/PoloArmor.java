package net.frostbite.mod.armor;

import java.util.Stack;

import net.frostbite.mod.Frostbite;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PoloArmor extends ItemArmor {
	
	public PoloArmor(ArmorMaterial p_145325_1_, int p_i45325_2_,
			int p_i45325_3_) {
		super(p_145325_1_, p_i45325_2_, p_i45325_3_);
		this.setCreativeTab(Frostbite.frostbiteTab);
	}
                   
   



	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
    	if(stack.getItem() == Frostbite.PoloHelmet || stack.getItem() == Frostbite.PoloChest || stack.getItem() == Frostbite.PoloBoots){
    	        return Frostbite.modid + ":textures/model/armor/Poloarmor_Layer_1.png";
    	}        
    	if(stack.getItem() == Frostbite.PoloLegs){
    		    return Frostbite.modid + ":textures/model/armor/Poloarmor_Layer_2.png";
    	}
    	else return null ;
    	
    	
    	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if(stack.getItem() == Frostbite.PoloBoots){
				int j = EnchantmentHelper.getEnchantmentLevel(Frostbite.speedBoost.effectId, stack);
				if (j > 0){
					player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 50, j -1));
				}
		}
	}
}
				
    

    