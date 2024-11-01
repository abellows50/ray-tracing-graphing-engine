import java.lang.Math;
public class Ray{
    Vector origen;
    Vector dir;
    Vector step_vec;
    double step = 0.0001;
    double THRESHOLD = 0.0001;

    public Ray(Vector o, Vector d){
        this.origen = o;
        this.dir = d;
        step_vec = this.dir.norm().scale(step);
    }

    public boolean intersect(Sphere s){
        double lastErr = 1/0.;
        Vector curP = new Vector(this.origen);
        double curErr = s.err_from_point(curP);
        while (Math.abs(lastErr)>Math.abs(curErr)){
            lastErr = curErr;
            curP = curP.add(step_vec);
            curErr = s.err_from_point(curP);
            System.out.println("curErr: " + curErr + " pnt: " + curP);
        }
        return -1*THRESHOLD < lastErr && lastErr < THRESHOLD;
    }
}