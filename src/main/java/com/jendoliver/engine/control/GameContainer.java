package com.jendoliver.engine.control;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GameContainer extends JPanel
{
	private static final long serialVersionUID = -5455885489325161528L;
	
	private int gameSpeed;
	private int minGameSpeed;
	
	// TODO implement game speed logic
	
	public GameContainer() { }
	
	public GameContainer(int windowWidth, int windowHeight, int gameSpeed, int minGameSpeed) 
	{
		setWindowWidth(windowWidth);
		setWindowHeight(windowHeight);
		this.gameSpeed = gameSpeed;
		this.minGameSpeed = minGameSpeed;
	}
	
	public int getWindowWidth() 
	{
		return (int)this.getSize().getWidth();
	}
	
	public void setWindowWidth(int windowWidth) 
	{
		this.setSize(windowWidth, getWindowHeight());
	}
	
	public int getWindowHeight() 
	{
		return (int)this.getSize().getHeight();
	}
	
	public void setWindowHeight(int windowHeight) 
	{
		this.setSize(getWindowWidth(), windowHeight);
	}
	
	public int getGameSpeed() 
	{
		return gameSpeed;
	}
	
	public void setGameSpeed(int gameSpeed) 
	{
		this.gameSpeed = gameSpeed;
	}
	
	public int getMinGameSpeed() 
	{
		return minGameSpeed;
	}
	
	public void setMinGameSpeed(int minGameSpeed) 
	{
		this.minGameSpeed = minGameSpeed;
	}
	
	@Override
	public abstract void paintComponent(Graphics g);
//	{
//		container.paintComponent(g);
//		snake.draw(g);
//		if(foodPiece != null) foodPiece.draw(g); // FIXME
//	}
}
