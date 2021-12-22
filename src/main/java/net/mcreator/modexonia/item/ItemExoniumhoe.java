
package net.mcreator.modexonia.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.modexonia.creativetab.TabExoniumStuff;
import net.mcreator.modexonia.ElementsModexonia;

import java.util.Set;
import java.util.HashMap;

@ElementsModexonia.ModElement.Tag
public class ItemExoniumhoe extends ElementsModexonia.ModElement {
	@GameRegistry.ObjectHolder("modexonia:exoniumhoe")
	public static final Item block = null;
	public ItemExoniumhoe(ElementsModexonia instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("EXONIUMHOE", 1, 4000, 4f, 0f, 2)) {
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 1);
				return ret.keySet();
			}
		}.setUnlocalizedName("exoniumhoe").setRegistryName("exoniumhoe").setCreativeTab(TabExoniumStuff.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("modexonia:exoniumhoe", "inventory"));
	}
}
