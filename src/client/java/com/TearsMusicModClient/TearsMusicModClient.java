package com.TearsMusicModClient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvent;

import static com.TearsMusicMod.TearsMusicMod.TEARS_SOUND;


public class TearsMusicModClient implements ClientModInitializer {
	private boolean hasPlayed = false;
	private boolean hasjoinedworld = false;
	private boolean isPlaying = false;

	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.currentScreen instanceof TitleScreen) {
				MusicTracker music = client.getMusicTracker();
				music.stop();


				if (!hasPlayed) {
					client.getSoundManager().play(PositionedSoundInstance.music(TEARS_SOUND));
					hasPlayed = true;
				}
			}
            if (!hasjoinedworld && client.player != null) {
				client.getSoundManager().play(PositionedSoundInstance.music(TEARS_SOUND));
				hasjoinedworld = true;
				hasPlayed = false;
			}
			if (hasjoinedworld && client.player == null) {
				hasjoinedworld = false;
			}
		});

        ClientTickEvents.END_CLIENT_TICK.register(c -> {
			if (c.player != null && !isPlaying) {
				playTears(c);
			}
		});
	}

	public void playTears(MinecraftClient client) {
		SoundEvent tearsSound = SoundEvent.of(TEARS_SOUND.getId());
		client.getSoundManager().play(PositionedSoundInstance.music(tearsSound));
		isPlaying = true;
	}
}


