package chlebaq.brumikmod;

import chlebaq.brumikmod.block.ModBlocks;
import chlebaq.brumikmod.entity.ModEntities;
import chlebaq.brumikmod.item.ModItemGroups;
import chlebaq.brumikmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrumikMod implements ModInitializer {
	public static final String MOD_ID = "brumikmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModEntities.registerModEntities();
	}
}