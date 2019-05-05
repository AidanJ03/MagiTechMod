package aidanj03.magitechmod.energy;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class LumenProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(ILumens.class)
	public static final Capability<ILumens> LUMEN_CAP = null;
	
	private ILumens instance = LUMEN_CAP.getDefaultInstance();
	
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == LUMEN_CAP;
	}
	
	@Override
	public <T> T getcapability(Capability<T> capability, EnumFacing side)
	{
		return capability == LUMEN_CAP ? LUMEN_CAP.<T>> (this.instance) : null;
	}
	
	@Override
	public NBTBase serializeNBT()
	{
		return LUMEN_CAP.getStorage().writeNBT(LUMEN_CAP, this.instance, null);
	}
	
	@Override
	public void deserializeNBT(NBTBase nbt)
	{
		LUMEN_CAP.getStorage().readNBT(LUMEN_CAP, this.instance, null, nbt);
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, EnumFacing side) {
		// TODO Auto-generated method stub
		return null;
	}
}
