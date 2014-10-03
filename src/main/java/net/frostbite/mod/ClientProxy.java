package net.frostbite.mod;

import net.frostbite.mod.Render.ItemRenderObsidianTable;
import net.frostbite.mod.Render.RenderObsidianTable;
import net.frostbite.mod.Render.RenderRunner;
import net.frostbite.mod.TileEntity.TileEntityObsidianTable;
import net.frostbite.mod.entity.EntityRunner;
import net.frostbite.mod.handler.ServerTickHandler;
import net.frostbite.mod.models.ModelRunner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends ServerProxy {
	
	public void registerRenderThings(){
		//Mobs
		 //Runner
		RenderingRegistry.registerEntityRenderingHandler(EntityRunner.class, new RenderRunner(new ModelRunner(), 0));
		
		
		
		//Blocks
		 //ObsidianTable
		TileEntitySpecialRenderer render = new RenderObsidianTable();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianTable.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Frostbite.blockObsidianTable),new ItemRenderObsidianTable(render, new TileEntityObsidianTable()));
		
		
	}
	
    public void registerTileEntitySpecialRenderer(){
		
	}
}
