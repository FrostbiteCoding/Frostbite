package net.frostbite.mod.worldgen;

import java.util.Random;

import net.frostbite.mod.Frostbite;
import net.frostbite.mod.worldgen.features.StructureWell;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class FrostbiteWorldGen implements IWorldGenerator {
    
	private static final Block block = null;
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case 0 :
			//Generate our surface world
			generateSurface(world, random, chunkX*16, chunkZ*16);
			
		case -1 :
			//Generate our surface world
			generateNether(world, random, chunkX*16, chunkZ*16);
			
		case 1 :
			//Generate our surface world
			generateEnd(world, random, chunkX*16, chunkZ*16);	
		}
		
		
	}
	private void generateSurface(World world, Random random, int x, int z) {
		
		//Ores
		//this.addOreSpawn(Frostbite.orewhatever, world,random,i=blockXPos, j=blockZPos, maxX   MaxZ MaxVeinsize,chanceofspawn, minY, maxY);
	    this.addOreSpawn(Frostbite.oreFrostOre, world, random, x, z, 16, 16, 2+random.nextInt(4), 20, 38, 100);
	    this.addOreSpawn(Frostbite.orePoloriteOre, world, random, x, z, 16, 16, 2+random.nextInt(4), 15, 38, 100);
	    this.addOreSpawn(Frostbite.orePeridotOre, world, random, x, z, 16, 16, 2 + random.nextInt(4), 10, 38, 100);
	    
	    
	    //Structures
	   BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
	   
	   
	   if ((biome == BiomeGenBase.forest)){
		   for (int a =0; a < 1; a++){
			   int i = x = random.nextInt(256);
			   int j = z = random.nextInt(256);
			   int k = world.getHeightValue(i, j);
			   new StructureWell().generate(world, random, i, j, k);
		   }
	   }
	
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		// TODO Auto-generated method stub
	    
		
	}
	private void generateEnd(World world, Random random, int x, int z) {
		// TODO Auto-generated method stub
		this.addEndOreSpawn(Frostbite.EnderOre, world, random, x, z, 16, 16, 2 + random.nextInt(4), 55, 1, 100);
	
		
	}
	private void addOreSpawn(Block block, World world, Random random,int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
		for(int i = 0; i < chanceToSpawn; i++){
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
		
		
		private void addEndOreSpawn(Block block, World world, Random random,int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
			for(int i = 0; i < chanceToSpawn; i++){
				int posX = blockXPos + random.nextInt(maxX);
				int posY = minY + random.nextInt(maxY - minY);
				int posZ = blockZPos + random.nextInt(maxZ);
				(new WorldGenEndMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
			}
			
		
		
		
		
		
		
		
		
		}
		
  }
	
	



