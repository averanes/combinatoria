
package combinatoria;


public class Permutaciones {
    
    public static void main(String[] args) {
 
        char[] pal = "abcde".toCharArray();
        permutar(pal, 0);
    }

    public static void permutar(char[] cadena, int pos) {
     
        if (cadena.length == pos) {
          System.out.println(cadena);
        } else {
            for (int i = pos; i < cadena.length; ++i) {
                cambiarPosiciones(cadena, i, pos);

                
                permutar(cadena, pos + 1);


                cambiarPosiciones(cadena, i, pos);
            }
        }

    }


    public static void cambiarPosiciones(char[] cadena, int posI, int posF) {
        char temp = cadena[posI];
        cadena[posI] = cadena[posF];
        cadena[posF] = temp;
    }
    
}
