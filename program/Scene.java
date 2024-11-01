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
                if(connecter.intersect(s).intersected()){ //if the light intersected
                    intersected = true;
                    System.out.println("intersected");
                    break;
                }
            }
            if(!intersected){
                double dist = connecter.mag();
                c = c.add(l.getColor().scale(1/dist/dist));
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