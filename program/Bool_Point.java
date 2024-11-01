public class Bool_Point{
    private boolean intersect;
    private Vector p;

    public Bool_Point(boolean intersect, Vector p){
        this.intersect = intersect;
        this.p = p;
    }

    public boolean intersected(){
        return this.intersect;
    }

    public Vector getP(){
        return this.p;
    }

    public String toString(){
        return "[" + this.intersect + ", " + this.p + "]";
    }
}