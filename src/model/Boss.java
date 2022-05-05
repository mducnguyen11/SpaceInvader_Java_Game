package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Boss {
	    public int x = 0,y= 30,health = 10,width,height;
	    int vectorX = 1, changeVector = 0;
	    private Image image;
		public int getX() {
			return x;
		}

		public Boss() {
			super();
			this.x = 100;	
			this.width = 120;
			this.height = 70;
		    this.y = 30;
		    try {
				this.image = ImageIO.read(new File("./src/img/boss.png"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  
		}

		public Image getImage() {
			return image;
		}

		public void setImage(Image image) {
			this.image = image;
		}

		public int getHealth() {
			return health;
		}

		public void setHealth(int health) {
			this.health = health;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}
        
		public void setY(int y) {
			this.y = y;
		}
		
		public void move() {
			if(changeVector == 0) {
				setX(x + 2);
				if( x >= 450) {
					changeVector = 1;
				}
			}else {
				setX(x -2);
				if(x <= 0) {
					changeVector = 0;
				}
			}
			
		}
			
			
			
		
		
		
}
