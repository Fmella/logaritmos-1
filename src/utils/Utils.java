package utils;

import java.util.Random;


public final class Utils {

    public String random_string(int n) {
        Random random = new Random();

        String randomString = random.ints(n, 97, 123)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

        return randomString;
    }

    public long time_fun(Function fun, String str1, String str2) {
        long start = System.currentTimeMillis();
        fun.call(str1, str2);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public double promedio(int cantidad, int longitud, Function fun) {
        double total = 0;
        for (int i = 0; i < cantidad; i++) {
            final String str1 = random_string(longitud);
            final String str2 = random_string(longitud);
            total += time_fun(fun, str1, str2);
        }
        return total / cantidad;
    }
    
}
