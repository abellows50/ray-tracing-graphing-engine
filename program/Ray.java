import java.lang.Math;
public class Ray{
    private Vector origen;
    private Vector dir;
    private Vector step_vec;
    private double step = 0.01;
    private double THRESHOLD = 0.01;
    private int MAX_ITERATIONS = 100000000;

    public Ray(Vector o, Vector d){
        this.origen = o;
        this.dir = d;
        step_vec = this.dir.norm().scale(step);
    }

    public boolean intersect(Sphere s){
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
        System.out.println("c: "+c);
        return -THRESHOLD < lastErr && lastErr < THRESHOLD;
    }
}