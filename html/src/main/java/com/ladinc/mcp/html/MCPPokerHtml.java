package com.ladinc.mcp.html;

import com.ladinc.mcp.core.MCPPoker;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class MCPPokerHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new MCPPoker();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
