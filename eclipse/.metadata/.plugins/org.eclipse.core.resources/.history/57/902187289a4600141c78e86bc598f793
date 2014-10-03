package com.cyborgJenn.terraDimensions.handlers;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import com.cyborgJenn.terraDimensions.Items.ItemBucketMercury;
import com.cyborgJenn.terraDimensions.Items.ItemBucketTerraLava;
import com.cyborgJenn.terraDimensions.fluids.BlockFluidMercury;
import com.cyborgJenn.terraDimensions.fluids.BlockFluidTerraLava;

import cpw.mods.fml.common.registry.GameRegistry;

public class TerraFluidsHandler {
	
	public static Block blockFluidMercury;
	public static Block blockFluidTerraLava;
	
	public static Fluid fluidMercury;
	public static Fluid fluidTerraLava;
	
	public static Material materialFluidMercury;
	public static Material materialFluidTerraLava;
	
	public static Item itemBucketMercury;
	public static Item itemBucketTerraLava;
	
	public static void addFluids(){
		
		fluidMercury = new Fluid("fluidMercury").setViscosity(3000).setDensity(2000);
		FluidRegistry.registerFluid(fluidMercury);
		materialFluidMercury = new MaterialLiquid(MapColor.silverColor);
		blockFluidMercury = new BlockFluidMercury(fluidMercury, Material.water);
		GameRegistry.registerBlock(blockFluidMercury, "fluidMercury");
		fluidMercury.setUnlocalizedName(blockFluidMercury.getUnlocalizedName());
		
		fluidTerraLava = new Fluid("fluidTerraLava").setViscosity(3000).setLuminosity(15).setDensity(3000);
		FluidRegistry.registerFluid(fluidTerraLava);
		materialFluidTerraLava = new MaterialLiquid(MapColor.blueColor);
		blockFluidTerraLava = new BlockFluidTerraLava(fluidTerraLava, Material.lava);
		GameRegistry.registerBlock(blockFluidTerraLava, "fluidTerraLava");
		fluidTerraLava.setUnlocalizedName(blockFluidTerraLava.getUnlocalizedName());	
		
		/* buckets */
		itemBucketMercury = new ItemBucketMercury(blockFluidMercury);
		itemBucketMercury.setUnlocalizedName("itemBucketMercury").setContainerItem(Items.bucket);
		GameRegistry.registerItem(itemBucketMercury, "itemBucketMercury");
		
		itemBucketTerraLava = new ItemBucketTerraLava(blockFluidTerraLava);
		itemBucketTerraLava.setUnlocalizedName("itemBucketTerraLava").setContainerItem(Items.bucket);
        GameRegistry.registerItem(itemBucketTerraLava, "itemBucketTerraLava");

        TerraEventHandler.INSTANCE.buckets.put(blockFluidTerraLava, itemBucketTerraLava);
        TerraEventHandler.INSTANCE.buckets.put(blockFluidMercury, itemBucketMercury);
		MinecraftForge.EVENT_BUS.register(TerraEventHandler.INSTANCE);
	}
	
	public static void registerFluidContainers(){
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("fluidMercury", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(itemBucketMercury), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("fluidTerraLava", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(itemBucketTerraLava), new ItemStack(Items.bucket));
        // TODO Fix Buckets
	}
	
}
