public class Plane implements Surface{
    double mx, my;
    Vector point;

    public Plane(Vector point, double mx, double my){
        this.point = point;
        this.my = my;
        this.mx = mx;
    }

    // z = mx(x-x1) + my(y-y1) + z1

    // this is the function that is used to determine if a point is on the surface of the sphere
    public double eval_point(double x, double y){
        return this.mx*(x-this.point.getX()) + this.my*(y-this.point.getY()) + this.point.getZ();
    }
    //how far is the point from the surface of the sphere
    public double err_from_point(Vector p){
        return eval_point(p.getX(), p.getY()) - p.getZ();
    }
}