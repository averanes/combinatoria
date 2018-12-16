package combinatoria;

public class Combinaciones {

    static char[] elementos = {'a', 'b', 'c', 'd', 'e', '6', '7'}; //elementos a combinar
    static int cantidad = 5; //cantidad de elementos
    static int numero = 3; //numero de elementos a combinar


    public static void main(String[] args) {
      
       // combinar_2(0);
      devolverSoluciones(numero, 0,new char[numero], -1);
      //devolverSoluciones_R(numero, 0,new char[numero], 0);
     }

   /**Imprime las combinaciones C(c,n) que se pueden hacer con el arreglo elementos
 sin repetir ningun elemento en cada grupo                   0                                   -1*/ 
   public static void devolverSoluciones(int faltan, int addPosSolucion, char[] solucion, int iterador){
      if(faltan == 0){
       for (int j = 0; j < solucion.length ; System.out.print(solucion[j++]));//imprimo la lista
            System.out.println(); //linea en blanco
      }
      else for(int i=iterador+1; (i+faltan)<=cantidad ; i++){
         solucion[addPosSolucion]=elementos[i]; 
         devolverSoluciones(faltan-1, addPosSolucion+1, solucion, i);

     }
  }
   
    /**Imprime las combinaciones C(c,n) que se pueden hacer con el arreglo elementos
     repitiendo elementos en los grupos */
  public static void devolverSoluciones_R(int faltan, int addPosSolucion, char[] solucion, int iterador){
      if(faltan == 0){
       for (int j = 0; j < solucion.length ; System.out.print(solucion[j++]));//imprimo la lista
            System.out.println(); //linea en blanco
      }
      else for(int i=iterador; (i+faltan)<=cantidad ; i++){
         solucion[addPosSolucion]=elementos[i]; 
         devolverSoluciones_R(faltan-1, addPosSolucion+1, solucion, i); 
     }
  }
 
    /**Imprime las combinaciones C(c,2)->(pares de elementos) 
    * que se pueden hacer con el arreglo elementos*/
  public static void combinar_2(int elemPiv) {
        if ((elemPiv + 2) <= cantidad) {
            for (int i =  elemPiv ; i <= (cantidad - 2); i++, System.out.print("  ")) 
                System.out.print(elementos[elemPiv]+""+elementos[1+i]);
            
         System.out.println();
         combinar_2(elemPiv + 1);
        }
    }

}