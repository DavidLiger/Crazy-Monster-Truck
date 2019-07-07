package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.hiero.Hiero;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.mygdx.game.Controleur.MTCGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		TexturePacker.process("../assets/TextureAtlasPostLoading","../assets","postLoading_VehiculeCamionette.atlas");
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new MTCGame(null), config);
	}
}
