import java.lang.Math;
import java.util.ArrayList;
public class Ray{
    // This is a ray class
    // it is used to represent a ray in 3d space that travels
    // it has utility in calculating the intersection of a ray with a surface
    // extends to scene intersection


    private Vector origen;
    private Vector dir;
    private Vector step_vec;
    private double step = 0.01;
    private double THRESHOLD = 2;
    private int MAX_ITERATIONS = 10000000;
    private Color c;
    
    public Ray(Vector o, Vector d){
        this.origen = o;
        this.dir = d;
        step_vec = this.dir.norm().scale(step);
    }

    public Ray(Vector start, Vector end, int c){
        // this(start, end.add(start.scale(-1)));
        this(start, new Vector(start,end));
    }

    public double mag(){
        return this.dir.mag();
    }

    public Vector intersect(Scene s){
        ArrayList<Bool_Point> intersects = new ArrayList<Bool_Point>();
        for (Surface surf: s.getSurfaces()){
            intersects.add(this.intersect(surf));
        }

        int minIndex = -1;
        double minDist = 1/0.;

        for(int i = 0; i<intersects.size(); i++){
            Bool_Point bp = intersects.get(i);
            if(bp.intersected()){
                double dist = Vector.dist(bp.getP(),origen);
                if(dist<minDist){
                    minDist=dist;
                    minIndex=i;
                }
            }
        }
        if(minIndex<0){
            return null;
        }
        return intersects.get(minIndex).getP();
    }

    public Bool_Point intersect(Surface s){
        double lastErr = 1/0.;
        Vector curP = new Vector(this.origen);
        double curErr = s.err_from_point(curP);
        int c = 0;
        while (Math.abs(lastErr)>Math.abs(curErr)){
            if(c>MAX_ITERATIONS){
                System.out.println("Max Iterations Exceded...");
                break;
            }
            lastErr = curErr;
            curP = curP.add(step_vec);
            curErr = s.err_from_point(curP);
            // System.out.println("curErr: " + curErr + " pnt: " + curP);
            c++;
        }
        return new Bool_Point(-THRESHOLD < lastErr && lastErr < THRESHOLD,
                                curP.add(step_vec.scale(-1)));
    }

    public String toString(){
        return "{RAY: <<" + this.origen + ", " + this.dir + ">>}";
    }
}