package plt.MaterialUI;

import processing.core.*;

/**
 * @example Hello 
 */

public class UIButton extends PApplet{

	int posX;
	int posY;
	int elementWidth;
	int elementHeight;
	int shadowDepth;
	int elementColor;
	int normalColor;
	int highlightColor;
	int pressedColor;
	public boolean clicked;
	public final static String VERSION = "##library.prettyVersion##";
	PApplet parent;
	

	/**
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
	 * @param newNormalColor
	 * The color of the box when NOT moused over or NOT clicked
	 * @param newHighlightColor
	 * The color of the box when moused over but NOT clicked
	 * @param newPressedColor
	 * The color of the box when moused over and clicked
	 * @param newParent
	 * The Parent (use "this")
	 */
	public UIButton(int newPosX, int newPosY, int newElementWidth, int newElementHeight, int newShadowDepth, int newNormalColor, int newHighlightColor, int newPressedColor, PApplet newParent) {
		    posX = newPosX;
		    posY = newPosY;
		    elementWidth = newElementWidth;
		    elementHeight = newElementHeight;
		    elementColor = newNormalColor;
		    normalColor = newNormalColor;
		    highlightColor = newHighlightColor;
		    pressedColor = newPressedColor;
		    shadowDepth = newShadowDepth;
		    parent = newParent;
		    clicked = false;
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
		determineColor();
		parent.fill(elementColor);
		parent.rect(posX, posY, elementWidth, elementHeight, 3);
	}
	/**
	 * Returns if the mouse is over the element
	 * 
	 * @return boolean
	 */
	public boolean mouseOverElement() {
		if (parent.mouseX > (posX - elementWidth/2) && 
			parent.mouseX < (posX + elementWidth/2) && 
			parent.mouseY > (posY - elementHeight/2) && 
			parent.mouseY < (posY + elementHeight/2)) {
			return true;
	    } else {
	    	return false;
	    }
	  }
	
	/**
	 * Put in the mousePressed function
	 */
	public void buttonPressUpdate() {
		if (mouseOverElement()) {
			clicked = true;
		}
	}
	
	/**
	 * Put in the mouseReleased function
	 */
	public void buttonReleaseUpdate() {
		clicked = false;
	}
	
	/**
	 * Set the button's color to a new color
	 * @param newColor
	 * The color you want to set the button to
	 */
	public void setColor(int newColor) {
		elementColor = newColor;
	}
	
	public void determineColor() {
		if (mouseOverElement() || clicked) {
			if (clicked) {
				setColor(pressedColor);
			} else {
				setColor(highlightColor);
			}
		} else {
			setColor(normalColor);
		}
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