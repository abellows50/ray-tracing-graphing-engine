import java.lang.Math;
public class Vector{
    // This is a vector class
    // it is used to represent a point in 3d space
    // it is used to represent a direction in 3d space
    // it has methods to scale, add, and subtract vectors
    // magnitude of a vector
    // dot product of two vectors



    double x,y,z;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector v){
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public Vector(Vector start, Vector end){
        this(end.add(start.scale(-1)));
    }

    public double mag(){
        return Math.sqrt(this.x*this.x+
                        this.y*this.y+
                        this.z*this.z);
    }

    public Vector scale(double k){
        return new Vector(this.x*k, this.y*k, this.z*k);
    }

    public Vector add(Vector v){
        return new Vector(
            this.x + v.x,
            this.y + v.y,
            this.z + v.z
        );
    }

    public static double dist(Vector v1, Vector v2){
        Vector between = new Vector(v1, v2);
        return between.mag();
    }

    public double dot(Vector v){
        return this.x * v.x +
               this.y * v.y +
               this.z * v.z;
    }

    public Vector cross(Vector v){
        //cross product
        return new Vector(
            this.y*v.z - this.z*v.y,
            this.z*v.x - this.x*v.z,
            this.x*v.y - this.y*v.x
        );
    }

    public Vector norm(){
        return scale(1/this.mag());
    }

    public String toString(){
        return "<" + this.x + ", " + this.y + ", " + this.z + ">"; 
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }

    
}