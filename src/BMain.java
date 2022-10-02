import utils.Utils;


public class BMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Script running...");
        int n_repeat = 60;
        int b_values[] = {256,512,800,1024,1500,2048};
        Algoritmo3 algoritmo3 = new Algoritmo3();

        Plot plot = new Plot("Tiempo promedio del algoritmo 3 dependiendo del valor B", "Largo del string", "milisegundos promedios (s)");

        int[] x = new int[13];
        for (int i=3; i<=15; i+=1) {
            x[i-3] = (int)Math.pow(2, i);
        }

        for(int i = 0; i < b_values.length; i++){
            algoritmo3.len_b = b_values[i];
            int[] alg3 = new int[13];
            for (int j=0; j<x.length; j++) {
                alg3[j] = (int) Utils.promedio(n_repeat, x[j], algoritmo3);
            }

            plot.addSerie(Integer.toString(b_values[i]), x, alg3);
        }

        plot.finish();

        plot.setVisible( true );

    }

}
