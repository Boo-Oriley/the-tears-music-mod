package com.TearsMusicMod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TearsMusicMod implements ModInitializer {
	public static final String MOD_ID = "tearsmusicmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final SoundEvent TEARS_SOUND = registerSound();

	private static SoundEvent registerSound() {
		Identifier identifier = Identifier.of(MOD_ID, "musictears");
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));

	}

	@Override

	public void onInitialize() {
		LOGGER.info("tearsmusicmodintalizing");
		LOGGER.info(TEARS_SOUND.getId().toString());
		//registerSound("records_tears");
	}
}
