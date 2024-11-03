public class Pixel{
    // a pixel is a point in space with a color
    // it is the basis for the camera's photo cell
    // the pixel can convert its color into a processing color



    private Color c;
    private Vector p;

    public Pixel(Color c, Vector p){
        this.c = c;
        this.p = p;
    }

    
    public Pixel(int x, int y, 
                int width, int height,
                Vector pixel_x_offset, 
                Vector pixel_y_offset, 
                Vector eye,
                Vector camera_to_center_pixel){
        Vector center = eye.add(camera_to_center_pixel);
        Vector x_offset = pixel_x_offset.scale(x-width/2);
        Vector y_offset = pixel_y_offset.scale(y-height/2);

        Vector pos = center.add(x_offset).add(y_offset);

        this.p = pos;
        this.c = null;
        
    }
    // getirs and setirs for c and p
    public Color getColor(){return this.c;}
    public Vector getPoint(){return this.p;}
    public void setColor(Color c){this.c = c;}
    public void setPoint(Vector p){this.p = p;}
    public String toString(){
        return "{<<" + this.c + ", " + this.p + ">>}";
    }
}