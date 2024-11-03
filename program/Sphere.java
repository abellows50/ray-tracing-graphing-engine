import java.lang.Math;
public class Sphere implements Surface{
    double r;
    Vector center;

    public Sphere(double r, double x, double y, double z){
        this.r = r;
        this.center = new Vector(x,y,z);
    }

    // this is the function that is used to determine if a point is on the surface of the sphere
    public double eval_point(Vector p){
        return Math.pow((p.getX()-this.center.getX()),2)+
               Math.pow((p.getY()-this.center.getY()),2) +
               Math.pow((p.getZ()-this.center.getZ()),2);
    }
    //how far is the point from the surface of the sphere
    public double err_from_point(Vector p){
        return eval_point(p) - r*r;
    }

}