package dinamica;

public class Monedas {

    static int[] tipoMonedas; //tipos de monedas
    static int n; //cantidad de monedas
    static int cantidadTotal = 18;//dinero que se necesita devolver
    static int[][] matriz; //matriz para solucionar dinamicamente

    public static void main(String[] args) {
        n = 5;

        tipoMonedas = new int[n];
        tipoMonedas[0] = 1;
        tipoMonedas[1] = 5;
        tipoMonedas[2] = 6;
        tipoMonedas[3] = 11;
        tipoMonedas[4] = 17;

        cantidadTotal++; //se debe aumentar uno para guardar el 0 tambien en matriz
        
        System.out.println(resolver());
        
         System.out.println(resolverMejor());
    }
    //matriz
    public static int resolver() {
       
        matriz = new int[n][cantidadTotal];

        int tem;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cantidadTotal; j++) {

                if (i == 0) {
                    matriz[0][j] = j;
                } else {
                    if (tipoMonedas[i] > j) {
                        matriz[i][j] = matriz[i - 1][j];
                    } else {
                        tem = j / tipoMonedas[i];
                        matriz[i][j] = min(matriz[i - 1][j], tem + matriz[i - 1][j % tipoMonedas[i]]);
                    }
                }
            }

            //imprime la matriz
            for (int j = 0; j < cantidadTotal; System.out.print(" " + matriz[i][j++])) {
                ;
            }
            System.out.println();

        }

        return matriz[n - 1][cantidadTotal - 1];
    }

    static int min(int a, int b) {
        return (a < b) ? a : b;
    }
   //consume menos memoria no hay matriz
    public static int resolverMejor() {
         int arr1[] = new int[cantidadTotal];
        int arr2[] = new int[cantidadTotal];

        int tem;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cantidadTotal; j++) {

                if (i == 0) {
                    arr2[j] = j;
                } else {
                    if (tipoMonedas[i] > j) {
                        arr2[j] = arr1[j];
                    } else {
                        tem = j / tipoMonedas[i];
                        arr2[j] = min(arr1[j], tem +arr1[j % tipoMonedas[i]]);
                    }
                }
            }
         arr1=arr2.clone();
        //imprime la matriz
      for (int j = 0; j < cantidadTotal; System.out.print(" " + arr2[j++])) ;
           
            System.out.println();

        }

        return arr2[cantidadTotal - 1];
    }
}
