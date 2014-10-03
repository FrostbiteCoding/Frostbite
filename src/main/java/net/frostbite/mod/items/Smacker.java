package net.frostbite.mod.items;

import com.sun.org.omg.CORBA.Initializer;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostbite.mod.Frostbite;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;

public class Smacker extends ItemSword {
	
	
	private EntityLivingBase entityplayer;
	public Smacker(ToolMaterial ironGolemMaterial){
		super(ironGolemMaterial);
		setMaxStackSize(1);
		setCreativeTab(Frostbite.frostbiteTab);
		setMaxDamage(15);
		setNoRepair();
		
		
		
	
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Frostbite.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target){
		double calculatedX = -1 * (double)(-MathHelper.sin(target.rotationYaw/ 180.0F * (float) Math.PI)* MathHelper.cos(target.rotationPitch / 180.0F* (float)Math.PI * 1.4F));
		double calculatedZ = 1 * (double)(MathHelper.cos(target.rotationYaw/ 180.0F * (float) Math.PI)* MathHelper.cos(target.rotationPitch / 180.0F* (float)Math.PI * 1.4F));
		double calculatedY = 1 * (double)(-MathHelper.sin((target.rotationPitch)/ 180.0F * (float) Math.PI) * 1.0F);
	
		target.motionX = 0;
		target.motionY = 2;
		target.motionZ = 0;
		
		itemstack.damageItem(1, player);
		
		
		
		return false;
    }
	
}


