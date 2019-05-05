package aidanj03.magitechmod.energy;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class LumenProvider implements ICapabilitySerializable<NBTTagCompound>
{	
	ILumens storage = new LumenStorage(1000, 1000, 1000);
	
	public LumenProvider appendNBT(@Nullable NBTTagCompound compound)
	
	@CapabilityInject(ILumens.class)
	public static final Capability<ILumens> LUMENS = null;
	
	private ILumens instance = LUMENS.getDefaultInstance();
	
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == LUMENS;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return hasCapability(capability, facing) ? (T) storage : null;
	}
	
	public NBTTagCompound serializeNBT()
	{
		NBTTagCompound compound = new NBTTagCompound();
		compound.setTag("lumen_cap", LUMENS.writeNBT(storage, EnumFacing.DOWN));
	}
	
	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		if (nbt != null) 
		{
			NBTTagCompound nbt$lumencapability = (NBTTagCompound) nbt.getTag("lumens");
			if (nbt$lumencapability != null)
			{
				LUMENS.readNBT(instance, EnumFacing.DOWN, nbt$lumencapability);
			}
		}
	}
}
