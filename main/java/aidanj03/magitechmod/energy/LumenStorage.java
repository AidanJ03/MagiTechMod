package aidanj03.magitechmod.energy;

import net.minecraft.nbt.INBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class LumenStorage implements IStorage<ILumens>
{
	@Override
	public INBTBase writeNBT(Capability<ILumens> capability, ILumens instance, EnumFacing side) 
	{
		return new NBTTagFloat(instance.getLumens());
	}

	@Override
	public void readNBT(Capability<ILumens> capability, ILumens instance, EnumFacing side, INBTBase nbt) 
	{
		instance.set(((NBTPrimitive) nbt).getFloat());
	}
}
