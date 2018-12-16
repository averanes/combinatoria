package dinamica;

public class Mochila {

    static int cantidad;
    static int pesoLim;
    static int[] pesos;
    static int[] beneficio;

    public static void main(String[] args) throws Exception {



        cantidad = 3;
        pesoLim = 3;
        
        pesos = (new int[]{1, 2, 3});
        beneficio = (new int[]{2, 5, 6});

        System.out.println(Mochila(cantidad, pesoLim + 1, beneficio, pesos));
   
    }

    public static int Mochila(int Nelementos, int peso, int[] v, int[] w) {

        int arr1[] = new int[peso];
        int arr2[] = new int[peso];

        for (int i = 0; i < Nelementos; i++) {
            arr2[i] = 0;
            for (int j = 0; j < peso; j++) {
                if ((i == 0) && (j < w[i])) {
                    arr2[j] = 0;
                } // soluciones[0][j] si i=0 y j>=0
                else if (i == 0) {
                    arr2[j] = v[i];
                } //soluciones[0][j]=v[0] cuando j>=w[0];
                else if (j < w[i]) // si (j-w[i]) < 0 el máximo será el otro término
                {
                    arr2[j] = arr1[j];
                } else {
                    arr2[j] = max(arr1[j], arr1[j - w[i]] + v[i]);
                }
            }
            arr1 = arr2.clone();
        }
//La solución a nuestro problema esta en esta posición de la matriz.
        return arr1[peso - 1];
    }

    static int max(int v1, int v2) {
        return (v1 > v2) ? v1 : v2;
    }
}

