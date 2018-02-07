package com.jendoliver.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.jendoliver.engine.Drawable;
import com.jendoliver.view.Game;

public class Snake implements Drawable
{
	public static final int INITIAL_X = Game.WINDOW_WIDTH / 2;
	public static final int INITIAL_Y = Game.WINDOW_HEIGHT / 2;
	
	private SnakePart first;
	private SnakePart last;
	private List<SnakePart> body;
	private int speedX = 0;
	private int speedY = -1;
	
	public Snake()
	{
		body = new ArrayList<>();
		first = new SnakePart(INITIAL_X, INITIAL_Y, null);
		last = new SnakePart(INITIAL_X, INITIAL_Y + first.getSize(), first);
		body.add(first);
		body.add(last);
	}
	
	public void setSpeedX(int speedX) { this.speedX = speedX; }
	public void setSpeedY(int speedY) { this.speedY = speedY; }
	
	// TODO cambiar esta mierda por poner el ultimo delante del primero joakims aka kamut algorithm
	// FIXME evitar que se pueda volver patras
	public void move()
	{	
		for(int i = (body.size() - 1); i > 0; i--)
		{
			SnakePart snakePart = body.get(i);
			SnakePart previous = snakePart.getPrevious();
			snakePart.setPosX(previous.getPosX());
			snakePart.setPosY(previous.getPosY());
		}
		first.setPosX(first.getPosX() + first.getSize() * speedX);
		first.setPosY(first.getPosY() + first.getSize() * speedY);
	}
	
	public boolean collidesWithItself()
	{
		for(int i = 1; i < body.size(); i++)
		{
			SnakePart snakePart = body.get(i);
			if(first.getPosition().equals(snakePart.getPosition()))
				return true;
		}
		return false;
	}
	
	public boolean collidesWithFood(FoodPiece food)
	{
		return first.getPosition().equals(food.getPosition());
	}
	
	public boolean isOutOfScreen(int screenWidth, int screenHeight)
	{
		if(first.getPosX() + first.getSize() > screenWidth || first.getPosX() < 0)
			return true;
		else if(first.getPosY() + first.getSize() > screenHeight || first.getPosY() < 0)
			return true;
		return false;
	}

	@Override
	public void draw(Graphics g) 
	{
		g.setColor(Color.WHITE);
		for(SnakePart snakePart : body)
			g.fillRect(snakePart.getPosX(), snakePart.getPosY(), snakePart.getSize(), snakePart.getSize());
	}
}
