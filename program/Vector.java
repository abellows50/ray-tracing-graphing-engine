import java.lang.Math;
public class Vector{
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

    public double dot(Vector v){
        return this.x * v.x +
               this.y * v.y +
               this.z * v.z;
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