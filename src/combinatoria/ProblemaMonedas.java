package combinatoria;

import java.util.Date;

public class ProblemaMonedas {

    static int[] tipoMonedas; //tipos de monedas
    static int n; //cantidad de monedas
    static int cantidadTotal = 15;//dinero que se necesita devolver
    static int[] solucionFinal;//para guardar la solucion final para imprimirla

    static void imprimirSolucion() {
        int cantidad = 0, pos = 0, cantidadTotalMonedas = 0;
        System.out.println("Cantidad Total: " + cantidadTotal);
        for (int m = 0; m < n; m++) {
            cantidad = 0;
            while (pos < solucionFinal.length && solucionFinal[pos] == tipoMonedas[m]) {
                cantidad++;
                pos++;
            }
            cantidadTotalMonedas += cantidad;
            System.out.println("Monedas de " + tipoMonedas[m] + ": " + '\t' +
                    cantidad + " (" + tipoMonedas[m] * cantidad + ")");
        }
        System.out.println("___________________________________");
        System.out.println("Total monedas =" + '\t' + cantidadTotalMonedas);
        System.out.println();
    }

    public static void main(String[] args) {
        n = 5;

        tipoMonedas = new int[n];
        tipoMonedas[0] = 1;
        tipoMonedas[1] = 5;
        tipoMonedas[2] = 6;
        tipoMonedas[3] = 11;
        tipoMonedas[4] = 17;
        //la mayor cantidad de monedas posible = cantidadTotal
        menorCantEnc = cantidadTotal + 1;
        Date inicio = new Date(); //para tomar el tiempo inicial
        solucionFinal = new int[cantidadTotal];//arreglo para guardar la solucion final
        devolverMonedas_2(cantidadTotal, 0, new int[cantidadTotal],0);
        imprimirSolucion();

        long tiempo = new Date().getTime() - inicio.getTime();
        System.out.println("El 2do proceso tardó " + tiempo + " milisegundos");


// devolverSoluciones(cantidadTotal,0,new int[cantidadTotal]);
    }

    /** Imprime todas las posibles soluciones*/
    public static void devolverSoluciones(int cantidad, int addPosSolucion, int[] solucion) {
        if (cantidad == 0) {
            for (int j = 0; j < solucion.length && solucion[j] != 0; System.out.print(solucion[j++] + ","));//imprimo la lista
            System.out.println(); //linea en blanco
        } else {
            for (int i = 0; i < n; i++) {
                if ((cantidad - tipoMonedas[i] >= 0) && (addPosSolucion == 0 || tipoMonedas[i] >= solucion[addPosSolucion - 1])) {
                    solucion[addPosSolucion] = tipoMonedas[i];
                    devolverSoluciones(cantidad - tipoMonedas[i], addPosSolucion + 1, solucion);
                    solucion[addPosSolucion] = 0;
                }
            }
        }
    }
    static int menorCantEnc;

    /**Devuelve el arreglo de monedas necesarias al arreglo solucion
    El arreglo de tipos de monedas debe estar organizado
     */
    public static void devolverMonedas(int cantidad, int addPosSolucion, int[] solucion) {
        if (cantidad == 0 /*&& addPosSolucion< menorCantEnc*/) {
            System.arraycopy(solucion, 0, solucionFinal, 0, solucion.length);
            menorCantEnc = addPosSolucion;
        } else if (addPosSolucion < menorCantEnc/*-1*/) {
            for (int i = 0; i < n; i++) {
                if ((cantidad - tipoMonedas[i] >= 0) && (addPosSolucion == 0 || tipoMonedas[i] >= solucion[addPosSolucion - 1])) {


                    solucion[addPosSolucion] = tipoMonedas[i];

                    devolverMonedas(cantidad - tipoMonedas[i], addPosSolucion + 1, solucion);


                    solucion[addPosSolucion] = 0;
                }
            }
        }
    }

    /**Version anterior mejorada*/
    public static void devolverMonedas_2(int cantidad, int addPosSolucion, int[] solucion, int iterador) {
        if (cantidad == 0 ) {
            System.arraycopy(solucion, 0, solucionFinal, 0, solucion.length);
           
            
            menorCantEnc = addPosSolucion;


        } else if (addPosSolucion < menorCantEnc/*-1*/) {
            for (int i = iterador; i < n; i++) {
               
                if (cantidad - tipoMonedas[i] >= 0) {
                    solucion[addPosSolucion] = tipoMonedas[i];
                 
                    devolverMonedas_2(cantidad - tipoMonedas[i], addPosSolucion + 1, solucion, i);
                   
                    
                    solucion[addPosSolucion] = 0;
                }


            }
        }
    }
}
