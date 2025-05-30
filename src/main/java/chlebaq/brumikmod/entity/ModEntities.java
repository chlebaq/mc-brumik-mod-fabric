package chlebaq.brumikmod.entity;

import chlebaq.brumikmod.BrumikMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<LightningMagicEntity> LIGHTNING_MAGIC_EFFECT =
            EntityType.Builder.<LightningMagicEntity>create(LightningMagicEntity::new, SpawnGroup.MISC)
                    .dimensions(0.1f, 0.1f)
                    .disableSaving()
                    .disableSummon()
                    .build();

    static {
        Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(BrumikMod.MOD_ID, "lightning_magic_effect"),
                LIGHTNING_MAGIC_EFFECT
        );
    }

    public static void registerModEntities() {

        BrumikMod.LOGGER.info("Registering Mod Entities for " + BrumikMod.MOD_ID);
    }
}
