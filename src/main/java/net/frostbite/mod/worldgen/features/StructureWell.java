package net.frostbite.mod.worldgen.features;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureWell extends WorldGenerator
{
	protected Block[] GetValidSpawnBlocks()
	{
		return new Block[]
		{
			Blocks.grass,
			Blocks.stone,
		};
	}

	public boolean LocationIsValidSpawn(World world, int x, int y, int z)
	{
		int distanceToAir = 0;
		Block checkBlock = world.getBlock(x, y, z);

		while (checkBlock != Blocks.air)
		{
			distanceToAir++;
			checkBlock = world.getBlock(x, y + distanceToAir, z);
		}

		if (distanceToAir > 1)
		{
			return false;
		}

		y += distanceToAir - 1;

		Block block = world.getBlock(x, y, z);
		Block blockAbove = world.getBlock(x, y + 1, z);
		Block blockBelow = world.getBlock(x, y - 1, z);

		for (Block i : GetValidSpawnBlocks())
		{
			if (blockAbove != Blocks.air)
			{
				return false;
			}
			if (block == i)
			{
				return true;
			}
			else if (block == Blocks.snow_layer && blockBelow == i)
			{
				return true;
			}
			else if (block.getMaterial() == Material.plants && blockBelow == i)
			{
				return true;
			}
		}
		return false;
	}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		int i = rand.nextInt(1);

		if(i == 0)
		{
		    generate_r0(world, rand, x, y, z);
		}

       return true;

	}

	public boolean generate_r0(World world, Random rand, int x, int y, int z)
	{
		if(!LocationIsValidSpawn(world, x, y, z) || !LocationIsValidSpawn(world, x + 2, y, z) || !LocationIsValidSpawn(world, x + 2, y, z + 3) || !LocationIsValidSpawn(world, x, y, z + 3))
		{
			return false;
		}

		world.setBlock(x + 0, y + 0, z + 0, Blocks.sand, 0, 3);
		world.setBlock(x + 1, y + 0, z + 0, Blocks.sand, 0, 3);
		world.setBlock(x + 2, y + 0, z + 0, Blocks.sand, 0, 3);
		world.setBlock(x + 0, y + 0, z + 1, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 1, y + 0, z + 1, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 2, y + 0, z + 1, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 0, y + 0, z + 2, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 1, y + 0, z + 2, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 2, y + 0, z + 2, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 1, y + 0, z + 3, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 0, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 1, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 0, y + 1, z + 2, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 1, y + 1, z + 2, Blocks.water, 0, 3);
		world.setBlock(x + 2, y + 1, z + 2, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 0, y + 1, z + 3, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 2, y + 1, z + 3, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 0, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 1, Blocks.fence, 0, 3);
		world.setBlock(x + 1, y + 2, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 1, Blocks.fence, 0, 3);
		world.setBlock(x + 0, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 3, Blocks.fence, 0, 3);
		world.setBlock(x + 1, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.fence, 0, 3);
		world.setBlock(x + 0, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 1, Blocks.fence, 0, 3);
		world.setBlock(x + 1, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 1, Blocks.fence, 0, 3);
		world.setBlock(x + 0, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 3, Blocks.fence, 0, 3);
		world.setBlock(x + 1, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 3, Blocks.fence, 0, 3);
		world.setBlock(x + 0, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 1, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 1, y + 4, z + 1, Blocks.stone_stairs, 6, 3);
		world.setBlock(x + 2, y + 4, z + 1, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 0, y + 4, z + 2, Blocks.stone_stairs, 4, 3);
		world.setBlock(x + 1, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 2, Blocks.stone_stairs, 5, 3);
		world.setBlock(x + 0, y + 4, z + 3, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 1, y + 4, z + 3, Blocks.stone_stairs, 7, 3);
		world.setBlock(x + 2, y + 4, z + 3, Blocks.mossy_cobblestone, 0, 3);
		world.setBlock(x + 0, y + 5, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 5, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 5, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 5, z + 1, Blocks.wooden_slab, 0, 3);
		world.setBlock(x + 1, y + 5, z + 1, Blocks.wooden_slab, 0, 3);
		world.setBlock(x + 2, y + 5, z + 1, Blocks.wooden_slab, 0, 3);
		world.setBlock(x + 0, y + 5, z + 2, Blocks.wooden_slab, 0, 3);
		world.setBlock(x + 1, y + 5, z + 2, Blocks.wooden_slab, 0, 3);
		world.setBlock(x + 2, y + 5, z + 2, Blocks.wooden_slab, 0, 3);
		world.setBlock(x + 0, y + 5, z + 3, Blocks.wooden_slab, 0, 3);
		world.setBlock(x + 1, y + 5, z + 3, Blocks.wooden_slab, 0, 3);
		world.setBlock(x + 2, y + 5, z + 3, Blocks.wooden_slab, 0, 3);
		return true;

	}

}