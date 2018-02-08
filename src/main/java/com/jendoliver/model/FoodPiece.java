package com.jendoliver.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.jendoliver.engine.entity.Drawable;
import com.jendoliver.engine.utils.Vector2;

public class FoodPiece implements Drawable
{
	private Vector2 position;
	private int size = 10;
	
	public FoodPiece(int gameContainerWidth, int gameContainerHeight)
	{
		position = new Vector2();
		Random random = new Random();
		int randX = random.nextInt(gameContainerWidth - 1);
		int randY = random.nextInt(gameContainerHeight - 1);
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