import java.lang.Math;

import utils.Utils;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Utils utils = new Utils();

        Algoritmo1 algoritmo1 = new Algoritmo1();
        Algoritmo2 algoritmo2 = new Algoritmo2();

        double resultado1 = utils.promedio(50, (int)Math.pow(2, 15), algoritmo1);
        double resultado2 = utils.promedio(50, (int)Math.pow(2, 15), algoritmo2);

        System.out.println(resultado1);
        System.out.println(resultado2);

    }

}
