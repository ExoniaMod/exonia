
package net.mcreator.modexonia.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.modexonia.item.ItemExoniumingot;
import net.mcreator.modexonia.ElementsModexonia;

@ElementsModexonia.ModElement.Tag
public class TabExoniumStuff extends ElementsModexonia.ModElement {
	public TabExoniumStuff(ElementsModexonia instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabexoniumstuff") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemExoniumingot.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
