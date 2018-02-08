package com.jendoliver.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.jendoliver.engine.entity.Drawable;
import com.jendoliver.engine.utils.Vector2;

public class Snake implements Drawable
{
	private SnakePart first;
	private SnakePart last;
	private List<SnakePart> body;
	private Vector2 speed;
	
	public Snake() { this(500, 500); }
	public Snake(int initialPositionX, int initialPositionY) { this(new Vector2(initialPositionX, initialPositionY)); }
	
	public Snake(Vector2 initialPosition)
	{
		speed = new Vector2(0, -1);
		body = new ArrayList<>();
		first = new SnakePart(initialPosition.X, initialPosition.Y, null);
		last = new SnakePart(initialPosition.X, initialPosition.Y + first.getSize(), first);
		body.add(first);
		body.add(last);
	}
	
	public Vector2 getSpeed() { return speed; }
	public void setSpeed(Vector2 speed) { this.speed = speed; }
	public int getSpeedX() { return speed.X; }
	public int getSpeedY() { return speed.Y; }
	public void setSpeedX(int speedX) { this.speed.X = speedX; }
	public void setSpeedY(int speedY) { this.speed.Y = speedY; }
	
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
		first.setPosX(first.getPosX() + first.getSize() * speed.X);
		first.setPosY(first.getPosY() + first.getSize() * speed.Y);
	}
	
	public void grow()
	{
		SnakePart aux = last;
		last = new SnakePart(aux.getPosX(), aux.getPosY(), aux);
		body.add(last);
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
