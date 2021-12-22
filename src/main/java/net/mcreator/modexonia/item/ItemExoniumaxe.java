
package net.mcreator.modexonia.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import net.mcreator.modexonia.creativetab.TabExoniumStuff;
import net.mcreator.modexonia.ElementsModexonia;

import java.util.Set;

@ElementsModexonia.ModElement.Tag
public class ItemExoniumaxe extends ElementsModexonia.ModElement {
	@GameRegistry.ObjectHolder("modexonia:exoniumaxe")
	public static final Item block = null;
	public ItemExoniumaxe(ElementsModexonia instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
		}.setUnlocalizedName("exoniumaxe").setRegistryName("exoniumaxe").setCreativeTab(TabExoniumStuff.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("modexonia:exoniumaxe", "inventory"));
	}
	private static class ItemToolCustom extends ItemTool {
		private static final Set<Block> effective_items_set = com.google.common.collect.Sets
				.newHashSet(new Block[]{Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN,
						Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE});
		protected ItemToolCustom() {
			super(EnumHelper.addToolMaterial("EXONIUMAXE", 1, 4000, 4f, 0f, 2), effective_items_set);
			this.attackDamage = 0f;
			this.attackSpeed = -3f;
		}

		@Override
		public float getDestroySpeed(ItemStack stack, IBlockState state) {
			Material material = state.getMaterial();
			return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE
					? super.getDestroySpeed(stack, state)
					: this.efficiency;
		}
	}
}
