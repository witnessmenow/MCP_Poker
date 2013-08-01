package com.ladinc.mcp.java;

import com.ladinc.mcp.core.MCPPoker;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class MCPPokerDesktop {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new MCPPoker(), config);
	}
}
