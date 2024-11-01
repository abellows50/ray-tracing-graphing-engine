public class Color{
    private int r,g,b;
    private double intensity;

    public Color(int r, int g, int b, double intensity){
        this.r = r;
        this.g = g;
        this.b = b;
        this.intensity = intensity;
    }

    public void add (Color c){
        return new Color((this.r + c.getR())%255, 
                         (this.g + c.getG())%255, 
                         (this.b + c.getB())%255,
                         this.intensity + c.getIntensity());
    }

    //toString
    public String toString(){return "(" + this.r + ", " + this.g + ", " + this.b + "," + this.intensity")";}

    //Setter and Getters
    public void setR(int r){this.r = r;}
    public void setG(int g){this.g = g;}
    public void setB(int b){this.b = b;}
    public void setIntensity(double i){this.intensity = i;}
    public int getR(){return this.r;}
    public int getG(){return this.g;}
    public int getB(){return this.b;}
    public double getIntensity(){return this.intensity;}
}