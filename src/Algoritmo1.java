import utils.Function;

public class Algoritmo1 implements Function{

    @Override
    public int call(String str1, String str2) {

        final int longitud = str1.length();

        int [][] matriz = new int[longitud+1][longitud+1];

        for (int i = 0; i <= longitud; i++) {
            for (int j = 0; j <= longitud; j++) {
                if (i==0) {
                    matriz[i][j] = j;
                } else if (j==0) {
                    matriz[i][j] = i;
                } else {
                    if (str1.charAt(i-1) == str2.charAt(j-1)) {
                        matriz[i][j] = matriz[i-1][j-1];
                    }
                    else {
                        int NO = matriz[i-1][j-1];
                        int N = matriz[i][j-1];
                        int O = matriz[i-1][j];

                        int min = Math.min(NO, N);
                        min = Math.min(O, min);

                        matriz[i][j] = min + 1;
                    }
                }
            }
        }
        return matriz[longitud][longitud];
    }
    
}
