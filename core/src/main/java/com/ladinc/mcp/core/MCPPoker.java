package com.ladinc.mcp.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.ladinc.mcp.MCP;
import com.ladinc.mcp.RedirectOption;
import com.ladinc.mcp.core.controllers.MCPListenerClient;
import com.ladinc.mcp.core.poker.objects.Player;
import com.ladinc.mcp.core.screens.GameLobby;

public class MCPPoker extends Game {

	
	public Map<String, Player> players;
	
	public GameLobby gameLobby;
	
	public MCP mcp;
	
	public MCPListenerClient mcpListener;
	
	
	@Override
	public void create() {
		
		players = new HashMap<String, Player>();
		initMCP();
		initScreens();
		
		this.setScreen(gameLobby);
	}
	
	private void initMCP()
	{
		mcp = new MCP(8899);
		
		try {
			mcp.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(mcp.getListeningPort() <= 0)
		{
			//port was in use, using a random one
			
			mcp = new MCP(0);
			
			try {
				mcp.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//We do not want any deafult redirect options
		mcp.redirectOptions.clear();
		mcp.redirectOptions.add(new RedirectOption("custom/register", "MCP Pooker"));
		
		
		mcpListener = new MCPListenerClient(this);
		
		mcp.addMCPListener(mcpListener);

	}

	
	private void initScreens()
	{
		this.gameLobby = new GameLobby(this);
		
	}

}
