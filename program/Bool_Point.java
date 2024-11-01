public class Bool_Point{
    private boolean intersect;
    private Vector p;

    Bool_Point(boolean intersect, Vector p){
        this.intersect = intersect;
        this.p = p;
    }

    boolean intersected(){
        return this.intersect;
    }

    Vector getP(){
        return this.p;
    }
}