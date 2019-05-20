class VTest{
  public static void main(String[] args){
    Vektor v1 = new Vektor(1,1,1);
    Vektor v2 = new Vektor(2,2,2);
    v1.addition(v2);
    System.out.println(v2);
    System.out.println(v2.betrag());
    System.out.println(v2.einheitsvektor());
    System.out.println(v2.einheitsvektor().betrag());
    Ebene e = new Ebene(v1,v1);
    System.out.println(e);
    System.out.println(e.punktprobe(v1));
  }

}

