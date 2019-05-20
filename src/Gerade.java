public class Gerade extends Geo{
  private Vektor stuetz;
  private Vektor richtung;
  
  public Gerade(){
    this(new Vektor(1,1,1), new Vektor(1,1,1));
  }
  
  public Gerade(Vektor stuetz, Vektor richtung){
    this.stuetz = stuetz;
    this.richtung = richtung;
  }
  
  public boolean punktprobe(Vektor v){
    double[] a = new double[3];
    a[0] = (v.x1 - this.stuetz.x1)/this.richtung.x1;
    a[1] = (v.x2 - this.stuetz.x2)/this.richtung.x2;
    a[2] = (v.x3 - this.stuetz.x3)/this.richtung.x3;
    
    if(a[0] == a[1] && a[1] == a[2])
      return true;
    return false;
  }
  
  public void draw(java.awt.Graphics g ){
    
  }
  
  public void input(){
    
  }

}

