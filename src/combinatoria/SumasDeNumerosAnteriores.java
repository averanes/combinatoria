/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatoria;

/**
 *
 * @author Adrian
 */
public class SumasDeNumerosAnteriores {
    
    public static void main(String [] args){
    
         int total = 10;
        elementosQueSuman(-1, 0, total, new int[total], 0);
        
        System.out.println(count);
    }
    
    
    static int count = 0;
    
    public static void elementosQueSuman(int valorASumar, int sumaActual, int total, int[]valores, int posicion){
    
            if(sumaActual == total){
               count++;
                for (int i = 0; i < valores.length && valores[i]!=0; )  {
                    System.out.print(valores[i++] + " ");
               }
               System.out.println();
            }
            
            
            if(valorASumar == -1)valorASumar = total;
            
        
        for (int i = valorASumar; i > 0 ; i--) {
         
            if(i + sumaActual <= total){
            
                valores[posicion] = i;
                
                elementosQueSuman(i, sumaActual+i, total, valores, posicion + 1 );
                
               valores[posicion] = 0;
               
            }
            
            
        }
        
    
    
    }
    
}
