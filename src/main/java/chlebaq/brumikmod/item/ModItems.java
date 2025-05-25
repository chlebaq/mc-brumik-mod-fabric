package chlebaq.brumikmod.item;

import chlebaq.brumikmod.BrumikMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BRUMIK = registerItem("brumik", new Item(new Item.Settings().food(ModFoodComponents.BRUMIK)));
    public  static final Item RAW_BRUMIK = registerItem("raw_brumik", new Item(new Item.Settings().food(ModFoodComponents.RAW_BRUMIK)));
    public static final Item BURNED_BRUMIK = registerItem("burned_brumik", new Item(new Item.Settings().food(ModFoodComponents.BURNED_BRUMIK)));
    public static final Item BURNING_BRUMIK = registerItem("burning_brumik", new Item(new Item.Settings().food(ModFoodComponents.BURNING_BRUMIK)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BrumikMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BrumikMod.LOGGER.info("Registering Mod Items for " + BrumikMod.MOD_ID);
    }
}