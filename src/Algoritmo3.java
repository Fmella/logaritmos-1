import utils.Function;

public class Algoritmo3 implements Function{

    @Override
    public void call(String str1, String str2) {

        // Inicializamos los valores que nos ayudaran
        int longitud = str1.length()+1;
        int len_b = 4;
        int row_matriz;
        if (longitud / (len_b-1) == 0) row_matriz = longitud / (len_b-1); else row_matriz = longitud / (len_b-1) + 1;
        int[][][][] matriz = new int[row_matriz][row_matriz][len_b][len_b];
        int[][] submatriz;

        for(int i = 0; i < row_matriz; i++){
            for(int j = 0; j < row_matriz; j++){

                // Seleccionamos la submatriz correspondiente
                submatriz = matriz[i][j];

                // Caso primera submatriz
                if(i == 0 && j == 0){
                    // Rellenamos la primera submatriz con los valores iniciales correspondientes
                    for(int n = 0; n < len_b; n++){
                        submatriz[0][n] = n;
                        submatriz[n][0] = n;
                    }
                }

                // Caso primera matriz de cada fila
                else if(j == 0){
                    // Rellenamos los numeros correspondientes de la primera columna de la submatriz
                    for(int n = 1; n < len_b; n++)  submatriz[n][0] = (len_b-1) * i + n;
                }

                // Caso primera matriz de cada columna
                else if(i == 0){
                    // Rellenamos los numeros correspondiente de la primera fila de la submatriz
                    for(int m = 1; m < len_b; m++)  submatriz[0][m] = (len_b-1) * j + m;
                }

                // Aplicamos algoritmo 2.2 en la submatriz
                for(int n = 1; n < len_b; n++){
                    for(int m = 1; m < len_b; m++){
                        if (str1.charAt((len_b*i)+n-1) == str2.charAt((len_b*i)+m-1)) {
                            submatriz = matriz[m-1][m-1];
                        }
                        else {
                            int NO = submatriz[n-1][m-1];
                            int N = submatriz[n][m-1];
                            int O = submatriz[n-1][m];
                            submatriz[n][m] = Math.min(O, Math.min(N,NO)) + 1;
                            }
                        }
                    }

                // Copiar datos de ultima matriz en las fronteras de salidas
                // , es decir, a la primera fila de la matriz de abajo y a la primera columan de la matriz de la derecha
                // Copiamos tanto para la frontera inferior como frontera derecha
                if(j+1 < len_b && i+1 < len_b){
                    for(int n = 0; n < len_b; n++){
                        matriz[i+1][j][n][0] = submatriz[n][len_b-1];
                        matriz[i][j+1][0][n] = submatriz[len_b-1][n];
                    }
                }
                // Caso solo copiamos hacia la frontera inferior
                if(j+1 == len_b && i+1 != len_b){
                    for(int n = 0; n < len_b; n++) matriz[i+1][j][0][n] = submatriz[len_b-1][n];
                }

                // Caso solo copiamos hacia la frontera derecha
                else if(i+1 == len_b && j+1 != len_b){
                    for(int n = 0; n < len_b; n++) matriz[i][j+1][n][0] = submatriz[n][len_b-1];
                }

            }
        }
    }


    public static void main(String[] args) throws Exception {
        Algoritmo3 test = new Algoritmo3();
        String str1 = "banana";
        String str2 = "ananas";
        test.call(str1,str2);

    }
}
