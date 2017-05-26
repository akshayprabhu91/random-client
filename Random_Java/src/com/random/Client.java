package com.random;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Client {		
		public static HttpCode httpCode;
		public static ArrayList<Integer> temp;

		public static void main(String[] args) throws Exception {
			httpCode = new HttpCode();
			
			temp = httpCode.randomNumberOfBaseTen(10, 1, 255);
			
			System.out.println();
			System.out.println("#### Generated Random Numbers");
			for(int index : temp){
				System.out.println(index);
			}
			
			System.out.println();
			System.out.println("#### Total Numbers generated");
			System.out.println(temp.size());
			
			System.out.println();
			System.out.println("#### 128x128 Bitmap Pic");
			
			int width = 128;
			int height = 128;
			
			BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			
			File f = null;
			
			for(int i = 0; i < height; i++){
			       for(int j = 0; j < width; j++){
			         int a = (int)(randomItem(temp));
			         int r = (int)(randomItem(temp));
			         int g = (int)(randomItem(temp));
			         int b = (int)(randomItem(temp));
			 
			         Color col = new Color(r, g, b);			         
		 
			         img.setRGB(j, i, col.getRGB());
			       }
			}
			
			f = new File("bitmap.bmp");
			ImageIO.write(img, "bmp", f);
		}
		
		public static int randomItem(ArrayList<Integer> mylist) {
			Random rand = new Random(); 
		    int randomInt = mylist.get(rand.nextInt(mylist.size()));
		    return randomInt;
		}
}
