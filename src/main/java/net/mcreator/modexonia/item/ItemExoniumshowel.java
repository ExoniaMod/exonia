
package net.mcreator.modexonia.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.modexonia.creativetab.TabExoniumStuff;
import net.mcreator.modexonia.ElementsModexonia;

import java.util.Set;
import java.util.HashMap;

@ElementsModexonia.ModElement.Tag
public class ItemExoniumshowel extends ElementsModexonia.ModElement {
	@GameRegistry.ObjectHolder("modexonia:exoniumshowel")
	public static final Item block = null;
	public ItemExoniumshowel(ElementsModexonia instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("EXONIUMSHOWEL", 1, 4000, 4f, 0f, 2)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 1);
				return ret.keySet();
			}
		}.setUnlocalizedName("exoniumshowel").setRegistryName("exoniumshowel").setCreativeTab(TabExoniumStuff.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("modexonia:exoniumshowel", "inventory"));
	}
}
