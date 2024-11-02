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
		// test fxn for scene intersect
		s = new Scene();
		s.addSurface(new Sphere(1,2,2,2));
		s.addSurface(new Sphere(1,4,4,4));
		Ray r = new Ray(new Vector(0,0,0), new Vector(1,1,1));
		println("line 37 says: " + r.intersect(s));

		//test for camera
		Camera c = new Camera(10,10, new Vector(1,0,0), new Vector(0,1,0), new Vector(0,0,1), new Vector(0,0,0), s);
		c.develop();
		int[][] output = c.render();
		
	}
}
