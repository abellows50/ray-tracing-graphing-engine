import java.util.ArrayList;
public class Scene{
    private ArrayList<Surface> surfaces; //list of surfaces
    private ArrayList<Light> lights; //list of lights
    
    public Scene(){
        this.surfaces = new ArrayList<Surface>();
        this.lights = new ArrayList<Light>();
    }

    //get the color of the light at a point
    public Color get_light_at_point(Vector p){
        Color c = new Color(0,0,0);//start with no color
        for(Light l: this.lights){
            Ray connecter = new Ray(p,l.getPosition(),0);//create a ray from the point to the light
            boolean intersected = false;
            for(Surface s: this.surfaces){
                Bool_Point bp = connecter.intersect(s); //check if the light intersects with any surface
                if(bp.intersected() && Vector.dist(bp.getP(),p) > 2){ //if the light intersected and is not at the orriginel point!
                //this is a shaddow
                    intersected = true;
                    System.out.println("intersected");
                    break;
                }
            }
            if(!intersected){
                //inverse square law
                double dist = connecter.mag();
                // System.out.println(l.getColor().scale(l.getIntensity()/dist/dist));
                c = c.add(l.getColor().scale(l.getIntensity()/dist/dist));
            }
        }
        return c;
    }

    public void addSurface(Surface s){
        this.surfaces.add(s);
    }

    public void addLight(Light l){
        this.lights.add(l);
    }

    public ArrayList<Surface> getSurfaces(){
        return this.surfaces;
    }

    public ArrayList<Light> getLights(){
        return this.lights;
    }
}