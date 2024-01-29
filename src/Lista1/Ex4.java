package Lista1;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę całkowitą z przedziału [1,9]: ");
        int n = scanner.nextInt();



        if ((n > 9) || (n < 1)) {
            System.out.print("Podano liczbę spoza dopuszczalnego przedziału.");
        } else {
            int[][] tabA = new int[n][n];
            for (int i = 0; i <= (n-1); i++) {
                for (int j = 0; j <= (n-1); j++) {
                    tabA[i][j] = (i+1) * (j+1);
                    System.out.print(tabA[i][j] + "\t");
                }
                System.out.println();
            }

        }

        scanner.close();
    }
}



