import utils.Utils;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Script running...");
        int n_repeat = 50;
        Algoritmo1 algoritmo1 = new Algoritmo1();
        Algoritmo2 algoritmo2 = new Algoritmo2();
        Algoritmo3 algoritmo3 = new Algoritmo3();

        Plot plot = new Plot("Tiempo promedio de los algoritmos según el largo de los strings", "Largo del string", "milisegundos (ms)");

        int[] x = new int[13];
        for (int i=3; i<=15; i+=1) {
            x[i-3] = (int)Math.pow(2, i);
        }

        int[] alg1 = new int[13];
        System.out.println("Algoritmo 1:");
        for (int j=0; j<x.length; j++) {
            alg1[j] = (int) Utils.promedio(n_repeat, x[j], algoritmo1);
            System.out.print(alg1[j] + " ");
        }
        System.out.print("\n");
        plot.addSerie("Algoritmo 1", x, alg1);
        
        int[] alg2 = new int[13];
        System.out.println("Algoritmo 2:");
        for (int j=0; j<x.length; j++) {
            alg2[j] = (int) Utils.promedio(n_repeat, x[j], algoritmo2);
            System.out.print(alg2[j] + " ");
        }
        System.out.print("\n");
        plot.addSerie("Algoritmo 2", x, alg2);

        int[] alg3 = new int[13];
        System.out.println("Algoritmo 3:");
        for (int j=0; j<x.length; j++) {
            alg3[j] = (int) Utils.promedio(n_repeat, x[j], algoritmo3);
            System.out.print(alg3[j] + " ");
        }
        System.out.print("\n");
        plot.addSerie("Algoritmo 3", x, alg3);
        
        plot.finish();

        plot.setVisible( true );

    }

}
