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
    if(n.x1 != 0)
      new Vektor(n.x1, 0, 0).drawE(g);
    if(n.x2 != 0)
      new Vektor(0, n.x2, 0).drawE(g);
    if(n.x3 != 0)
      new Vektor(0, 0, n.x3).drawE(g);
  }

  public void input(){
    GeoMath.print("Normalenform - 0\nVektoren     - 1");
    if(Integer.parseInt(GeoMath.scan())== 0){
      double x1, x2, x3, d;
      GeoMath.print("x1* ");
      x1 = Double.parseDouble(GeoMath.scan());
      GeoMath.print("+ x2* ");
      x2 = Double.parseDouble(GeoMath.scan());
      GeoMath.print("+ x3* ");
      x3 = Double.parseDouble(GeoMath.scan());
      GeoMath.print("= ");
      d = Double.parseDouble(GeoMath.scan());
      this(new Vektor(x1, x2, x3), d);
    }else{
      Vektor s, sp1, sp2;
      s = new Vektor();
      sp1 = new Vektor();
      sp2 = new Vektor();
      GeoMath.println("Stützvektor");
      s.input();
      GeoMath.println("Spannvektor 1");
      s.input();
      GeoMath.println("Spannvektor 2");
      s.input();
    }
  }

}
