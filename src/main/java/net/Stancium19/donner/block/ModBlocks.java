package net.Stancium19.donner.block;

import net.Stancium19.donner.Donner;
import net.Stancium19.donner.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public  static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, Donner.MOD_ID);

    public static final RegistryObject<Block>SALT_BLOCK=registerBlock("salt_block",
            ()->new Block(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(1.0f)));

    public static final RegistryObject<Block>SALT_ORE=registerBlock("salt_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops().strength(2.0F, 2.0F), UniformInt.of(2,5)));

    private static <T extends Block>RegistryObject<T>registerBlock(String name, Supplier<T> block){
    RegistryObject<T> toReturn = BLOCKS.register(name,block);
    registerBlockItem(name,toReturn);
    return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name,RegistryObject<T> block){
        return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
