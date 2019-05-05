package aidanj03.magitechmod.energy;

import net.minecraft.nbt.INBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class LumenStorage implements IStorage<ILumens>, ILumens
{
	public LumenStorage(int i, int j, int k) 
	{
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public void consume(float points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fill(float points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(float points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getLumens() {
		// TODO Auto-generated method stub
		return 0;
	}
}
