public class Vektor extends Geo{
  public double x1, x2, x3;
  
  Vektor(){
    this(0,0,0);
  }
  
  Vektor(double x1, double x2, double x3){
    this.x1 = x1;
    this.x2 = x2;
    this.x3 = x3;
  }
       
  public double betrag(){
    return Math.sqrt(Math.pow(x1,2)+Math.pow(x2,2)+Math.pow(x3,2));
  }
  
  public String toString(){
      return "("+x1+"|"+x2+"|"+x3+")";
  }
  
  public Vektor setVektor(double x1, double x2, double x3){
    this.x1 = x1;
    this.x2 = x2;
    this.x3 = x3;
    return this;
  }
  
  public void addition(Vektor v){
    x1 = v.x1 + this.x1;
    x2 = v.x2 + this.x2;
    x3 = v.x3 + this.x3;
  }
  
  public Vektor multiplikation(double d){
    x1 = x1 *d;
    x2 = x2 *d;
    x3 = x3 *d;
    return this;
  }

  public Vektor einheitsvektor(){
    return new Vektor().setVektor(x1, x2, x3).multiplikation(1/this.betrag());
  }
  
  public double skalarprodukt(Vektor v){
    return this.x1 * v.x1 + this.x2 * v.x2 + this.x3 * v.x3;
  }
  
  public Vektor kreuzprodukt(Vektor v){
    return new Vektor(this.x2*v.x3-this.x3*v.x2,this.x3*v.x1-this.x1*v.x3,this.x1*v.x2-this.x2*v.x1);
  }

  public void draw(java.awt.Graphics g){
    g.setColor(new java.awt.Color(255,0,0));
    int x, y;
    x = (int) (250 - x1 * 10 + x2 * 20); 
    y = (int) (250 + x1 * 10 - x3 * 20);
    g.drawLine(x-3,y-3,x+3,y+3);
    g.drawLine(x-3,y+3,x+3,y-3);
  }
  
  public void input(){
    GeoMath.println("x1: ");
    this.x1 = Double.parseDouble(GeoMath.scan());
    GeoMath.println("x2: ");
    this.x2 = Double.parseDouble(GeoMath.scan());
    GeoMath.println("x3: ");
    this.x3 = Double.parseDouble(GeoMath.scan());
  }

}

