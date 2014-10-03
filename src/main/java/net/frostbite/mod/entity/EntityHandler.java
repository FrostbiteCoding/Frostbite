package net.frostbite.mod.entity;

import java.util.Random;

import net.frostbite.mod.Frostbite;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {
	

	public static void registerMonsters(Class entityClass, String name){
		createEntity(EntityRunner.class, "Runner", 0x00008B, 0xF6F314);
		
		
		
		
	}
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor){
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.addSpawn(entityClass, 150, 2, 4, EnumCreatureType.monster, BiomeGenBase.birchForest, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.plains, BiomeGenBase.roofedForest);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, Frostbite.modInstance, 64, 1, true);
		createEgg(randomId, solidColor, spotColor);
	}

	private static void createEgg(int randomId, int solidColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
		
	}

}
