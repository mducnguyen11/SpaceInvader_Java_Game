package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import view.gamePanel;



public class gameFrame extends JFrame implements KeyListener {
          
	private gamePanel p ;
	
	public gameFrame() {		
		p = new gamePanel();	
		this.add(p);
		this.addKeyListener(this);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Space Invader");
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == 39) {
			
			p.moveRight();
		}
         if(e.getKeyCode() == 27) {
			p.exitGame();
		}
         if(e.getKeyCode() == 10) {
			
			p.startGame();
		}
		if(e.getKeyCode() == 37) {
			p.moveLeft();
		}
		if(e.getKeyCode() == 32) {
			p.shoot();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
