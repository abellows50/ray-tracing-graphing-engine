public class ParabaloidXY implements Surface{
    // f(x,y) = a(x-b_x)^2 + b(y-b_y)^2 + b_z
    // z = a(x-b_x)^2 + b(y-b_y)^2 + b_z


    double a,b;
    Vector bottom;

    public ParabaloidXY(Vector point, double a, double b){
        this.bottom = point;
        this.a = a;
        this.b = b;
    }


    // this is the function that is used to determine if a point is on the surface of the sphere
    public double eval_point(double x, double y){
        return this.a*(x-this.bottom.getX())*(x-this.bottom.getX()) + this.b*(y-this.bottom.getY())*(y-this.bottom.getY()) + this.bottom.getZ();
    }
    //how far is the point from the surface of the sphere
    public double err_from_point(Vector p){
        return eval_point(p.getX(), p.getY()) - p.getZ();
    }
}