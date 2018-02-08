package com.jendoliver.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jendoliver.engine.control.GameContainer;
import com.jendoliver.engine.utils.Vector2;
import com.jendoliver.model.FoodPiece;
import com.jendoliver.model.Snake;

public class Game
{
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	private static int GAME_SPEED = 100;
	private static int MIN_GAME_SPEED = 30;
	
	private static GameContainer container;
	
	private static Snake snake;
	private static FoodPiece foodPiece;
	
	public static void main(String[] args) 
	{
		/**
		 * INIT
		 */
		snake = new Snake(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
		JFrame frame = new JFrame("Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		container = new GameContainer(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_SPEED, MIN_GAME_SPEED) 
		{
			@Override
			public void paintComponent(Graphics g) 
			{
				snake.draw(g);
				if(foodPiece != null) foodPiece.draw(g); // FIXME
			}
		};
		frame.addKeyListener(new KeyListener() {
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
			@Override public void keyPressed(KeyEvent e) 
			{
				int keyCode = e.getKeyCode();
			    switch( keyCode ) 
			    { 
			        case KeyEvent.VK_UP:
			        	if( ! snake.getSpeed().equals(new Vector2(0, 1)))
			        		snake.setSpeed(new Vector2(0, -1));
			            break;
			        case KeyEvent.VK_DOWN:
			        	if( ! snake.getSpeed().equals(new Vector2(0, -1)))
			        		snake.setSpeed(new Vector2(0, 1));
			            break;
			        case KeyEvent.VK_LEFT:
			        	if( ! snake.getSpeed().equals(new Vector2(1, 0)))
			        		snake.setSpeed(new Vector2(-1, 0));
			            break;
			        case KeyEvent.VK_RIGHT :
			        	if( ! snake.getSpeed().equals(new Vector2(-1, 0)))
			        		snake.setSpeed(new Vector2(1, 0));
			            break;
			        default:
			        	break;
			     }
			}
		});
		frame.add(container);
		frame.setSize(container.getWindowWidth(), container.getWindowWidth());
		frame.setVisible(true);
		foodPiece = new FoodPiece((int)container.getSize().getWidth(), (int)container.getSize().getHeight());
		
		/**
		 * GAME LOOP
		 */
		while (true)
		{
			if(snake.collidesWithFood(foodPiece))
			{
				foodPiece = new FoodPiece((int)container.getSize().getWidth(), (int)container.getSize().getHeight());
				snake.grow();
				GAME_SPEED = GAME_SPEED > MIN_GAME_SPEED ? GAME_SPEED - 1 : GAME_SPEED;
			}
			snake.move();
			frame.repaint();
			if(snake.collidesWithItself() || snake.isOutOfScreen((int)container.getSize().getWidth(), (int)container.getSize().getHeight()))
				break;
			try {
				Thread.sleep(GAME_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
