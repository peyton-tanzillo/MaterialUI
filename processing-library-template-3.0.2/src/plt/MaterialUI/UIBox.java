package plt.MaterialUI;

import processing.core.*;

/**
 * @example Hello 
 */

public class UIBox extends PApplet{

	int posX;
	int posY;
	int elementWidth;
	int elementHeight;
	int shadowDepth;
	int elementColor;	
	public final static String VERSION = "##library.prettyVersion##";
	PApplet parent;
	

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the Library.
	 * 
	 * @example Hello
	 * @param newPosX 
	 * The x position of the box
	 * @param newPosY 
	 * The y position of the box
	 * @param newElementWidth
	 * The width of the box
	 * @param newElementHeight
	 * The height of the box
	 * @param newShadowDepth
	 * The depth of the shadow
	 * @param newElementColor
	 * The color of the box
	 * @param newParent
	 * The Parent (use "this")
	 */
	public UIBox(int newPosX, int newPosY, int newElementWidth, int newElementHeight, int newShadowDepth, int newElementColor, PApplet newParent) {
		    posX = newPosX;
		    posY = newPosY;
		    elementWidth = newElementWidth;
		    elementHeight = newElementHeight;
		    elementColor = newElementColor;
		    shadowDepth = newShadowDepth;
		    parent = newParent;
	}	
	
	private void welcome() {
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
	}

	/**
	 * Draw the shadow around the box
	 */
	public void drawShadow() {
		parent.noStroke();
		for (float i = 50; i > 0; i--) {
			parent.rectMode(CENTER);
			parent.fill(0, 1);
			parent.rect(posX, posY, elementWidth + i/5, elementHeight + i/5, 8);
		}
	}

	/**
	 * Draw the box element
	 */
	public void drawUI() {
		parent.rectMode(CENTER);
		drawShadow();
		parent.fill(elementColor);
		parent.rect(posX, posY, elementWidth, elementHeight, 3);
	}

	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

}