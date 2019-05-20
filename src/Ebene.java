public class Ebene extends Geo{
  private Vektor n;   //für Normalenform
  private double d;
  
  public Ebene(){
    this(new Vektor(1,1,1), 1);
  }
  
  public Ebene(Vektor n, double d){
    this.n = n;
    this.d = d;
  }
  
  public Ebene(Vektor stuetz,Vektor spann1 ,Vektor spann2){
    this.n = spann1.kreuzprodukt(spann2);
    this.d = stuetz.skalarprodukt(this.n);
  }
  
  public Ebene(Vektor n, Vektor stuetz){
    this.n = n;
    this.d = stuetz.skalarprodukt(this.n);
  }
  
  public String toString(){
    return n.x1+" x1 + "+n.x2+" x2 + "+n.x3+" x3 = "+d;
  }
  
  public boolean punktprobe(Vektor v){
    if(this.n.skalarprodukt(v) == d)
      return true;
    return false;
  }
  
  public void draw(java.awt.Graphics g){
    
  }
  
  public void input(){
    
  }

}

