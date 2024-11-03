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
		s.addLight(new Light(new Vector(0,-10,-10), new Color(0,255,255),2000));
		// s.addSurface(new Sphere(10,50,10,10));
		// s.addLight(new Light(new Vector(60,0,0), new Color(255,0,255),1500));
		// s.addLight(new Light(new Vector(-5,-5,-5), new Color(255,255,255),50));
		// s.addSurface(new Sphere(40,0,0,0));
		s.addSurface(new Sphere(40,0,0,100));
		s.addSurface(new Sphere(40,0,100,0));
		s.addSurface(new Sphere(40,100,0,0));
		// s.addSurface(new Sphere(40,0,0,100));
		// s.addSurface(new Sphere(40,100,0,0));
		
		//test for camera
		Camera c = new Camera(300,300, //width, height
							  new Vector(0.05,0,0),  //pixel_x_offset
							  new Vector(0,0.05,0),  //pixel_y_offset
							  new Vector(0,0,10),  //camera_to_center_pixel
							  new Vector(0,0,-400),  //eye
							  s); //scene
		
		System.out.println("Developing camera...");
		c.develop();
		System.out.println("Rendering Image...");
		int[][] output = c.render();
		this.render_to_image(output);
		System.out.println("done");
	}
}
