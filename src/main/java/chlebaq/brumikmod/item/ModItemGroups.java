package chlebaq.brumikmod.item;

import chlebaq.brumikmod.BrumikMod;
import chlebaq.brumikmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BRUMIK_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BrumikMod.MOD_ID, "brumik_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BRUMIK))
                    .displayName(Text.translatable("itemgroup.brumikmod.brumik_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BRUMIK);
                        entries.add(ModItems.RAW_BRUMIK);
                        entries.add(ModItems.BURNED_BRUMIK);
                        entries.add(ModItems.BURNING_BRUMIK);
                        entries.add(ModItems.MAGIC_BRUMIK);
                        entries.add(ModItems.BRUMIK_SHARD);
                        entries.add(ModItems.MAGIC_BRUMIK_SHARD);

                        entries.add(ModBlocks.BRUMIK_ORE);
                    }).build());

    public static void registerItemGroups() {
        BrumikMod.LOGGER.info("Registering Item Groups for " + BrumikMod.MOD_ID);
    }
}