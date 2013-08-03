package com.ladinc.mcp.core.controllers;

import java.util.Map;

import com.ladinc.mcp.core.MCPPoker;
import com.ladinc.mcp.core.poker.objects.Player;
import com.ladinc.mcp.interfaces.MCPContorllersListener;

public class MCPListenerClient implements MCPContorllersListener {

	MCPPoker game;
	
	public MCPListenerClient(MCPPoker game)
	{
		this.game = game;
	}
	
	@Override
	public void analogMove(int arg0, String arg1, float arg2, float arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonDown(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonUp(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orientation(int arg0, float arg1, float arg2, float arg3) {
		// TODO Auto-generated method stub
		
	}
	
	public void pass(Map<String, String> header, Map<String, String> parms,
			Map<String, String> files) {
		
		
		
		if(parms.containsKey("event"))
		{
			if(parms.get("event").contains("register"))
			{
				registerPlayer(parms.get("id"), parms.get("name"));
			}
			else if(parms.get("event").contains("start"))
			{
				this.game.startGame = true;
			}
		}
	}
	
	private void registerPlayer(String controllerId, String name)
	{
		if(!this.game.players.containsKey(controllerId))
		{
			this.game.players.put(controllerId, new Player(name, 500, null));
		}
		
	}
		

}
