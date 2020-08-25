package com.fengshui.tomatomod.items;

import com.fengshui.tomatomod.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

import java.util.List;

public class ModdingToolItem extends Item {

    public ModdingToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) { //enchantment glint
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Changes time of day"));
        } else {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " Shift " + "\u00A77" + "for more information!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        worldIn.setRainStrength(0.0f);
        worldIn.setDayTime(1000);
        if(KeyboardHelper.isHoldingShift()) {
            if(!playerIn.isCreative()){
                playerIn.setGameType(GameType.CREATIVE);
            }else{
                playerIn.setGameType(GameType.SURVIVAL);
            }
        }
        if(KeyboardHelper.isHoldingCtrl() && !playerIn.isCreative()){
            if(playerIn.getFoodStats().getFoodLevel() != 20){
                playerIn.getFoodStats().setFoodLevel(20);
            }else{
                playerIn.getFoodStats().setFoodLevel(10);
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
