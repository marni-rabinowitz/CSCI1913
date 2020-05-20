class PollyEsther  
{  
  public static void main(String[] args)  
  {  
    Poly p = new Poly().plus(3,5).plus(2,4).plus(2,3).plus(-1,2).plus(5,0);  
    Poly q = new Poly().plus(7,4).plus(1,2).plus(-4,1).plus(-3,0);  
    Poly z = new Poly();  
  
    System.out.println(p);                 // 3x⁵ + 2x⁴ + 2x³ - 1x² + 5x⁰  
    System.out.println(q);                 // 7x⁴ + 1x² - 4x¹ - 3x⁰  
    System.out.println(z);                 // 0  
  
    System.out.println(p.minus());         // -3x⁵ - 2x⁴ - 2x³ + 1x² - 5x⁰  
    System.out.println(q.minus());         // -7x⁴ - 1x² + 4x¹ + 3x⁰  
    System.out.println(z.minus());         // 0  
  
    System.out.println(p.plus(q));         // 3x⁵ + 9x⁴ + 2x³ - 4x¹ + 2x⁰  
    System.out.println(p.plus(z));         // 3x⁵ + 2x⁴ + 2x³ - 1x² + 5x⁰  
    System.out.println(p.plus(q.minus())); // 3x⁵ - 5x⁴ + 2x³ - 2x² + 4x¹ + 8x⁰  
  }  
}
