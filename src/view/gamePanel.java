package view;
import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.Game;

public class gamePanel extends JPanel implements ActionListener{
    
	private Game ct;
	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 500;
	

	
	Timer timer;
	
	int x , y ;
	
	
	
	public gamePanel(){
		
	    ct = new Game();		   	   
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.setBackground(Color.black);		
		//backgroundImage = new ImageIcon("space.png").getImage();
		timer = new Timer(10, this);
		timer.start();
		this.setVisible(true);
	}
    public void moveRight() {
    	ct.moveRight();
    	repaint();
    	
    }
    
    public void exitGame() {
    	ct.exitGame();
    }
    public void startGame() {
       
    
    	ct.startNewGame();
    	repaint();
    	
    }
    public void moveLeft() {
    	ct.moveLeft();
    	repaint();
    }
    public void shoot() {
    	ct.shoot();
    	repaint();
    }
	public void paint(Graphics g) {
		
		super.paint(g); // paint background
		
		
		
				ct.paint(g);
			
		
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		repaint();
		
	}
	
	
}