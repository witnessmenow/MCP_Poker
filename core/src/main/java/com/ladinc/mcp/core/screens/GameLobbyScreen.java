package com.ladinc.mcp.core.screens;

import java.util.Map;

import org.json.simple.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ladinc.mcp.core.MCPPoker;
import com.ladinc.mcp.core.poker.objects.Player;

public class GameLobbyScreen implements Screen{

	private int screenWidth;
    private int screenHeight;
    
    public BitmapFont font;
	
    private MCPPoker game;
    
    private OrthographicCamera camera;
    
    private SpriteBatch spriteBatch;
    
    private static final String TITLE = "MCP Texas Holdem";
    
    public GameLobbyScreen(MCPPoker game)
    {
    	this.game = game;
    	
    	this.screenWidth = 1280;
    	this.screenHeight = 720;
    	
    	this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, this.screenWidth, this.screenHeight);
        
        initializeFont();
    }
    
	private void initializeFont()
	{		
		
    	this.font = new BitmapFont(Gdx.files.internal("Fonts/Const-50.fnt"), Gdx.files.internal("Fonts/Const-50.png"), false);
    	//Make text black
    	this.font.setColor(1f, 1f, 1f, 1.0f);
    	
	}
    
	@Override
	public void render(float delta) {
		
		camera.update();
		
		drawSprites();
		
		if(checkForStart())
		{
			startGame();
		}
		
	}
	
	private void startGame()
	{
		
		JSONObject obj = new JSONObject();
		obj.put("redirect", "gameScreen");
		
		for(Map.Entry<String, Player> entry : this.game.players.entrySet())
		{		
			this.game.mcp.hearbeatResponses.put(entry.getKey(), obj);
		}
	}
	
	private boolean checkForStart()
	{
		//look for some flag
		return this.game.startGame;
	}
	
	private void drawSprites()
	{
    	Gdx.gl.glClearColor(0, 0f, 0f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		this.spriteBatch.begin();
		DisplayHeadingText(this.spriteBatch);
		DisplayMCPAddressText(this.spriteBatch);
		displayPlayers(this.spriteBatch);
		this.spriteBatch.end();
	}
	
	private void DisplayHeadingText(SpriteBatch sb)
	{
		float xPos = (this.screenWidth/2) -  this.font.getBounds(TITLE).width/2;
		float yPos = (this.screenHeight) -  (this.screenHeight/7);
		
		this.font.draw(sb, TITLE, xPos, yPos);
	}
	
	private void DisplayMCPAddressText(SpriteBatch sb)
	{
		String text = "Connect To: " + this.game.mcp.getAddressForClients();
		
		float xPos = (this.screenWidth/2) -  this.font.getBounds(text).width/2;
		float yPos = (this.screenHeight) -  (this.screenHeight/7)*2;
		
		this.font.draw(sb, text, xPos, yPos);
	}
	
	private void displayPlayers(SpriteBatch sb)
	{
		float yPos = (this.screenHeight) -  (this.screenHeight/7)*3;
		
		String playerName = "";
		
		int i = this.game.players.size();
		
		for(Map.Entry<String, Player> entry : this.game.players.entrySet())
		{		
			playerName = (i) +") " +entry.getValue().getName();
			
			float xPos = (this.screenWidth/2) -  this.font.getBounds(playerName).width/2;
			float yPosAdjusted = yPos -  (i-1)*this.font.getBounds(playerName).height*2;
			
			this.font.draw(sb, playerName, xPos, yPosAdjusted);
			i--;
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		spriteBatch = new SpriteBatch();
		
		this.game.startGame = false;
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
