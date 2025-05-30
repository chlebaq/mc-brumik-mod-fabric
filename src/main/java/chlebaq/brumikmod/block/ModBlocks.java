package chlebaq.brumikmod.block;

import chlebaq.brumikmod.BrumikMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block BRUMIK_ORE = registerBlock("brumik_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4,8), AbstractBlock.Settings.create().strength(5f).requiresTool()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BrumikMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BrumikMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BrumikMod.LOGGER.info("Registering Mod Blocks for "+BrumikMod.MOD_ID);
    }
}
