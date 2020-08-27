package com.fengshui.tomatomod.entities;

import com.fengshui.tomatomod.init.EntityList;
import com.fengshui.tomatomod.init.ItemList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class TomatoEntity extends ProjectileItemEntity {

    public TomatoEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public TomatoEntity(World worldIn, LivingEntity throwerIn) {
        super(EntityList.TOMATO.get(), throwerIn, worldIn);
    }

    public TomatoEntity(EntityType<? extends ProjectileItemEntity> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    public TomatoEntity(EntityType<? extends ProjectileItemEntity> type, LivingEntity livingEntityIn, World worldIn) {
        super(type, livingEntityIn, worldIn);
    }

    public TomatoEntity(World world) {
        super(EntityList.TOMATO.get(), world);
    }

    public TomatoEntity(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
        this(world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemList.TOMATO.get();
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)result).getEntity();
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1f);
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int j = 0; j < 8; ++j) {
                this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, new ItemStack(ItemList.TOMATO.get())), this.getPosX(), this.getPosY(), this.getPosZ(), ((double) this.rand.nextFloat() - 0.5D) * 0.28D, ((double) this.rand.nextFloat() - 0.3D) * 0.28D, ((double) this.rand.nextFloat() - 0.5D) * 0.28D);
            }
        }
    }

    @Override
    protected void registerData() {

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemList.TOMATO.get());
    }

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
