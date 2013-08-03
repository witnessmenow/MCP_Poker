package com.ladinc.mcp.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.ladinc.mcp.MCP;
import com.ladinc.mcp.RedirectOption;
import com.ladinc.mcp.core.controllers.MCPListenerClient;
import com.ladinc.mcp.core.poker.objects.Player;
import com.ladinc.mcp.core.screens.GameLobbyScreen;

public class MCPPoker extends Game {

	
	public Map<String, Player> players;
	
	public GameLobbyScreen gameLobby;
	
	public MCP mcp;
	
	public MCPListenerClient mcpListener;
	
	public boolean startGame = false;
	
	
	@Override
	public void create() {
		
		players = new HashMap<String, Player>();
		initMCP();
		initScreens();
		
		this.setScreen(gameLobby);
	}
	
	private void initMCP()
	{
		mcp = MCP.tryCreateAndStartMCPWithPort(8899);
		
		
		//We do not want any deafult redirect options
		mcp.redirectOptions.clear();
		mcp.redirectOptions.add(new RedirectOption("register", "MCP Poker"));
		mcp.customLinks.add("register");
		mcp.customLinks.add("waitScreen");
		mcp.customLinks.add("gameScreen");
		
		
		mcpListener = new MCPListenerClient(this);
		
		mcp.addMCPListener(mcpListener);

	}

	
	private void initScreens()
	{
		this.gameLobby = new GameLobbyScreen(this);
		
	}

}
