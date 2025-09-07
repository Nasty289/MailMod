package net.nasty289.mailmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nasty289.mailmod.MailMod;

public class ModBlocks {

    public static final Block MAILBOX = registerBlocks("mailbox",
            new MailboxBlock(AbstractBlock.Settings.create().strength(5f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    private static Block registerBlocks (String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MailMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MailMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MailMod.LOGGER.info("Registering Mod Blocks for" + MailMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
          entries.add(ModBlocks.MAILBOX);
        });
    }
}
