package _05_Retro_Sun;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

/*
 * Goal: Create an animated retro sun image!
 * 
 * Follow the inline instructions below. Open RetroSun.html in this folder to
 * see final image and what each step should look like.
 */
public class RetroSun extends PApplet {
	static final int WIDTH = 1000;
	static final int HEIGHT = 1000;
	float x = 150;
	float y = 750;
	float w = 750;
	float h = 50;
	ArrayList <Rectangle> rects = new ArrayList <Rectangle>();
	ArrayList <Star> stars = new ArrayList <Star>();
	Reflection rf = new Reflection(250, 6, 178, 800, 1);
	// RGB colors
	int[] sunColors = { color(212, 202, 11), color(214, 198, 30), color(211, 170, 26), color(216, 157, 51),
			color(217, 124, 64), color(213, 104, 81), color(212, 51, 98), color(215, 29, 121), color(217, 11, 139),
			color(217, 0, 151) };

	int bgColor = color(31, 0, 48);

	@Override
	public void settings() {
		// 1. Set the size of your sketch to at least 800 width, 600 height
		setSize(1000, 1000);
	}

	@Override
	public void setup() {
		// 2. Set bgColor as the background color
		background(bgColor);
		for(int i = 0; i < 6; i++) {
		rects.add(new Rectangle(x, y + i*99, w, h));
		}
		Random ran = new Random();
		for(int i = 0; i < 200; i++) {
		stars.add(new Star(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), new Color(255,255,255)));
		}
	}

	@Override
	public void draw() {
		/*
		 * PART 1: Drawing the sun
		 */
		background(bgColor);
		for(int i = 0; i < 200; i++) {
			stars.get(i).draw();
		}
		// Draw an ellipse for the sun in the center of the window
		// Use fill(sunColors[0]) to make it yellow
		// Use noStroke() to remove the black outline
		fill(sunColors[0]);
		ellipse(500, 400, 700, 700);
		noStroke();
		// Do you see a yellow sun like in the 1st image?
		// If not, fix your code before proceeding.

		/*
		 * PART 2: Drawing a color gradient on the sun
		 *
		 * This will make the sun have gradually different colors from the top to bottom
		 */
		
		// Call the loadPixels() method to put all the pixel colors into
		// the pixels[] array
		// https://processing.org/reference/loadPixels_.html
		loadPixels();
		// We want to change the color of our sun so use an if statement
		// to check if the pixel is the color of the yellow circle.
		for (int i = 0; i < pixels.length; i++) {
			if (pixels[i] == sunColors[0]) {
				int y = i / width;
				float step = map(y, 100, 700, 0, 1);
				int newColor = interpolateColor(sunColors, step);
				pixels[i] = newColor;
			}
		}
		updatePixels();
		// If pixel[i] is the same color as the color of our circle (sunColors[0]),
		// we need to map the pixel to a color in our sunColors[] array
		// (see 2nd gradient image in RetroSun.html)

		// The top of the sun is yellow (sunColors[0]) and the bottom
		// of the sun is red (sunColors[sunColors.length - 1]

		// In order to get the right color, the y value from the top of
		// the sun to the bottom has to be mapped to a range from 0 to 1.
		// Use the map() function to do that:
		// int y = i / width;
		// float step = map(y, sunTopY, sunBottomY, 0, 1);

		// Call interpolateColor(sunColors, step) and save the color
		// variable that's returned

		// Set pixels[i] to the returned color

		// Call updatePixels() after your loop through all the pixels to
		// update the pixel colors
		// https://processing.org/reference/updatePixels_.html

		/*
		 * PART 3: Drawing the missing sections at the bottom of the sun
		 *
		 * The missing parts of the sun are created by drawing rectangles over the sun
		 * with the same color as the background.
		 */

		// Set the fill color to the background color

		// To draw each rectangle we need to find its x, y, width, height
		// *The y position can be any value within the sun:
		// float y = width / 2;
		// *The height can be any value you choose:
		// float h = 40;
		// *The x position can be the center of the sun's x position minus the radius:
		// float x = sunCenterX - sunRadius
		// *The width can be 2 times the radius
		// float w = 2 * sunRadius
		for(int i = 0; i < rects.size(); i++) {
		fill(bgColor);
		rect(rects.get(i).x, rects.get(i).y, rects.get(i).w, rects.get(i).h);
		rects.get(i).y-=3;
		if (rects.get(i).y < 150) {
			rects.get(i).y = 750;
		}
		rects.get(i).h = map(rects.get(i).y, 150, 700, 1, 40);
		
		}
		// Do you see a section missing from the sun like in the 3rd image?

		/*
		 * PART 4: Moving the missing sun sections
		 *
		 * To move a section upwards each rectangle's y value needs to decrease. To make
		 * the section get smaller, its height needs to also decrease.
		 */

		// Decrease the y variable of the rectangular section created in PART 3.
		// If there isn't a variable, declare a float variable OUTSIDE of the
		// draw function AND initialize it in the setup() function.
			

		// Do you see the rectangle moving upwards?

		// Pick a y positon to be the location when the sections stop moving up.
		// If the rectangle's y positon is above this, move the rectangle's
		// y position back to the bottom of the sun.

		// Does the rectangle move back to the bottom?

		// Decrease the the height of the rectangle as it moves upwards.
		// Similar to the y positon, a float variable for the height needs to be
		// created if it doesn't already exist.

		// Adjust the amount to decrease so that it disappears close to the top.
		// HINT: You can use the map() function again,
		// h = map(y, missingSectionTopY, missingSectionBottomY, 1, 40);

		// The map() function will make the value of h = 1 if y is at the top,
		// and h = 40 if y is at the bottom.

		/*
		 * PART 5: Managing the missing sun sections
		 *
		 * Using a list to manage moving multiple missing sun sections
		 */

		// Figure out how to create the other missing sun sections using the
		// code you wrote for the 1 missing sun section.
		// HINT: You can use the Rectangle class defined below to create
		// a list of Rectangles.
			
		/*
		 * PART 6: Adding extras
		 *
		 * If you want to make your retro sun look more unique, try adding reflections
		 * and stars. See RetroSun.html in this folder for some example classes
		 */
		fill(1, 1, 74);
		rect(0, 800, 1000, 200);
		rf.draw();
	}

	static public void main(String[] passedArgs) {
		PApplet.main(RetroSun.class.getName());
	}

	/*********************** DO NOT MODIFY THE CODE BELOW ********************/

	// Placed here so it can be used by all classes
	// Variable step should be between 0 and 1, inclusive
	int interpolateColor(int[] arr, float step) {
		int sz = arr.length;

		if (sz == 1 || step <= 0.0) {
			return arr[0];
		} else if (step >= 1.0) {
			return arr[sz - 1];
		}

		float scl = step * (sz - 1);
		int i = (int) scl;

		return lerpColor(arr[i], arr[i + 1], scl - i);
	}

	// Feel free to use this class to create a list of missing
	// sections in the sun, for example:
	// ArrayList<Rectangle> sections = new ArrayList<Rectangle>();
	class Rectangle {
		float x, y, w, h;

		Rectangle(float x, float y, float w, float h) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}
	class Star {
		  int x;
		  int y;
		  Color starColor;
		  float startAlpha;
		  float alpha;
		  float diameter;

		  Star(int x, int y, Color col) {
		    this.x = x;
		    this.y = y;
		    starColor = col;
		    this.diameter = random(0.1f, 3);
		    this.startAlpha = random(1, 200);
		    this.alpha = startAlpha;
		  }
		  
		  void setAlpha(int alpha){
		    this.alpha = constrain(alpha, startAlpha, 255);
		  }

		  void draw() {
		    noStroke();
		    fill(starColor.getRGB(), alpha);
		    float blink = random(0, 0.8f);
		    ellipse(x, y, diameter + blink, diameter + blink);
		  }
	}
	class Reflection {
		/*
		  // HSB colors
		  color[] barColors = {
		    color(285, 96.6, 23.1), 
		    color(312, 100, 42.7), 
		    color(340, 66.9, 60.4), 
		    color(11, 60.8, 62), 
		    color(340, 66.9, 60.4), 
		    color(312, 100, 42.7), 
		    color(285, 96.6, 23.1)
		  };
		*/
		  // RGB colors
		 int[] barColors = {
		    color(45, 2, 59), 
		    color(109, 0, 88), 
		    color(154, 51, 86), 
		    color(158, 79, 62), 
		    color(154, 51, 86), 
		    color(109, 0, 88), 
		    color(45, 2, 59)
		  };

		  int sunRadius;
		  int numReflectionBars;
		  int topX;
		  int topY;
		  int topWidth;
		  int bottomY;
		  int maxHeight;
		  float speed;
		  ArrayList <Rectangle> lowerBars;
		  
		  Reflection(int sunRadius, int numBars, int topX, int topY, float speed){
		    this.sunRadius = sunRadius;
		    this.topX = topX;
		    this.topY = topY;
		    this.speed = speed;

		    initialize(numBars);
		  }
		  
		  void initialize(int numBars){
		    this.numReflectionBars = numBars;
		    
		    topWidth = 2 * (sunRadius + sunRadius/3);
		    maxHeight = 10;
		    bottomY = topY + (numBars * 2 * maxHeight);
		    lowerBars = new ArrayList <Rectangle> ();
		    
		    // Setup bottom relection bars
		    int x = topX;
		    int y = topY;
		    int w = topWidth;
		    int h = maxHeight;
		    for ( int i = 0; i < numReflectionBars; i++ ) {   
		      y += (bottomY - topY) / numBars;
		      x += sunRadius / 16;
		      w -= 2 * (sunRadius / 16);

		      Rectangle r = new Rectangle(x, y, w, h);
		      lowerBars.add(r);
		    }
		  }
		  
		  void draw() {
		    strokeWeight(1);
		    
		    for ( Rectangle bar : lowerBars ) {
		      for ( int i = (int)bar.x; i < bar.x + bar.w; i++ ) {
		        float alphaMax = -255 - (bar.y - topY);
		        float alphaMin =  255 + (bar.y - topY);
		        float alpha = map(i, bar.x, bar.x + bar.w, alphaMin, alphaMax);
		        float step = map(i, bar.x, bar.x + bar.w, 0, 1);
		        int lc = interpolateColor(barColors, step);
		    
		        stroke(lc, 255 - abs(alpha));
		        line(i, bar.y, i, bar.y + bar.h);
		      }
		      
		      bar.y += speed;
		      bar.x += speed;
		      bar.w -= 2 * speed;

		      if( bar.y > bottomY ) {
		        // Bar at bottom, reset to top
		        
		        bar.x = topX;
		        bar.y = topY + maxHeight;
		        bar.w = topWidth;
		        bar.h = 1;
		      } else if( bar.y > bottomY - maxHeight ) {
		        // Bar near bottom
		        
		        bar.h -= speed;
		      } else if( bar.h < maxHeight ) {
		        // Bar height just reset and at top
		        
		        bar.y -= speed;
		        bar.h += speed;
		      }
		    }
		  }
	}
}
