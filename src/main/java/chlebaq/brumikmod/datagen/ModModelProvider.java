package chlebaq.brumikmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import chlebaq.brumikmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BRUMIK, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BRUMIK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNED_BRUMIK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRUMIK_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_BRUMIK_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.BURNING_BRUMIK, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_BRUMIK, Models.GENERATED);
    }
}