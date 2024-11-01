import processing.core.PApplet;

public class App extends PApplet {

	public void settings() {
		size(500, 500);
	}

	public void setup(){
		frameRate(120);
		Ray r = new Ray(new Vector(0,0,0), new Vector(1,1,1));
		Sphere s = new Sphere(1.4,1.5,1.9,0.1);
		println(r.intersect(s));
	}
	public void draw(){
		background(64);
		ellipse(mouseX, mouseY, 20, 20);
	}
  
	public static void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "App" };
		PApplet.main(appletArgs);
    }
}
