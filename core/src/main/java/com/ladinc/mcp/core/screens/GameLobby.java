package com.ladinc.mcp.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ladinc.mcp.core.MCPPoker;

public class GameLobby implements Screen{

	private int screenWidth;
    private int screenHeight;
    
    public BitmapFont font;
	
    private MCPPoker game;
    
    private OrthographicCamera camera;
    
    private SpriteBatch spriteBatch;
    
    private static final String TITLE = "MCP Texas Holdem";
    
    public GameLobby(MCPPoker game)
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
		
	}
	
	private void drawSprites()
	{
    	Gdx.gl.glClearColor(0, 0f, 0f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		this.spriteBatch.begin();
		DisplayHeadingText(this.spriteBatch);
		DisplayMCPAddressText(this.spriteBatch);
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
		float yPos = (this.screenHeight) -  (this.screenHeight/7)*3;
		
		this.font.draw(sb, text, xPos, yPos);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		spriteBatch = new SpriteBatch();
		
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
