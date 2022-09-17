import utils.Function;

public class Algoritmo3 implements Function{

    @Override
    public void call(String str1, String str2) {
        // Inicializamos las variables importantes
        int len_b = 2048;
        int longitud = str1.length();
        int row_matriz = longitud/(len_b-1);
        if(longitud %(len_b-1) != 0) row_matriz++;
        int[][][][] matriz = new int[row_matriz][row_matriz][len_b][len_b];
        int[][] submatriz;

        // Calculamos el valor para cada submatriz, donde se caluclara usando el
        // algoritmo 2.2

        // Se revisara cada submatriz creada de izq a der, arriba hacia abajo
        for(int i = 0; i < row_matriz; i++){
            for(int j = 0; j < row_matriz; j++){

                // Seleccionamos la submatriz correspondiente a ver
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

                // Ejecutamos el algoritmo 2.2 en la submatriz entregada observando cada celda que no es frontera
                for(int n = 1; n < len_b; n++){
                    for(int m = 1; m < len_b; m++){
                        if(i*(len_b-1)+(n-1) < str1.length() && j*(len_b-1)+(m-1) < str2.length()){
                            if (str1.charAt(i*(len_b-1)+(n-1)) == str2.charAt(j*(len_b-1)+(m-1))) {
                                submatriz[n][m] = submatriz[n - 1][m - 1];
                            } else {
                                int NO = submatriz[n - 1][m - 1];
                                int N = submatriz[n][m - 1];
                                int O = submatriz[n - 1][m];
                                submatriz[n][m] = Math.min(O, Math.min(N, NO)) + 1;
                            }
                        }
                    }
                }

                // Copiar datos de ultima matriz en las fronteras de salidas
                // , es decir, a la primera fila de la matriz de abajo y a la primera columan de la matriz de la derecha
                // Copiamos tanto para la frontera inferior como frontera derecha
                if(j+1 < row_matriz && i+1 < row_matriz){
                    for(int n = 0; n < len_b; n++){
                        matriz[i+1][j][0][n] = submatriz[len_b-1][n];
                        matriz[i][j+1][n][0] = submatriz[n][len_b-1];
                    }
                }
                // Caso solo copiamos hacia la frontera inferior
                if(j+1 >= row_matriz && i+1 < row_matriz){
                    for(int n = 0; n < len_b; n++) matriz[i+1][j][0][n] = submatriz[len_b-1][n];
                }

                // Caso solo copiamos hacia la frontera derecha
                else if(i+1 >= row_matriz && j+1 < row_matriz){
                    for(int n = 0; n < len_b; n++) matriz[i][j+1][n][0] = submatriz[n][len_b-1];
                }
                // print_matriz(submatriz, len_b);
            }
        }

        // Entregamos el resultado, dependiendo del largo del string para poder entregar la celda correspondiente
        // if(longitud % (len_b-1) == 0) System.out.println(matriz[row_matriz-1][row_matriz-1][len_b-1][len_b-1]);
        // else System.out.println(matriz[row_matriz-1][row_matriz-1][longitud%(len_b-1)][longitud%(len_b-1)]);
    }
}
