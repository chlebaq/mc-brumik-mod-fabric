package chlebaq.brumikmod;

import chlebaq.brumikmod.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EmptyEntityRenderer;

public class BrumikModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.LIGHTNING_MAGIC_EFFECT, EmptyEntityRenderer::new);
    }
}
