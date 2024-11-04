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
		s.addSurface(new Sphere(90,0,0,100));
		s.addSurface(new Sphere(50,90,0,100));
		s.addLight(new Light(new Vector(0,0,0), new Color(255,255,255), 400));
		s.addLight(new Light(new Vector(-50,10,10), new Color(0,255,255), 200));
		//test for camera
		Camera c = new Camera(200,200, //width, height
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
