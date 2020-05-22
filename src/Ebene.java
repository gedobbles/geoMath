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
    boolean[] spurpunkte = new boolean[3];
    spurpunkte[0] = false;
    spurpunkte[1] = false;
    spurpunkte[2] = false;

    if(n.x1 != 0){
      spurpunkte[0] = true;
      new Vektor(d/n.x1, 0, 0).drawE(g);
    }
    if(n.x2 != 0){
      spurpunkte[1] = true;
      new Vektor(0, d/n.x2, 0).drawE(g);
    }
    if(n.x3 != 0){
      spurpunkte[2] = true;
      new Vektor(0, 0, d/n.x3).drawE(g);
    }

    if(spurpunkte[0]&&spurpunkte[1]&&spurpunkte[2]){
      g.setColor(new java.awt.Color(0,0,100,100));
      int[] x = {(int) (250 - d/n.x1 * 10),(int) (250 + d/n.x2 * 20),(int) (250)};
      int[] y = {(int) (250 + d/n.x1 * 10),(int) (250),(int) (250 - d/n.x3 * 20)};
      g.fillPolygon(x,y,3);
    }
  }

  public void input(){
    GeoMath.print("Normalenform - 0\nVektoren     - 1\n");
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
      this.n = new Vektor(x1, x2, x3);
      this.d = d;
    }else{
      Vektor s, sp1, sp2;
      s = new Vektor();
      sp1 = new Vektor();
      sp2 = new Vektor();
      GeoMath.println("Stützvektor");
      s.input();
      GeoMath.println("Spannvektor 1");
      sp1.input();
      GeoMath.println("Spannvektor 2");
      sp2.input();
      this.n = sp1.kreuzprodukt(sp2);
      this.d = s.skalarprodukt(this.n);
    }
  }

}
