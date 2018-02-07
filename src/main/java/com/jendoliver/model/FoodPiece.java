package com.jendoliver.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.jendoliver.engine.Drawable;
import com.jendoliver.engine.Vector2;

public class FoodPiece implements Drawable
{
	private Vector2 position;
	private int size = 10;
	
	public FoodPiece(int gameContainerWidth, int gameContainerHeight)
	{
		position = new Vector2();
		Random random = new Random();
		int randX = random.nextInt(gameContainerWidth);
		int randY = random.nextInt(gameContainerHeight);
		position.X = ((randX + 5) / 10) * 10;
		position.Y = ((randY + 5) / 10) * 10;
	}
	
	public Vector2 getPosition() 
	{
		return position;
	}

	@Override
	public void draw(Graphics g) 
	{
		g.setColor(Color.YELLOW);
		g.fillRect(position.X, position.Y, size, size);
	}
}