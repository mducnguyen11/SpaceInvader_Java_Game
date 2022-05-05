package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Enemy {
	    public int x = 0,y= 30;int vectorX=0 , changeVector = 1 , moveDown = 0;
	    private int  m,speedDown = 5 ;
	    private int width,height;
	    private Image image;

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public int getX() {
			return x;
		}

		public Enemy() {
			super();
			this.x = 0;
			this.width = 35;
		    this.height = 35;
			this.m = (int) (Math.floor(Math.random() * 10) % 2);
			this.y = (int) (10 + m * Math.floor(Math.random() * 20)*3);
			try {
				this.image = ImageIO.read(new File("./src/img/ss.png"));
				
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

		public boolean checkEnemy() {
        	return y >= 500;
        }
		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}
        public void setRandomVector(int z) {
        	if( z > Math.abs(vectorX)) {
        		speedDown --;
        	}
        	if(m %2 ==1) {
        		vectorX = z ;
        	}else {
        		vectorX = -z ;
        	}
        }
		public void setY(int y) {
			this.y = y;
		}
		
		public void move() {			
			if(changeVector == 1 ) {
			   setX( x += vectorX);
			   if( x >= 470 ||x <= 0) {
				   changeVector = -1;
			   }			   
			}else {
				setX( x -= vectorX);
				if( x <= 0 || x >= 470) {
					changeVector = 1;
				}				
			}			
			if(moveDown % speedDown == 0) {			
				setY(y += Math.abs(vectorX));
				moveDown ++;
			}else {
				moveDown ++;
			}			
		}
		
		
		
}
