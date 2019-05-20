import java.io.*;

class GeoMath{
  static InputStreamReader isr;
  static BufferedReader br;
  
  public static void main(String[] args){
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);
    MathGUI m = new MathGUI();
  }  
  
  public static void println(Object o){
    System.out.println(o);
  }

  public static String scan(){
    try{
      return br.readLine();
    }catch (Exception e)  {
      return "";
    }     
  }
}

