package com.ladinc.mcp.core.controllers;

import java.util.List;
import java.util.Set;

import com.ladinc.mcp.core.poker.actions.PokerAction;
import com.ladinc.mcp.core.poker.actions.WaitAction;
import com.ladinc.mcp.core.poker.objects.Card;
import com.ladinc.mcp.core.poker.objects.Client;
import com.ladinc.mcp.core.poker.objects.Player;
import com.ladinc.mcp.core.poker.objects.TableType;

public class MCPPokerClient implements Client
{

	private PokerAction currentAction;
	private boolean actionSent;
	
	public MCPPokerClient()
	{
		currentAction = PokerAction.WAIT;
	}
	
	public void setCurrentAction(PokerAction action)
	{
		this.currentAction = action;
		this.actionSent = false;
	}
	
	@Override
	public void messageReceived(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void joinedTable(TableType type, int bigBlind, List<Player> players) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handStarted(Player dealer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actorRotated(Player actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerUpdated(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardUpdated(List<Card> cards, int bet, int pot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerActed(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PokerAction act(int minBet, int currentBet,
			Set<PokerAction> allowedActions) {
		
		if(!actionSent)
		{
			actionSent = true;
			return this.currentAction;
		}
		else
		{
			return PokerAction.WAIT;
		}
	}

}
