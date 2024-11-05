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
    private double THRESHOLD = 1;
    private int MAX_ITERATIONS = 100000;
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
        int c = 0;
        Vector curP = new Vector(this.origen);
        while (true){
            if(c>MAX_ITERATIONS){
                // System.out.println("Max Iterations Exceded...");
                return new Bool_Point(false, null);
            }
            double curErr = s.err_from_point(curP);
            if(Math.abs(curErr) < THRESHOLD){
                // System.out.println("Intersected at " + curP);
                return new Bool_Point(true, curP);
            }
            curP = curP.add(this.step_vec);
            c++;
        }
    }
    public Bool_Point intersectIter(Surface s){
        int c = 0;
        Vector curP = new Vector(this.origen);
        while (true){
            if(c>MAX_ITERATIONS){
                // System.out.println("Max Iterations Exceded...");
                return new Bool_Point(false, null);
            }
            double curErr = s.err_from_point(curP);
            if(Math.abs(curErr) < THRESHOLD){
                // System.out.println("Intersected at " + curP);
                return new Bool_Point(true, curP);
            }
            curP = curP.add(this.step_vec);
            c++;
        }
    }

    public String toString(){
        return "{RAY: <<" + this.origen + ", " + this.dir + ">>}";
    }
}