package chlebaq.brumikmod.item.custom;

import chlebaq.brumikmod.entity.LightningMagicEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MagicBrumikItem extends Item {
    public MagicBrumikItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient()) {

            LightningMagicEntity effectEntity = new LightningMagicEntity(world, user);
            world.spawnEntity(effectEntity);

            user.getItemCooldownManager().set(this, 20 * 7);
        }
        return TypedActionResult.success(itemStack);
    }
}