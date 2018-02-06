package com.jendoliver.model;

import java.util.ArrayList;
import java.util.List;
import com.jendoliver.view.Game;

public class Snake 
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
		last = new SnakePart(INITIAL_X, INITIAL_Y + SnakePart.SIZE, first);
		body.add(first);
		body.add(last);
	}
	
	public void move()
	{
		first.setPosX(SnakePart.SIZE * speedX);
		first.setPosY(SnakePart.SIZE * speedY);
		
		for(int i = 1; i < body.size(); i++)
		{
			SnakePart snakePart = body.get(i);
			SnakePart previous = snakePart.getPrevious();
			snakePart.setPosX(previous.getPosX());
			snakePart.setPosY(previous.getPosY());
		}
	}
}
