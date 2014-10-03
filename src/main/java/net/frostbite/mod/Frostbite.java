package net.frostbite.mod;


import com.google.common.base.Strings;

import net.frostbite.mod.Enchantments.EnchantmentSpeedBoost;
import net.frostbite.mod.TileEntity.TileEntityAlabasterOven;
import net.frostbite.mod.armor.FrostArmor;
import net.frostbite.mod.armor.PoloArmor;
import net.frostbite.mod.blocks.AlabasterOven;
import net.frostbite.mod.blocks.ConsentratedEnder;
import net.frostbite.mod.blocks.EnderOre;
import net.frostbite.mod.blocks.FrostBlock;
import net.frostbite.mod.blocks.FrostOre;
import net.frostbite.mod.blocks.NCCrop;
import net.frostbite.mod.blocks.ObsidianTable;
import net.frostbite.mod.blocks.PeridotOre;
import net.frostbite.mod.blocks.PoloriteBlock;
import net.frostbite.mod.blocks.PoloriteOre;
import net.frostbite.mod.blocks.WorkSurface;
import net.frostbite.mod.entity.EntityHandler;
import net.frostbite.mod.entity.EntityRunner;
import net.frostbite.mod.handler.FuelHandler;
import net.frostbite.mod.handler.GuiHandler;
import net.frostbite.mod.items.EnderShard;
import net.frostbite.mod.items.EnderSword;
import net.frostbite.mod.items.FrostAxe;
import net.frostbite.mod.items.FrostHoe;
import net.frostbite.mod.items.FrostPickaxe;
import net.frostbite.mod.items.FrostShovel;
import net.frostbite.mod.items.FrostSword;
import net.frostbite.mod.items.HellFruit;
import net.frostbite.mod.items.ItemFireWand;
import net.frostbite.mod.items.ItemHaDiWand;
import net.frostbite.mod.items.ItemRaWand;
import net.frostbite.mod.items.LightningSword;
import net.frostbite.mod.items.NCItems;
import net.frostbite.mod.items.PoloriteIngot;
import net.frostbite.mod.items.PowerGemOfHaste;
import net.frostbite.mod.items.Smacker;
import net.frostbite.mod.items.SuperDrill;
import net.frostbite.mod.items.WithersSword;
import net.frostbite.mod.worldgen.FrostbiteWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = Frostbite.modid, version = Frostbite.version)
public class Frostbite {
    
	public static final String modid = "Frostbite";
    public static final String version = "Alpha v1.0";
    
    @SidedProxy(clientSide = "net.frostbite.mod.ClientProxy", serverSide = "net.frostbite.mod.ServerProxy")
    public static ServerProxy proxy;
    
    @Instance(modid)
    public static Frostbite modInstance;
    
    
    
    //Enum Tool Material
    public static final ToolMaterial FrostMaterial = EnumHelper.addToolMaterial("FrostMaterial", 1, 131, 4.0F, 1.0F, 5);
    
    public static final ToolMaterial PoloMaterial = EnumHelper.addToolMaterial("PoloMaterial", 1, 175, 5.0F, 15, 10);
    
    public static Item.ToolMaterial IronGolemMaterial = EnumHelper.addToolMaterial("IronGolemMaterial", 1, 1500, 9.0F, 8.0F, 0);
    
    public static Item.ToolMaterial ThunderMaterial = EnumHelper.addToolMaterial("ThunderMaterial", 3, 1561, 9.0F, 3.0F, 10);
    
    
    public static final Item.ToolMaterial superDrillMaterial = EnumHelper.addToolMaterial("superDrill", 3, 3154, 120.0F, 3.0F, 2);
    
    public static final Item.ToolMaterial peridotTools = EnumHelper.addToolMaterial("peridotTools", 3, 1561, 9.0F, 3.0F, 10);
    
    //Enum Armor Material
    public static final ArmorMaterial FrostAromrMaterial = EnumHelper.addArmorMaterial("FrostArmorMaterial", 15, new int[]{2, 5, 4, 2}, 11);
    
    public static final ArmorMaterial PoloAromrMaterial = EnumHelper.addArmorMaterial("PoloArmorMaterial", 15, new int[]{2, 5, 4, 3}, 10);
    
    
    FrostbiteWorldGen eventWorldGen = new FrostbiteWorldGen();
    
    public static  CreativeTabs frostbiteTab;
    
    
    
    
    //Public Enchantments
    public static final Enchantment speedBoost = new EnchantmentSpeedBoost(84, 5);
    
    //Public Items
    public static Item itemSmacker;
    public static Item SuperDrill;
    public static Item PowerGemOfHaste;
    public static Item LightningSword;
    public static Item EnderSword;
    public static Item WithersBlood;
    public static Item WithersSword;
    public static Item ItemFireWand;
    public static Item ItemHaDiWand;
    public static Item ItemRaWand;
   
    
   
    
    
    //Public Ingots
    public static Item itemFrostIngot;
    public static Item itemPoloriteIngot;
    public static Item Peridot;
    public static Item EnderShard;
    
    
    //Public Ores
    public static Block oreFrostOre;
    public static Block orePoloriteOre;
    public static Block orePeridotOre;
    public static Block EnderOre;
 
    
    //Public Blocks
    public static Block blockFrostBlock;
    public static Block blockPoloriteBlock;
    public static Block ConsentratedEnder;
    public static Block blockObsidianTable;
    public static Block blockAlabasterOvenIdle;
    public static Block blockAlabasterOvenActive;
    public static final int guiIDAlabasterOven = 0;
    public static Block blockWorkSurface;
	public static final int guiIDWorkSurface = 1;
	public static Block blockIngotMasherIdle;
	public static Block blockIngotMasherActive;
	public static final int guiIDIngotMasher = 1;
	
    
    
    
  
   

   
    
    //Public Food
    public static Item foodPotato;
    
    //Public Crops
    public static Item cropHellFruitSeeds;
    public static Item cropHellFruit;
    public static Block cropHellFruitPlant;
    
    
    //Public Fuel
    public static Item itemFrostCoal;
    
    
    //Public Tools
     //Frost
    public static Item itemFrostSword;
    public static Item itemFrostPickaxe;
    public static Item itemFrostAxe;
    public static Item itemFrostShovel;
    public static Item itemFrostHoe;
    
     //Misc.
    
    
    
    
   
    
    
    //Polorite
    public static Item itemPoloSword;
    public static Item itemPoloPickaxe;
    public static Item itemPoloAxe;
    public static Item itemPoloShovel;
    public static Item itemPoloHoe;
     
    
    //Public Armor
     //Frost
    private static int FA1;
    private static int FA2; 
    private static int FA3;
    private static int FA4;
    
    
    
    public static Item FrostHelmet = new FrostArmor(FrostAromrMaterial, FA1, 0).setUnlocalizedName("FrostHelmet").setTextureName(modid + ":" + "FrostHelmet");
    public static Item FrostChest =  new FrostArmor(FrostAromrMaterial, FA2, 1).setUnlocalizedName("FrostChest").setTextureName(modid + ":" + "FrostChest");
    public static Item FrostLegs =  new FrostArmor(FrostAromrMaterial, FA3, 2).setUnlocalizedName("FrostLegs").setTextureName(modid + ":" + "FrostLegs");
    public static Item FrostBoots =  new FrostArmor(FrostAromrMaterial, FA4, 3).setUnlocalizedName("FrostBoots").setTextureName(modid + ":" + "FrostBoots");
    
    
    //Polorite
    private static int PA1;
    private static int PA2; 
    private static int PA3;
    private static int PA4;
    
    public static Item PoloHelmet = new PoloArmor(PoloAromrMaterial, PA1, 0).setUnlocalizedName("PoloHelmet").setTextureName(modid + ":" + "PoloHelmet");
    public static Item PoloChest =  new PoloArmor(PoloAromrMaterial, PA2, 1).setUnlocalizedName("PoloChest").setTextureName(modid + ":" + "PoloChest");
    public static Item PoloLegs =  new PoloArmor(PoloAromrMaterial, PA3, 2).setUnlocalizedName("PoloLegs").setTextureName(modid + ":" + "PoloLegs");
    public static Item PoloBoots =  new PoloArmor(PoloAromrMaterial, PA4, 3).setUnlocalizedName("PoloBoots").setTextureName(modid + ":" + "PoloBoots");
    
    
    
    
    
    
    
    @EventHandler
    public void PreInit(FMLPreInitializationEvent preEvent){
    	
    	
    	
    	
    
    	proxy.registerRenderThings();
    	
    	frostbiteTab = new CreativeTabs("Frostbite"){
    		@SideOnly(Side.CLIENT)
    		public Item getTabIconItem(){
    			return Item.getItemFromBlock(Frostbite.oreFrostOre);
    		}
    	};
    
    	
    	
    	
    	
    	
    	
    	//Items
    	itemFrostIngot = new NCItems().setUnlocalizedName("FrostIngot");
    	GameRegistry.registerItem(itemFrostIngot,"FrostIngot");
    	
    	
    	itemPoloriteIngot = new PoloriteIngot().setUnlocalizedName("PoloriteIngot");
    	GameRegistry.registerItem(itemPoloriteIngot,"PoloriteIngot");
    	
    	Peridot = new NCItems().setUnlocalizedName("Peridot");
    	GameRegistry.registerItem(Peridot,"Peridot");
    	
    	EnderShard = new EnderShard ().setUnlocalizedName("EnderShard");
    	GameRegistry.registerItem(EnderShard, "EnderShard");
    	
    	
    	
    	
    	
    	
    	
    	
    	//Foods
    	foodPotato = new ItemFood(10, 1.2F, false).setUnlocalizedName("Potato").setCreativeTab(frostbiteTab).setTextureName(Frostbite.modid + ":Potato");
    	
    	
    	//Crops
    	cropHellFruitPlant = new NCCrop().setBlockName("HellFruitPlant");
    	cropHellFruitSeeds = new ItemSeeds(cropHellFruitPlant, Blocks.farmland).setUnlocalizedName("HellFruitSeeds").setTextureName(modid + ":HellFruitSeeds").setCreativeTab(frostbiteTab);
    	cropHellFruit = new HellFruit(8, 1.0F, false).setUnlocalizedName("HellFruit").setCreativeTab(frostbiteTab).setTextureName(Frostbite.modid + ":HellFruit");
    	
    			
    	
    
    	
    	//Fuel
    	itemFrostCoal = new NCItems().setUnlocalizedName("FrostCoal");
    	GameRegistry.registerItem(itemFrostCoal,"FrostCoal");
    	
    	
    	
    	//Ores
    	oreFrostOre = new FrostOre(Material.rock).setBlockName("FrostOre");
    	GameRegistry.registerBlock(oreFrostOre, "FrostOre");
    	
    	orePoloriteOre = new PoloriteOre(Material.rock).setBlockName("PoloriteOre");
    	GameRegistry.registerBlock(orePoloriteOre, "PoloriteOre");
    	
    	orePeridotOre = new PeridotOre(Material.rock).setBlockName("PeridotOre");
    	GameRegistry.registerBlock(orePeridotOre, "PeridotOre");
    	
    	EnderOre = new EnderOre(Material.rock).setBlockName("EnderOre");
    	GameRegistry.registerBlock(EnderOre, "EnderOre");
    	
    	
    	
    	
    	
    	
    	
    	
    	//Blocks
    	blockFrostBlock = new FrostBlock(Material.iron).setBlockName("FrostBlock");
    	GameRegistry.registerBlock(blockFrostBlock, "FrostBlock");
    	
    	blockPoloriteBlock = new PoloriteBlock(Material.rock).setBlockName("PoloriteBlock");
    	GameRegistry.registerBlock(blockPoloriteBlock, "PoloriteBlock");
    	
    	ConsentratedEnder = new ConsentratedEnder(Material.rock).setBlockName("ConsentratedEnder");
    	GameRegistry.registerBlock(ConsentratedEnder, "ConsentratedEnder");
    	

    	blockObsidianTable = new ObsidianTable(Material.rock).setBlockName("ObsidianTable");
    	GameRegistry.registerBlock(blockObsidianTable, "ObsidianBlock");
    	
    	
    	
    	//Furnace
    	blockAlabasterOvenIdle = new AlabasterOven(false).setBlockName("AlabasterOvenIdle").setCreativeTab(frostbiteTab);
    	GameRegistry.registerBlock(blockAlabasterOvenIdle, "AlabasterOvenIdle");
    	
    	blockAlabasterOvenActive = new AlabasterOven(true).setBlockName("AlabasterOvenActive").setLightLevel(0.625F);
    	GameRegistry.registerBlock(blockAlabasterOvenActive, "AlabasterOvenActive");
    	
    	//CraftingTable
    	blockWorkSurface = new WorkSurface().setBlockName("WorkSurface");
    	GameRegistry.registerBlock(blockWorkSurface, "WorkSurface");
    	
    	
    	
    	
    	
    	
    	
    	//Tools
    	 //Frost
    	itemFrostSword = new FrostSword(FrostMaterial).setUnlocalizedName("FrostSword");
    	GameRegistry.registerItem(itemFrostSword,"FrostSword");
    	
    	itemFrostPickaxe = new FrostPickaxe(FrostMaterial).setUnlocalizedName("FrostPickaxe");
    	GameRegistry.registerItem(itemFrostPickaxe,"FrostPickaxe");
    	
    	itemFrostShovel = new FrostShovel(5001, FrostMaterial, null).setUnlocalizedName("FrostShovel").setCreativeTab(frostbiteTab).setTextureName(modid + ":" + "FrostShovel");
    	GameRegistry.registerItem(itemFrostShovel, "FrostShovel");
    	
    	itemFrostAxe = new FrostAxe(5002, FrostMaterial, null).setUnlocalizedName("FrostAxe").setCreativeTab(frostbiteTab).setTextureName(modid + ":" + "FrostAxe");
    	GameRegistry.registerItem(itemFrostAxe, "FrostAxe");
    	
    	itemFrostHoe = new FrostHoe(5003, FrostMaterial, null).setUnlocalizedName("FrostHoe").setCreativeTab(frostbiteTab).setTextureName(modid + ":" + "FrostHoe");
    	GameRegistry.registerItem(itemFrostHoe, "FrostHoe");
    	 
         //Polorite
    	itemPoloSword = new FrostSword(PoloMaterial).setUnlocalizedName("PoloSword");
    	GameRegistry.registerItem(itemPoloSword,"PoloSword");
    	
    	itemPoloPickaxe = new FrostPickaxe(PoloMaterial).setUnlocalizedName("PoloPickaxe");
    	GameRegistry.registerItem(itemPoloPickaxe,"PoloPickaxe");
    	
    	itemPoloShovel = new FrostShovel(5001, PoloMaterial, null).setUnlocalizedName("PoloShovel").setCreativeTab(frostbiteTab).setTextureName(modid + ":" + "PoloShovel");
    	GameRegistry.registerItem(itemPoloShovel, "PoloShovel");
    	
    	itemPoloAxe = new FrostAxe(5004, PoloMaterial, null).setUnlocalizedName("PoloAxe").setCreativeTab(frostbiteTab).setTextureName(modid + ":" + "PoloAxe");
    	GameRegistry.registerItem(itemPoloAxe, "PoloAxe");
    	
    	itemPoloHoe = new FrostHoe(5005, PoloMaterial, null).setUnlocalizedName("PoloHoe").setCreativeTab(frostbiteTab).setTextureName(modid + ":" + "PoloHoe");
    	GameRegistry.registerItem(itemPoloHoe, "PoloHoe");
    	
    	//Misc.
    	SuperDrill = new SuperDrill(superDrillMaterial).setUnlocalizedName("SuperDrill");
    	GameRegistry.registerItem(SuperDrill, "SuperDrill");
    	
    	PowerGemOfHaste = new PowerGemOfHaste().setUnlocalizedName("PowerGemOfHaste");
    	GameRegistry.registerItem(PowerGemOfHaste, "PowerGemOfHaste");
    	
    	LightningSword = new LightningSword(ThunderMaterial).setUnlocalizedName("LightningSword");
    	GameRegistry.registerItem(LightningSword,"LightningSword");
    	
    	itemSmacker = new Smacker(IronGolemMaterial).setUnlocalizedName("Smacker");
    	GameRegistry.registerItem(itemSmacker, "Smacker");
    	
    	EnderSword = new EnderSword(IronGolemMaterial).setUnlocalizedName("EnderSword");
    	GameRegistry.registerItem(EnderSword, "EnderSword");
    	
    	WithersBlood = new NCItems().setUnlocalizedName("WithersBlood");
    	GameRegistry.registerItem(WithersBlood, "WithersBlood");
    	
    	WithersSword = new WithersSword(IronGolemMaterial).setUnlocalizedName("WithersSword");
    	GameRegistry.registerItem(WithersSword, "WithersSword");
    	
    	ItemFireWand = new ItemFireWand(0).setUnlocalizedName("FireWand");
    	GameRegistry.registerItem(ItemFireWand, "FireWand");
    	
    	ItemHaDiWand = new ItemHaDiWand(0).setUnlocalizedName("HaDiWand");
    	GameRegistry.registerItem(ItemHaDiWand, "HaDiWand");
    	
    	ItemRaWand = new ItemRaWand(0).setUnlocalizedName("RaWand");
    	GameRegistry.registerItem(ItemRaWand, "RaWand");
    	
    	
    	
    	
    	
    	
    	
    	

    	
 
    	//Armor
    	 //Frost
    	 FrostHelmet = new FrostArmor(FrostAromrMaterial, FA1, 0).setUnlocalizedName("FrostHelmet").setTextureName(modid + ":" + "FrostHelmet");
         FrostChest =  new FrostArmor(FrostAromrMaterial, FA2, 1).setUnlocalizedName("FrostChest").setTextureName(modid + ":" + "FrostChest");
         FrostLegs =  new FrostArmor(FrostAromrMaterial, FA3, 2).setUnlocalizedName("FrostLegs").setTextureName(modid + ":" + "FrostLegs");
         FrostBoots =  new FrostArmor(FrostAromrMaterial, FA4, 3).setUnlocalizedName("FrostBoots").setTextureName(modid + ":" + "FrostBoots");
    	
         //Polorite
          PoloHelmet = new PoloArmor(PoloAromrMaterial, PA1, 0).setUnlocalizedName("PoloHelmet").setTextureName(modid + ":" + "PoloHelmet");
          PoloChest =  new PoloArmor(PoloAromrMaterial, PA2, 1).setUnlocalizedName("PoloChest").setTextureName(modid + ":" + "PoloChest");
          PoloLegs =  new PoloArmor(PoloAromrMaterial, PA3, 2).setUnlocalizedName("PoloLegs").setTextureName(modid + ":" + "PoloLegs");
          PoloBoots =  new PoloArmor(PoloAromrMaterial, PA4, 3).setUnlocalizedName("PoloBoots").setTextureName(modid + ":" + "PoloBoots");

         
          
      
     
    	
    	
    	
    	//Spawn
    	GameRegistry.registerWorldGenerator(eventWorldGen, 0);
    	
    	//Armor
    	 //Frost
    	 GameRegistry.registerItem(FrostHelmet, "FrostHelmet");
    	 GameRegistry.registerItem(FrostChest, "FrostChest");
    	 GameRegistry.registerItem(FrostLegs, "FrostLegs");
    	 GameRegistry.registerItem(FrostBoots, "FrostBoots");
    	 
    	 //Polorite
    	 GameRegistry.registerItem(PoloHelmet, "PoloHelmet");
    	 GameRegistry.registerItem(PoloChest, "PoloChest");
    	 GameRegistry.registerItem(PoloLegs, "PoloLegs");
    	 GameRegistry.registerItem(PoloBoots, "PoloBoots");
    
    	 
    	//Entity
    	 EntityHandler.registerMonsters(EntityRunner.class, "Runner");
    	 
    	
    	 
    	 
    
       	  
    	 
    	 
    	 //Items
    	 
    	 
    	 //Food
    	
    	 
    	 
    	 
    	 //Crops
    	 GameRegistry.registerItem(cropHellFruitSeeds, "HellFruitSeeds");
    	 GameRegistry.registerItem(cropHellFruit, "HellFruit");
    	 GameRegistry.registerBlock(cropHellFruitPlant, "HellFruitPlant");
    	 
    	//Crop Seeds WorldGen
    	 MinecraftForge.addGrassSeed(new ItemStack(cropHellFruitSeeds), 10);
    	 
    	
    	 
    	 
    	 //Misc.
    	 
    	 
    	 //Entities
    	 
    	
    	 
    	 
    	 
    	 
    	
    	 
         
         //Smelting
     	GameRegistry.addSmelting(oreFrostOre, new ItemStack(itemFrostIngot), 0);
     	  
     	
     	 //Smelting Fuel
     	GameRegistry.registerFuelHandler(new FuelHandler());
     	   
     	
     	
     	//Recipes
         GameRegistry.addRecipe(new ItemStack(blockFrostBlock),"CCC", "CCC", "CCC", 'C', itemFrostIngot);
         
         GameRegistry.addRecipe(new ItemStack(itemFrostSword)," C ", " C ", " L ", 'C', itemFrostIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(itemFrostPickaxe),"CCC", " L ", " L ", 'C', itemFrostIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(itemFrostAxe),"CC ", "CL ", " L ", 'C', itemFrostIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(itemFrostShovel)," C ", " L ", " L ", 'C', itemFrostIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(itemFrostHoe),"CC ", " L ", " L ", 'C', itemFrostIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(FrostLegs),"CCC","C C","C C", 'C', itemFrostIngot);
         
         GameRegistry.addRecipe(new ItemStack(FrostBoots),"   ", "C C", "C C", 'C', itemFrostIngot);
         
         GameRegistry.addRecipe(new ItemStack(FrostChest),"C C ", "CCC ", "CCC ", 'C', itemFrostIngot);
         
         GameRegistry.addRecipe(new ItemStack(FrostHelmet),"CCC","C C","   ", 'C', itemFrostIngot);
        
         GameRegistry.addRecipe(new ItemStack(PowerGemOfHaste)," y ", "yyy", " y ", 'y',  Peridot);
        
         GameRegistry.addRecipe(new ItemStack(SuperDrill), "XYX", "XPX", " Z ", 'Y', Peridot, 'Z',Items.gold_ingot, 'P', PowerGemOfHaste, 'X',Items.iron_ingot);
        
         GameRegistry.addRecipe(new ItemStack(blockPoloriteBlock), "XXX", "XXX", "XXX", 'X', itemPoloriteIngot);
         
         GameRegistry.addRecipe(new ItemStack(itemPoloSword)," C ", " C ", " L ", 'C', itemPoloriteIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(itemPoloPickaxe),"CCC", " L ", " L ", 'C', itemPoloriteIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(itemPoloAxe),"CC ", "CL ", " L ", 'C', itemPoloriteIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(itemPoloShovel)," C ", " L ", " L ", 'C', itemPoloriteIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(itemPoloHoe),"CC ", " L ", " L ", 'C', itemPoloriteIngot,'L',Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(PoloLegs),"CCC","C C","C C", 'C', itemPoloriteIngot);
         
         GameRegistry.addRecipe(new ItemStack(PoloBoots),"   ", "C C", "C C", 'C', itemPoloriteIngot);
         
         GameRegistry.addRecipe(new ItemStack(PoloChest),"C C", "CCC", "CCC", 'C', itemPoloriteIngot);
         
         GameRegistry.addRecipe(new ItemStack(PoloHelmet),"CCC","C C","   ", 'C', itemPoloriteIngot);
        
         GameRegistry.addRecipe(new ItemStack(itemSmacker),"CC ", "CL ", "CL ", 'C', Items.iron_ingot, 'L' ,Items.stick);
         
         GameRegistry.addRecipe(new ItemStack(WithersBlood)," C ", " L ", "   ", 'C', Items.nether_star, 'L' ,Items.glass_bottle);
         
         GameRegistry.registerTileEntity(TileEntityAlabasterOven.class, "AlabasterOven");
         
         NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        			
         
         
         
        
    }
         
         
           	  


	@EventHandler
    public void Init(FMLInitializationEvent event){	
	}
	
	
	
	
	
	
	


      
        
    


    @EventHandler
    public void PostInit(FMLPostInitializationEvent postEvent){
    	
    }
    
    
    
}