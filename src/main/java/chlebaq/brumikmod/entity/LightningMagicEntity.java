package chlebaq.brumikmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.UUID;

public class LightningMagicEntity extends Entity {

    // Configuration
    private static final int PARTICLE_ANIMATION_DURATION = 20*4;
    private static final double FINAL_RADIUS = 10.0;
    private static final int NUM_POINTS_IN_CIRCLE = 20;

    private int timer = 0;
    private double initialCasterX, initialCasterY, initialCasterZ; // Starting position of the effect

    // Constructors
    public LightningMagicEntity(EntityType<?> type, World world) {
        super(type, world);
        this.noClip = true; // Prevents collision with other entities
        this.setNoGravity(true);
        this.setInvulnerable(true);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    public LightningMagicEntity(World world, LivingEntity user) {
        this(ModEntities.LIGHTNING_MAGIC_EFFECT, world);
        this.initialCasterX = user.getX();
        this.initialCasterY = user.getY();
        this.initialCasterZ = user.getZ();
        this.setPos(initialCasterX, initialCasterY, initialCasterZ);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            return;
        }

        ServerWorld serverWorld = (ServerWorld) this.getWorld();

        // Particle animation
        if (timer <= PARTICLE_ANIMATION_DURATION) {
            // Calculate the current radius for the expanding circle of particles
            double progress = (double) timer / PARTICLE_ANIMATION_DURATION;
            double currentRadius = progress * FINAL_RADIUS;

            // Spawn a particle at each of the 10 points on the current circle
            for (int i = 0; i < NUM_POINTS_IN_CIRCLE; i++) {
                double angle = (2 * Math.PI / NUM_POINTS_IN_CIRCLE) * i; // Calculate angle in radians

                // Calculate the particle's X and Z position on the circle
                double particleX = initialCasterX + currentRadius * Math.cos(angle);
                double particleZ = initialCasterZ + currentRadius * Math.sin(angle);

                // Spawn a PORTAL particle at the calculated position
                serverWorld.spawnParticles(
                        ParticleTypes.PORTAL,
                        particleX, initialCasterY, particleZ,
                        3,
                        0.0, 0.0, 0.0,
                        0.0
                );
            }
        }

        // Lightning strike
        if (timer == PARTICLE_ANIMATION_DURATION + 1) {
            // Spawn lightning at each of the 10 final points
            for (int i = 0; i < NUM_POINTS_IN_CIRCLE; i++) {
                double angle = (2 * Math.PI / NUM_POINTS_IN_CIRCLE) * i;

                // Calculate the final X and Z position on the circle
                double lightningX = initialCasterX + FINAL_RADIUS * Math.cos(angle);
                double lightningZ = initialCasterZ + FINAL_RADIUS * Math.sin(angle);

                // Create and spawn a LightningEntity at the final position
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, serverWorld);
                lightning.setPos(lightningX, initialCasterY, lightningZ);
                serverWorld.spawnEntity(lightning);
            }
            this.discard(); // Remove entity
        }

        timer++; // Increment the timer each tick
    }
}
