package com.jendoliver.model;

import com.jendoliver.engine.Vector2;

public class SnakePart
{
	private int size;
	private Vector2 position;
	private SnakePart previous;
	
	public SnakePart(int posX, int posY, SnakePart previous)
	{
		size = 10;
		this.position = new Vector2();
		this.position.X = posX;
		this.position.Y = posY;
		this.previous = previous;
	}
	
	public SnakePart(Vector2 position, SnakePart previous)
	{
		this.position = position;
		this.previous = previous;
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public Vector2 getPosition()
	{
		return position;
	}

	public int getPosX() 
	{
		return position.X;
	}

	public void setPosX(int posX) 
	{
		this.position.X = posX;
	}

	public int getPosY() 
	{
		return position.Y;
	}

	public void setPosY(int posY) 
	{
		this.position.Y = posY;
	}

	public SnakePart getPrevious() 
	{
		return previous;
	}
}
