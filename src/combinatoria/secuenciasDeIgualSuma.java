
package combinatoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class secuenciasDeIgualSuma {

    public static void main(String[] args) throws IOException {
       
        StreamTokenizer tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n, casos = 0;
        boolean dejarLinea = false;
        tk.nextToken();
        casos = (int) tk.nval;
        while (casos-- > 0) {
            if (dejarLinea) 
                System.out.println();
             else 
                dejarLinea = true;
            

            tk.nextToken();
            n = (int) tk.nval;

          //  sequencesMayorAMenor(n, 0, new int[n]);
           sequencesMenorAMayor(n, 0, new int[n]);
          
        }

    }

    public static void sequencesMenorAMayor_2(int n, int addEnPos, int[] cad) {
        if (n == 0) {
            for (int j = 0; j < cad.length && cad[j] != 0; System.out.print(cad[j++]));
            System.out.println();
        } else {
            for (int i = 1; i <= 9; i++) 
                if (n - i >= 0 &&(addEnPos==0 || i >= cad[addEnPos-1]) /*para no poner un # < al final*/) {
                    cad[addEnPos] = i;
                    sequencesMenorAMayor_2(n - i, addEnPos+1, cad);
                     cad[addEnPos] =0;
                }
        }
    }
    
    /**cuando n -> (# que me falta por sumar)==0 imprimo la lista
    se llama recursivo y se agrega el dijito i en caso de
     i ser >= que n y ser i>=que el ultimo dijito en la lista 
     
    int anterior = ((#) == 0) ? 0 : (# - 1);
    if(#==0) anterior=0; else anterior= #-1
    */
    public static void sequencesMenorAMayor(int n, int addEnPos, int[] cad) {
        if (n == 0) {
            for (int j = 0; j < cad.length && cad[j] != 0; System.out.print(cad[j++]));//imprimo la lista
            System.out.println(); //linea en blanco
        } else 
              for ( int i = (addEnPos == 0) ? 1 : cad[addEnPos - 1]; i <= 9; i++) 
                if ( n - i >= 0 ) {/*# que se agrega a la solucion <= que lo que falta*/
                    cad[addEnPos] = i;
                    sequencesMenorAMayor(n - i, addEnPos + 1, cad);//llamo recursivo para una posicion hallada >
                    cad[addEnPos] = 0;//limpio el valor escrito
                }
    
    }
   
    
      public static void sequencesMayorAMenor(int n, int addEnPos, int[] cad) {
        if (n == 0) {
            for (int j = 0; j < cad.length && cad[j] != 0; System.out.print(cad[j++]));//imprimo la lista
            System.out.println(); //linea en blanco
        } else 
              for (int i = 9; i >= 1; i--) {
                
                if ( n - i >= 0 && (addEnPos == 0 || i<= cad[addEnPos - 1])/*para no poner un # > que el anterior al final*/) 
                {    cad[addEnPos] = i;
                    sequencesMayorAMenor(n - i, addEnPos + 1, cad);//llamo recursivo para una posicion hallada >
                    cad[addEnPos] = 0;
                }
              }
    }
}

