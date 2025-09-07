package net.nasty289.mailmod;

import net.fabricmc.api.ModInitializer;

import net.nasty289.mailmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailMod implements ModInitializer {
	public static final String MOD_ID = "mailmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
        ModItems.registerModItems();
	}
}