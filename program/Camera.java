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
                    Vector eye, 
                    Scene s){
        this.pixels = new Pixel[width][height];
        this.pixel_x_offset = pixel_x_offset;
        this.pixel_y_offset = pixel_y_offset;
        this.camera_to_center_pixel = camera_to_center_pixel;
        this.eye = eye;
        this.s = s;

        for(int x = 0; x<pixels.length; x++){
            for(int y = 0; y<pixels[x].length; y++){
                pixels[x][y] = new Pixel(x, y, 
                                        width, height, 
                                        pixel_x_offset, 
                                        pixel_y_offset, 
                                        eye,
                                        camera_to_center_pixel);
                            
                // System.out.println(pixels[x][y]);
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
    
    // develop the camera given the scene
    public void develop(){
        int cnt = 0;
        
        for(int x=0; x<this.pixels.length; x++){
            println("ROW " + x + " of " + this.pixels.length);
            for(int y=0; y<this.pixels[x].length; y++){
                Pixel p = this.pixels[x][y];
                Ray dir = new Ray(this.eye, p.getPoint(), 0);
                // println(dir);
                
               Vector intersect = dir.intersect(this.s);
                // Bool_Point bp = dir.intersect(this.s.getSurfaces());
                // Vector intersect = null;
                // if(bp.intersected()){
                //     intersect = bp.getP();
                // }
                if(intersect != null){
                    // SHOULD BE
                    Color c = this.s.get_light_at_point(intersect);
                    // println(c);
                    // c = c.scale(100000.);
                    p.setColor(c);
                }
                else{
                    p.setColor(new Color(0,0,0));
                }
            }
        }
        
        // for(Pixel[] prow: this.pixels){
        //     println("ROW " + cnt + " of " + this.pixels.length);
        //     cnt++;
        //     for (Pixel p: prow){
        //         Ray dir = new Ray(this.eye, p.getPoint(), 0);
        //         // println(dir);
                
        //         //SHOULD BE: Vector intersect = dir.intersect(this.s);
        //         Bool_Point bp = dir.intersect(this.s.getSurfaces().get(0));
        //         Vector intersect = null;
        //         if(bp.intersected()){
        //             intersect = bp.getP();
        //         }
        //         if(intersect != null){
        //             // SHOULD BE
        //             Color c = this.s.get_light_at_point(intersect);
        //             // println(c);
        //             // c = c.scale(100000.);
        //             p.setColor(c);

        //             // END SHOULD BE

        //             // DEBUG
        //             // Color c = new Color(255,0,0);
        //             // p.setColor(c);
        //             // END DEBUG

        //             // println("Intersect " + intersect + 
        //                     // "//LIGHT: " + p.getColor());
        //         }
        //         else{
        //             p.setColor(new Color(0,0,0));
        //         }
        //     }
        // }
    }



    public int[][] render(){
        int[][] output = new int[this.pixels.length][this.pixels[0].length];
        for(int x = 0; x<this.pixels.length; x++){
            for (int y = 0; y<this.pixels[0].length; y++){
                // println(this.pixels[x][y].getColor());
                output[x][y] = this.pixels[x][y].getColor().getColor();
            }
        }
        return output;
    }

    
}