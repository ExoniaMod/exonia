
package net.mcreator.modexonia.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.modexonia.procedure.ProcedureExoniumhammerBlockDestroyedWithToold;
import net.mcreator.modexonia.creativetab.TabExoniumStuff;
import net.mcreator.modexonia.ElementsModexonia;

import java.util.Set;
import java.util.HashMap;

@ElementsModexonia.ModElement.Tag
public class ItemExoniumhammer extends ElementsModexonia.ModElement {
	@GameRegistry.ObjectHolder("modexonia:exoniumhammer")
	public static final Item block = null;
	public ItemExoniumhammer(ElementsModexonia instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("EXONIUMHAMMER", 1, 4000, 5f, 0f, 2)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 1);
				return ret.keySet();
			}

			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, IBlockState bl, BlockPos pos, EntityLivingBase entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, bl, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ProcedureExoniumhammerBlockDestroyedWithToold.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setUnlocalizedName("exoniumhammer").setRegistryName("exoniumhammer").setCreativeTab(TabExoniumStuff.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("modexonia:exoniumhammer", "inventory"));
	}
}
