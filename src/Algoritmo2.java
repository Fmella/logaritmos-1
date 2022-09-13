import utils.Function;

public class Algoritmo2 implements Function{
    @Override
    public void call(String str1, String str2) {

        // inicializacion de valores
        final int len = str1.length();
        int[] row = new int[len+1];
        int[] column = new int[len+1];
        int i = 1, j = 1;
        for(int k = 0; k < len+1; k++){
            row[k] = k;
            column[k] = k;
        }

        // comienza el ciclo
        while(i != len+1 && j != len+1){
            // calculamos para la fila
            // primer cambio
            if(str1.charAt(i-1) != str2.charAt(j-1)) row[j-1] = Math.min(row[j-1], Math.min(row[j], column[i-1])) + 1;
            j++;

            // siguientes cambios
            while(j < len+1){
                if(str1.charAt(i-1) != str2.charAt(j-1)) row[j-1] = Math.min(row[j-1], Math.min(row[j], row[j-2])) + 1;
                j++;
            }
            // movemos todos los elementos hacia la derecha
            for(int k = len; 0 < k; k--) row[k] = row[k-1];
            j = i;

            // calculamos para la columna
            // primer cambio
            column[i-1] = row[i];
            i++;

            // siguientes cambios
            while(i < len+1){
                if(str1.charAt(i-1) != str2.charAt(j-1)) column[i-1] = Math.min(column[i-1], Math.min(column[i], column[i-2])) + 1;
                i++;
            }
            // movemos todos los elementos hacia la derecha
            for(int k = len; 0 < k; k--) column[k] = column[k-1];
            i = j;
            i++; j++;
        }
    }
}
