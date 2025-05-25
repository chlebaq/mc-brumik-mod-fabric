package chlebaq.brumikmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent BRUMIK = new FoodComponent.Builder().nutrition(10).saturationModifier(1.25f).build();
    public static final FoodComponent RAW_BRUMIK = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3f).build();
    public static final FoodComponent BURNED_BRUMIK = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).build();
    public static final FoodComponent BURNING_BRUMIK = new FoodComponent.Builder().nutrition(4).saturationModifier(0.7f).alwaysEdible().build();
}