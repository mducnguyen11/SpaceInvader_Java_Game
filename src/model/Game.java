package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
	     
	   private boolean running,win;
	   Timer timer;
	   boolean start = false;
	   private Character crt;
	   ArrayList<Bullet> Bt;
	   ArrayList<Enemy> Em;
	   ArrayList<Rocket> rt;
	   private Boss boss;
	   int rocketTime = 0;
	   int speed = 3, score = 0;
	   boolean acpStartNewGame = false;
	   
	   
       public Game() {    	   
    	   running = true;
    	   acpStartNewGame = true;
    	   start = false;
    	   Em  = new ArrayList<Enemy>();
    	   rt= new ArrayList<Rocket>();
    	   crt = new model.Character();
    	   boss = new Boss();    	   
    	   Bt = new ArrayList<Bullet>();
    	   win = false;
    	   score = 115;
    	   timer = new Timer(5,this);
   		   timer.start();  		 
       }
       
       
       @Override
    public void paint(Graphics g) {
    	// TODO Auto-generated method stub
    	if(start) {
        	g.drawImage(crt.getImage(),crt.getX(),crt.getY(),crt.getWidth(),crt.getHeight(),null);        
            for(Bullet x : Bt) {        		
        		g.drawImage(x.getImage(),x.getX(), x.getY() - 15,x.getWidth(),x.getHeight(),null);
        		//g.drawImage(x.getImage(),x.getX(), x.getY() - 15,x.getWidth(),x.getHeight(),null);
        	}
        	g.setColor(Color.white);
        	for(Enemy c : Em) {
        		g.drawImage(c.getImage(),c.getX(), c.getY(), c.getWidth(), c.getHeight(),null);
        	}
        	g.setColor(Color.white);
            g.drawString("Ammo depot : " + score,390, 17);            
            if(rt.size() > 0) {
            	for(Rocket v: rt) {
                	g.drawImage(v.getImage(),v.getX(), v.getY(), v.getWidth(), v.getHeight(),null);
                }
            }
            if(speed > 2 && running) {
            	g.setColor(Color.red);
            	for(int i = 0;i<boss.getHealth();i++) {
            		g.drawRect(boss.getX() +15 + i*10,boss.getY() -5 , 6, 6);
            	}
            	g.drawImage(boss.getImage(),boss.getX(),boss.getY(), boss.getWidth(), boss.getHeight(),null);
            }            
            if(!running) {
            	Font font = new Font("Serif", Font.PLAIN, 30);
                g.setFont(font);
                g.setColor(Color.white);
            	if(win) {
            		g.drawString("Win :))))", 150, 230);
            		g.drawString("Enter to start new game ", 150, 270);
            	}else {
            		g.drawString("Lose :))))", 150, 230);
            		g.drawString("Enter to start new game ", 150, 270);
            		g.drawString("Esc to exit game ", 150, 320);
            	}
            }
        	
    	}else {
    		g.setColor(Color.YELLOW);
        	Font font = new Font("Serif", Font.PLAIN, 40);
            g.setFont(font); 
            g.drawString("Space Invader", 150, 160);
            Font fontx = new Font("Serif", Font.PLAIN, 20);
            g.setColor(Color.WHITE);
            g.setFont(fontx);
        	g.drawString("<-  and  ->  to move", 150, 200);
        	g.drawString("Space to shoot", 160, 240);
        	g.drawString("Enter to start new game ", 160, 280);
        	g.drawString("Esc to exit game ", 160, 320);
        	g.drawImage(crt.getImage(),160,340,crt.getWidth() * 3,crt.getHeight() *3,null);            
    	}
    	
    
    }
       
       
       public void exitGame() {
    	   
    	   if(acpStartNewGame) {
    		   System.exit(1);
    	   }
       }
       
       public void clearGame() {
    	   Em.clear();
    	   rt.clear();
    	   Bt.clear();
       }
       public void createNewGame() {
    	   Em  = new ArrayList<Enemy>();
    	   rt= new ArrayList<Rocket>();
    	   crt = new model.Character();
    	   boss = new Boss();
    	   acpStartNewGame = false;
    	   this.speed = 2;
    	   this.score = 120;
    	   if(win) {
    		   win = false;
    	   }
    	   for(int i = 0;i<5;i++) {  
    		   Enemy z = new Enemy();
    		   z.setX(30 + i*70);
    		   Em.add(z);
    	   }
    	   Bt = new ArrayList<Bullet>();
       }
       public void startNewGame() {
    	   if(acpStartNewGame) {
    		   this.clearGame();
        	   this.createNewGame();
        	   this.start = true;
    	   }
    	   if(!running) {
    		   running = true;
    	   }
    	  }
       
       public void shoot() {
     	  
     	   if(running) {
     		  if(score == 0) {
        		   running = false;
        		   acpStartNewGame = true;
        	   }else
        		  score--;
       	   Bullet xx = new Bullet(crt.getX() + 15);
       	  
       	   Bt.add(xx);
     	   }
    	   
       }
       public void ttt() {
    	   System.out.println(11);
       }
       public void checkEnemy() {
    	   
    	   for(int j = 0 ; j < Em.size();j++) {

				 if(Em.get(j).checkEnemy()) {
					 running = false;
				 }
				 }
       }
       
        public void newEnemy() {
        	speed ++;
        	for(int i = 0;i<5;i++) {  
	    		   Enemy z = new Enemy();
	    		   z.setX(30 + i*50);
	    		   Em.add(z);
	    	   }
			 }
       
       
       
       
       public void moveRight() {
       	if(running) {
       		crt.moveRight();
       	}
       	}
       public void moveLeft() {
    	  if(running) {
    		 crt.moveLeft();
    	  }
    	   
       }
       
       public void enemyMove() {
    	   for(int j = 0 ; j < Em.size();j++) {

				  Em.get(j).setRandomVector(speed);
				  Em.get(j).move();
				  
       }
       }
       public void checkShootEnemy() {
    	   for(int j = 0 ; j < Em.size();j++) {
				for(int i = 0 ; i<Bt.size();i++) {  
					
						if(Bt.get(i).getY() <= Em.get(j).getY()+25 &&
						   Em.get(j).getY() -Bt.get(i).getY() <= Bt.get(i).getHeight()  &&
						   Bt.get(i).getX() >= Em.get(j).getX()  &&
						   Bt.get(i).getX() <= Em.get(j).getX() + Em.get(j).getWidth()-5) {
							Em.remove(j);
							Bt.remove(i);
							repaint();
							break;
						    
						
					}else {
						
					}
				}
			}
       }
       
       
       public void checkBossShoot() {
    	  
    	   for(Bullet b : Bt) {
    		  
    		   if(b.getY() <= boss.getY() + boss.getHeight() &&
    		      b.getX()+b.getWidth() >= boss.getX() &&
    		      b.getX() <= boss.getX()+boss.getWidth() ) {
    			   boss.setHealth(boss.getHealth() -1);
    			   Bt.remove(b);
    			   break;
    		   }
    	   }
    	   if(boss.getHealth() == 0) {
    		   running = false;
    		   acpStartNewGame = true;
    		   win = true;
    		   repaint();
    	   }    	   
       }
       
       public void bulletMove() {
    	   for(int i = 0 ; i<Bt.size();i++) {
		        
				if(Bt.get(i).checkBullet()) {
					
					Bt.remove(i);
				}else {
					Bt.get(i).move();
				}
			}
       }
       
       public void rocketMove() {
    	   for(Rocket x :rt) {
				
				x.move();
				if(x.checkRt()) {
					rt.remove(x);
					break;
				}
			}
       }
       
       public void checkRocketShoot() {
    	   for(Rocket c:rt) {
    		   if(c.getY() + c.getHeight() >= 450 &&
    			  c.getY() - 450 <= 0 && c.getX() >= crt.getX() &&
    			  c.getX() <=crt.getX() +50) {
    			   running = false;
    			   acpStartNewGame = true;
    		   }
    	   }
    	   
       }
       public void newRandomRocket() {
    	   if(rocketTime % 35 == 0) {
				Rocket zz = new Rocket();
				rt.add(zz);
				
			}
       }
	@Override
       public void actionPerformed(ActionEvent e) {		
	   if(running) {		    
			if(speed <= 2) {				
				if(Em.size() > 0) {	
					    bulletMove();
					    checkShootEnemy();
				        enemyMove();
				        checkEnemy();
				}else {
					newEnemy();
				}
			}else {
				Em.clear();
				bulletMove();
				boss.move();
				checkBossShoot();
				checkRocketShoot();
				newRandomRocket();
				rocketTime++;
				rocketMove();
				}
	   }		
		repaint();		
	}

	
       
}
