package chlebaq.brumikmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BurningBrumikItem extends Item {
    public BurningBrumikItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing (ItemStack stack, World world, LivingEntity user) {
        ItemStack resultStack = super.finishUsing(stack, world, user);

        if (!world.isClient()) {
            user.setOnFireFor(10);
        }

        return resultStack;
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player && selected) {
            player.setOnFireFor(1);
        }
    }
}
