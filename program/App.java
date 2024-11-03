import processing.core.PApplet;

public class App extends PApplet {

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
				set(x, y, c);
			}
		}
	}

	public void test(){
		Scene s = new Scene();
		s.addLight(new Light(new Vector(5,5,5), new Color(255,255,255),50000000000));
		// s.addLight(new Light(new Vector(-5,-5,-5), new Color(255,255,255),50));
		// s.addSurface(new Sphere(100,2,2,245));
		s.addSurface(new Sphere(1000,2,2,2045));

		// System.out.println("Sphere is ")
		// s.addSurface(new Sphere(50,20,2,140));
		// s.addSurface(new Sphere(1,4,4,40));
		
		// Ray r = new Ray(new Vector(0,0,0), new Vector(1,1,1));
		// println("line 37 says: " + r.intersect(s));

		//test for camera
		Camera c = new Camera(400,400, //width, height
							  new Vector(0.005,0,0),  //pixel_x_offset
							  new Vector(0,0.005,0),  //pixel_y_offset
							  new Vector(0,0,10),  //camera_to_center_pixel
							  new Vector(0,0,0),  //eye
							  s); //scene
		
		c.develop();
		
		int[][] output = c.render();
		println(output[0]);
		this.render_to_image(output);
		System.out.println("done");
	}
}
