package com.jendoliver.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jendoliver.model.FoodPiece;
import com.jendoliver.model.Snake;

public class Game extends JPanel
{
	private static final long serialVersionUID = 5037252341523229752L;
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static int GAME_SPEED = 100;
	
	private static Snake snake;
	private static FoodPiece foodPiece;
	
	public static void main(String[] args) 
	{
		/**
		 * INIT
		 */
		snake = new Snake();
		JFrame frame = new JFrame("Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Game container = new Game();
		container.setBackground(Color.BLACK);
		frame.addKeyListener(new KeyListener() {
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
			@Override public void keyPressed(KeyEvent e) 
			{
				int keyCode = e.getKeyCode();
			    switch( keyCode ) 
			    { 
			        case KeyEvent.VK_UP:
			            snake.setSpeedX(0); snake.setSpeedY(-1);
			            break;
			        case KeyEvent.VK_DOWN:
			        	snake.setSpeedX(0); snake.setSpeedY(1);
			            break;
			        case KeyEvent.VK_LEFT:
			        	snake.setSpeedX(-1); snake.setSpeedY(0);
			            break;
			        case KeyEvent.VK_RIGHT :
			        	snake.setSpeedX(1); snake.setSpeedY(0);
			            break;
			        default:
			        	break;
			     }
			}
		});
		frame.add(container);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setVisible(true);
		foodPiece = new FoodPiece((int)container.getSize().getWidth(), (int)container.getSize().getHeight());
		
		/**
		 * GAME LOOP
		 */
		while (true)
		{
			snake.move();
			if(snake.collidesWithFood(foodPiece))
				foodPiece = new FoodPiece((int)container.getSize().getWidth(), (int)container.getSize().getHeight());
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
	
	public Game() { }

	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		snake.draw(g);
		if(foodPiece != null) foodPiece.draw(g); // FIXME
	}
}
