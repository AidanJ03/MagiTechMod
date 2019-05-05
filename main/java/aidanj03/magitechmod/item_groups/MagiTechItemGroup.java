package aidanj03.magitechmod.item_groups;

import aidanj03.magitechmod.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MagiTechItemGroup extends ItemGroup 
{
	public MagiTechItemGroup()
	{
		super("magitech");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.alumentium_ingot);
	}
}
