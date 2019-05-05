package aidanj03.magitechmod;

import aidanj03.magitechmod.energy.LumenProvider;
import aidanj03.magitechmod.lists.ItemList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityHandler 
{
	public static final ResourceLocation LUMENS = new ResourceLocation(MagiTechMod.modid, "lumens");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<ItemStack> event)
	{
		if (!(event.getItemStack() instanceof ItemList).plasma_blaster) return;
		
		event.addCapability(LUMENS, new LumenProvider());
	}
}
