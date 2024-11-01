import processing.core.PApplet;

public class App extends PApplet {

	public void settings() {
		size(500, 500);
	}

	public void setup(){
		frameRate(120);
		test();
		exit();
	}
	public void draw(){
		background(64);
		ellipse(mouseX, mouseY, 20, 20);
	}
  
	public static void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "App" };
		PApplet.main(appletArgs);
    }


	public void test(){
		//test function for scene, light, ray ...
		Scene s = new Scene();
		s.addSurface(new Sphere(1,2,3,4));
		s.addLight(new Light(new Vector(5,5,5), new Color(255,255,255),5));
		s.addLight(new Light(new Vector(-5,-5,-5), new Color(255,255,255),5));
		println("line 30 says: " + s.get_light_at_point(new Vector(-1,-1,3)));

	}
}
