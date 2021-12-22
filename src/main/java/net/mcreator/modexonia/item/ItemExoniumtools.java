
package net.mcreator.modexonia.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.modexonia.creativetab.TabExoniumStuff;
import net.mcreator.modexonia.ElementsModexonia;

import java.util.Set;
import java.util.HashMap;

@ElementsModexonia.ModElement.Tag
public class ItemExoniumtools extends ElementsModexonia.ModElement {
	@GameRegistry.ObjectHolder("modexonia:exoniumtools")
	public static final Item block = null;
	public ItemExoniumtools(ElementsModexonia instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("EXONIUMTOOLS", 1, 5000, 6f, 0f, 2)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 1);
				return ret.keySet();
			}

			@Override
			@SideOnly(Side.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setUnlocalizedName("exoniumtools").setRegistryName("exoniumtools").setCreativeTab(TabExoniumStuff.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("modexonia:exoniumtools", "inventory"));
	}
}
