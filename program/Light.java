public class Light{
    private Vector position;
    private Color color;
    private double intensity;

    public Light(Vector position, Color color, double intensity){
        this.position = position;
        this.color = color;
        this.intensity = intensity;
    }

    //toString
    public String toString(){
        return "{" + this.position + ", " 
                + this.color + ", " + this.intensity + "}";
    }

    //getirs
    public Vector getPosition(){return this.position;}
    public Color getColor(){return this.color;}
    public double getIntensity(){return this.intensity;}

}