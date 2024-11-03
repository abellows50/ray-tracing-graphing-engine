import java.util.ArrayList;
public class Scene{
    private ArrayList<Surface> surfaces;
    private ArrayList<Light> lights;
    
    public Scene(){
        this.surfaces = new ArrayList<Surface>();
        this.lights = new ArrayList<Light>();
    }


    public Color get_light_at_point(Vector p){
        Color c = new Color(0,0,0);
        for(Light l: this.lights){
            Ray connecter = new Ray(p,l.getPosition(),0);
            boolean intersected = false;
            for(Surface s: this.surfaces){
                Bool_Point bp = connecter.intersect(s);
                if(bp.intersected() && Vector.dist(bp.getP(),p) > 2){ //if the light intersected and is not at the orriginel point!

                    intersected = true;
                    System.out.println("intersected");
                    break;
                }
            }
            if(!intersected){
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