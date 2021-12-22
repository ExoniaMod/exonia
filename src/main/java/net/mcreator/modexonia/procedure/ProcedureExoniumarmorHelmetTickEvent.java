package net.mcreator.modexonia.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.modexonia.ElementsModexonia;

@ElementsModexonia.ModElement.Tag
public class ProcedureExoniumarmorHelmetTickEvent extends ElementsModexonia.ModElement {
	public ProcedureExoniumarmorHelmetTickEvent(ElementsModexonia instance) {
		super(instance, 13);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ExoniumarmorHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, (int) 9999, (int) 1));
	}
}
