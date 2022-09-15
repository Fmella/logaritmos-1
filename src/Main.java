import java.lang.Math;

import utils.Utils;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Algoritmo1 algoritmo1 = new Algoritmo1();
        Algoritmo2 algoritmo2 = new Algoritmo2();

        Plot plot = new Plot("Título", "xLabel", "yLabel");

        int[] x = new int[11];
        for (int i=3; i<14; i++) {
            x[i-3] = (int)Math.pow(2, i);
        }

        int[] alg1 = new int[11];
        for (int j=0; j<x.length; j++) {
            alg1[j] = (int) Utils.promedio(50, x[j], algoritmo1);
        }
        plot.addSerie("Algoritmo 1", x, alg1);
        
        int[] alg2 = new int[11];
        for (int j=0; j<x.length; j++) {
            alg2[j] = (int) Utils.promedio(50, x[j], algoritmo2);
        }
        plot.addSerie("Algoritmo 2", x, alg2);
        
        plot.finish();

        plot.setVisible( true );

    }

}
