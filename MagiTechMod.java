package aidanj03.magitechmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import aidanj03.magitechmod.item_groups.MagiTechItemGroup;
import aidanj03.magitechmod.lists.BlockList;
import aidanj03.magitechmod.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistryEntry;
@Mod("magitechmod")

public class MagiTechMod 
{
	public static MagiTechMod instance;
	public static final String modid = "magitechmod";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup magitech = new MagiTechItemGroup();
	
	public MagiTechMod() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItem(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
					ItemList.bauxite_ore = new ItemBlock(BlockList.bauxite_ore, new Item.Properties().group(magitech)).setRegistryName(BlockList.bauxite_ore.getRegistryName()),
					ItemList.copper_ore = new ItemBlock(BlockList.copper_ore, new Item.Properties().group(magitech)).setRegistryName(BlockList.copper_ore.getRegistryName()),
					
					ItemList.aluminum_ingot = new Item(new Item.Properties().group(magitech)).setRegistryName(location("aluminum_ingot")),
					ItemList.alumentium_ingot = new Item(new Item.Properties().group(magitech)).setRegistryName(location("alumentium_ingot")),
					ItemList.augsteel = new Item(new Item.Properties().group(magitech)).setRegistryName(location("augsteel")),
					ItemList.steel = new Item(new Item.Properties().group(magitech)).setRegistryName(location("steel")),
					ItemList.copper_ingot = new Item(new Item.Properties().group(magitech)).setRegistryName(location("copper_ingot")),
					ItemList.plasma_blaster = new Item(new Item.Properties().group(magitech)).setRegistryName(location("plasma_blaster"))
			);
					
			
			logger.info("Items registered.");
		}
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.bauxite_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)).setRegistryName(location("bauxite_ore")),
				BlockList.copper_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)).setRegistryName(location("copper_ore"))
			);
						
				
			logger.info("Blocks registered.");
		}
		
		@SubscribeEvent
		public static void registerCapability(final RegistryEvent.Register<IForgeRegistryEntry<Capability>> event)
		{
			
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}
