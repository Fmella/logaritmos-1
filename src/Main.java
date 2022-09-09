import java.lang.Math;

import utils.Utils;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Utils utils = new Utils();

        Algoritmo1 algoritmo1 = new Algoritmo1();

        double resultado = utils.promedio(50, (int)Math.pow(2, 15), algoritmo1);

        System.out.println(resultado);

    }

}
