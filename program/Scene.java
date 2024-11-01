import java.util.ArrayList;
public class Scene{
    private ArrayList<Surface> surfaces;
    private ArrayList<Light> lights;
    
    public Scene(){
        this.surfaces = new ArrayList<Surface>();
        this.lights = new ArrayList<Light>();
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