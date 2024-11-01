public class Camera{
    private Color[][] pixels;
    private Vector pixel_x_offset, pixel_y_offset;
    private Vector camera_to_center_pixel;

    private Vector eye;
    private Scene s;

    public Camera(int width, int height, 
                    Vector pixel_x_offset,
                    Vector pixel_y_offset,
                    Vector camera_to_center_pixel
                    Vector eye, Scene s){
        this.pixels = new Color[width][height];
        this.pixel_x_offset = pixel_x_offset;
        this.pixel_y_offset = pixel_y_offset;
        this.camera_to_center_pixel = camera_to_center_pixel;
        this.eye = eye;
        this.s = s;
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
}