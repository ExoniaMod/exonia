
package net.mcreator.modexonia.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.modexonia.item.ItemExoniumingot;
import net.mcreator.modexonia.block.BlockExoniumore;
import net.mcreator.modexonia.ElementsModexonia;

@ElementsModexonia.ModElement.Tag
public class RecipeCookedexoniumore extends ElementsModexonia.ModElement {
	public RecipeCookedexoniumore(ElementsModexonia instance) {
		super(instance, 22);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockExoniumore.block, (int) (1)), new ItemStack(ItemExoniumingot.block, (int) (1)), 2F);
	}
}
