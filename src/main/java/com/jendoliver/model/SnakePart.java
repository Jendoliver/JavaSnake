package com.jendoliver.model;

public class SnakePart
{
	public static final int SIZE = 10;
	
	private int posX;
	private int posY;
	private SnakePart previous;
	
	public SnakePart(int posX, int posY, SnakePart previous)
	{
		this.posX = posX;
		this.posY = posY;
		this.previous = previous;
	}

	public int getPosX() 
	{
		return posX;
	}

	public void setPosX(int posX) 
	{
		this.posX = posX;
	}

	public int getPosY() 
	{
		return posY;
	}

	public void setPosY(int posY) 
	{
		this.posY = posY;
	}

	public SnakePart getPrevious() 
	{
		return previous;
	}
}
