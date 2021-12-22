
package net.mcreator.modexonia.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.modexonia.procedure.ProcedureExoniumarmorHelmetTickEvent;
import net.mcreator.modexonia.creativetab.TabExoniumStuff;
import net.mcreator.modexonia.ElementsModexonia;

@ElementsModexonia.ModElement.Tag
public class ItemExoniumarmor extends ElementsModexonia.ModElement {
	@GameRegistry.ObjectHolder("modexonia:exoniumarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("modexonia:exoniumarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("modexonia:exoniumarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("modexonia:exoniumarmorboots")
	public static final Item boots = null;
	public ItemExoniumarmor(ElementsModexonia instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("EXONIUMARMOR", "modexonia:rmor_layer_1_textures_files_.png", 25,
				new int[]{2, 5, 6, 2}, 9, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")),
				0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				super.onArmorTick(world, entity, itemstack);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureExoniumarmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("exoniumarmorhelmet").setRegistryName("exoniumarmorhelmet").setCreativeTab(TabExoniumStuff.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("exoniumarmorbody")
				.setRegistryName("exoniumarmorbody").setCreativeTab(TabExoniumStuff.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("exoniumarmorlegs")
				.setRegistryName("exoniumarmorlegs").setCreativeTab(TabExoniumStuff.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("exoniumarmorboots")
				.setRegistryName("exoniumarmorboots").setCreativeTab(TabExoniumStuff.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("modexonia:exoniumarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("modexonia:exoniumarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("modexonia:exoniumarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("modexonia:exoniumarmorboots", "inventory"));
	}
}
