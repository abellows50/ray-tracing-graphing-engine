import processing.core.PApplet;

public class Color extends PApplet{
    private double r,g,b;

    public Color(double r, double g, double b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color add (Color c){
        // return new Color((this.r + c.getR())%255, 
        //                  (this.g + c.getG())%255, 
        //                  (this.b + c.getB())%255);
        return new Color(this.r + c.getR(), this.g + c.getG(), this.b + c.getB());
        
    }

    public Color scale(double s){
        return new Color((this.r*s), (this.g*s), (this.b*s));
    }

    //toString
    public String toString(){return "(" + this.r + ", " + this.g + ", " + this.b +")";}

    //Setter and Getters
    public void setR(int r){this.r = r;}
    public void setG(int g){this.g = g;}
    public void setB(int b){this.b = b;}
    public double getR(){return this.r;}
    public double getG(){return this.g;}
    public double getB(){return this.b;}
    public int getColor(){return color((int)this.r,(int)this.g,(int)this.b);}
}