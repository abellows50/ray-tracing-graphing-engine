import processing.core.PApplet;
import processing.core.PGraphics;
public class App extends PApplet {
	PGraphics graphics;
	
	public void settings() {
		size(500, 500);
	}

	public void setup(){
		frameRate(120);
		test();
		// exit();
	}
	// public void draw(){
	// 	background(64);
	// 	ellipse(mouseX, mouseY, 20, 20);
	// }
  
	public static void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "App" };
		PApplet.main(appletArgs);
    }

	// public PImage render_to_image(int[][] render){
	// 	PImage img = createImage(render.length, render[0].length, RGB);
	// 	img.loadPixels();
	// 	int c = 0;
	// 	for(int[] row: render){
	// 		for(int i: row){
	// 			img.pixels[c]=i;
	// 			c++;
	// 		}
	// 	}
	// }

	public void render_to_image(int[][] render){
		for(int x = 0; x < render.length; x++){
			for(int y = 0; y < render[0].length; y++){
				int c = render[x][y];
				set(x+100, y+100, c);
			}
		}
	}

	public void test(){
		// background(0);
		Scene s = new Scene();
		//simple scene
		// s.addSurface(new Sphere(90,0,0,100));
		// s.addSurface(new Plane(new Vector(0,0,200), -1, -0.5));
		s.addSurface(new Plane(new Vector(0,0,200), 1, 2));
		s.addSurface(new Sphere(30,0,0,100));
		// s.addSurface(new ParabaloidXY(new Vector(0,0,-300), 20, 1));

		// s.addSurface(new ParabaloidYZ(new Vector(-20,0,-300), 20, 1));
		s.addLight(new Light(new Vector(0,0,0), new Color(0,255,255), 5000));
		// s.addSurface(new Sphere(10,0,0,0));
		// s.addLight(new Light(new Vector(0,0,-200), new Color(255,0,255), 500000));
		//test for camera

		Vector i = new Vector(0.05,0.0,0);
		Vector j = new Vector(0.0,0.05,0);
		Vector k = i.cross(j).norm().pos().scale(20);
		println(k);
		Vector origen = new Vector(0,0,-400);

		Camera c = new Camera(200,200, //width, height
							  i,  //pixel_x_offset
							  j,  //pixel_y_offset
							  k,  //camera_to_center_pixel
							  k.scale(-20),  //eye
							  s); //scene
		
		System.out.println("Developing camera...");
		c.develop();
		System.out.println("Rendering Image...");
		int[][] output = c.render();
		this.render_to_image(output);
		System.out.println("done");
	}
}
