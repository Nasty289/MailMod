package net.nasty289.mailmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nasty289.mailmod.MailMod;

public class ModItems {

    public static final Item MAILBOX = registerItem("mailbox", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MailMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MailMod.LOGGER.info("Registering Mod Items for" + MailMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(MAILBOX);
        });
    }
}
