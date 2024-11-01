import java.lang.Math;
public class Sphere implements surface{
    double r;
    Vector center;

    public Sphere(double r, double x, double y, double z){
        this.r = r;
        this.center = new Vector(x,y,z);
    }

    public double eval_point(Vector p){
        return Math.pow((p.getX()-this.center.getX()),2)+
               Math.pow((p.getY()-this.center.getY()),2) +
               Math.pow((p.getZ()-this.center.getZ()),2);
    }

    public double err_from_point(Vector p){
        return eval_point(p) - r*r;
    }

}