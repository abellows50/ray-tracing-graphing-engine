public class Color{
    private int r,g,b;
    
    public Color(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void add (Color c){
        return new Color((this.r + c.getR())%255, 
                         (this.g + c.getG())%255, 
                         (this.b + c.getB())%255);
    }

    //toString
    public String toString(){return "(" + this.r + ", " + this.g + ", " + this.b + ")";}

    //Setter and Getters
    public void setR(int r){this.r = r;}
    public void setG(int g){this.g = g;}
    public void setB(int b){this.b = b;}
    public int getR(){return this.r;}
    public int getG(){return this.g;}
    public int getB(){return this.b;}
}