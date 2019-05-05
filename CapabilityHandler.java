package aidanj03.magitechmod;

import aidanj03.magitechmod.energy.LumenProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityHandler 
{
	public static final ResourceLocation LUMEN_CAP = new ResourceLocation(MagiTechMod.modid, "lumens");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{
		if (!(event.getEntity() instanceof EntityPlayer)) return;
		
		event.addCapability(LUMEN_CAP, new LumenProvider());
	}
}
