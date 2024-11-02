import processing.core.PApplet;

public class Camera extends PApplet{
    private Pixel[][] pixels;
    private Vector pixel_x_offset, pixel_y_offset;
    private Vector camera_to_center_pixel;

    private Vector eye;
    private Scene s;

    public Camera(int width, int height, 
                    Vector pixel_x_offset,
                    Vector pixel_y_offset,
                    Vector camera_to_center_pixel,
                    Vector eye, Scene s){
        this.pixels = new Pixel[width][height];
        this.pixel_x_offset = pixel_x_offset;
        this.pixel_y_offset = pixel_y_offset;
        this.camera_to_center_pixel = camera_to_center_pixel;
        this.eye = eye;
        this.s = s;

        for(int x = 0; x<pixels.length; x++){
            for(int y = 0; y<pixels[x].length; y++){
                pixels[x][y] = new Pixel(x, y, width, height, 
                                        pixel_x_offset, 
                                        pixel_y_offset, 
                                        eye,
                                        camera_to_center_pixel);
                System.out.println(pixels[x][y]);
            }
        }
    }
    
    public Camera(int width, 
                 int height, 
                 Vector camera_to_center_pixel, 
                 Scene s){
        this(width, height, 
            new Vector(1,0,0), 
            new Vector(0,1,0), 
            camera_to_center_pixel, 
            new Vector(0,0,0),  
            s);
    }
    
    public void develop(){
        for(Pixel[] prow: this.pixels){
            for (Pixel p: prow){
                Ray dir = new Ray(this.eye, p.getPoint(), 0);
                Vector intersect = dir.intersect(this.s);
                if(intersect != null){
                    p.setColor(s.get_light_at_point(intersect));
                }
                else{
                    p.setColor(new Color(0,0,0));
                }
            }
        }
    }



    public int[][] render(){
        int[][] output = new int[this.pixels.length][this.pixels[0].length];
        for(int x = 0; x<this.pixels.length; x++){
            for (int y = 0; y<this.pixels[0].length; y++){
                output[x][y] = this.pixels[x][y].getColor().getColor();
            }
        }
        return output;
    }

    
}