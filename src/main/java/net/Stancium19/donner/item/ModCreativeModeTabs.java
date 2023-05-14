package net.Stancium19.donner.item;

import net.Stancium19.donner.Donner;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Donner.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab DONNER_TAB;
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        DONNER_TAB= event.registerCreativeModeTab(new ResourceLocation(Donner.MOD_ID,"donner_tab"),
                builder->builder.icon(()->new ItemStack(ModItems.SALT.get()))
                        .title(Component.translatable("creativemodetab.donner_tab")));
    }
}
