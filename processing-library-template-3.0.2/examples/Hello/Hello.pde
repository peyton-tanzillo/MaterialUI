import plt.MaterialUI.*;

UIBox box;
UIButton button;

void setup() {
  size(400,400);
  box = new UIBox(width/2, height/2, 100, 100, 3, #FF0000, this);
  button = new UIButton(300, 300, 50, 50, 3, #00FFFF, #009999, #990000, this);
}

void draw() {
  background(255);
  box.drawUI();
  button.drawUI();
}

void mousePressed() {
  button.buttonPressUpdate();
}

void mouseReleased() {
  button.buttonReleaseUpdate();
}