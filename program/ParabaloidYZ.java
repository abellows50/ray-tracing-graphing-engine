public class ParabaloidYZ implements Surface{
    // f(y,z) = a(y-b_y)^2 + b(z-b_z)^2 + b_x
    // x = f(y,z) = a(y-b_y)^2 + b(z-b_z)^2 + b_x


    double a,b;
    Vector bottom;

    public ParabaloidYZ(Vector point, double a, double b){
        this.bottom = point;
        this.a = a;
        this.b = b;
    }


    // this is the function that is used to determine if a point is on the surface of the sphere
    public double eval_point(double y, double z){
        return this.a*(y-this.bottom.getY())*(y-this.bottom.getY()) + this.b*(z-this.bottom.getZ())*(z-this.bottom.getZ()) + this.bottom.getX();
    }
    //how far is the point from the surface of the sphere
    public double err_from_point(Vector p){
        return eval_point(p.getY(), p.getZ()) - p.getX();
    }
}