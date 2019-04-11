package by.epam.fundamentals.taskFour;

import java.util.Scanner;

public class Forth {
    public static void main(String[] args) {
        int n = getNumber();
        int[][] matrix = getMatrix(n);
        printMatrix(matrix);
        new Forth().shiftLeft(matrix);
        printMatrix(matrix);
        new Forth().shiftRight(matrix);
        printMatrix(matrix);
        new Forth().shiftUp(matrix);
        printMatrix(matrix);
        new Forth().shiftDown(matrix);
        printMatrix(matrix);
        new Forth().getSum(matrix);
    }

    private static Scanner scanner = null;

    public static int getNumber() {
        int n = 0;
        if (scanner == null)
            scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размерность матрицы a[][]. Любое положительное число. \n");
            n = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели не положительное число!");
            e.printStackTrace();
        }
        return n;
    }

    public static int[][] getMatrix(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random()*2*n + 1 - n );
            }
        }
        return arr;
    }

    public static void printMatrix(int[][] arr){

        for (int[] x: arr) {
            for (int z: x) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
    }

//2.     Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).
    public void shiftLeft(int[][] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сдвиг влево");
        int shift = scanner.nextInt();

        int size = arr.length;
        for (int s = 0; s < shift; s++) {
            for (int i = 0; i < size; i++) {
                int tmp = arr[i][0];
                for (int j = 0; j < size- 1; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                arr[i][size-1] = tmp;
            }
        }
    }

    public void shiftRight(int[][] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сдвиг вправо");
        int shift = scanner.nextInt();

        int size = arr.length;
        for (int s = 0; s < shift; s++) {
            for (int i = 0; i < size; i++) {
                int tmp = arr[i][size-1];
                for (int j = size - 1; j > 0; j--) {
                    arr[i][j] = arr[i][j - 1];
                }
                arr[i][0] = tmp;
            }
        }
    }

    public void shiftUp(int[][] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сдвиг вверх");
        int shift = scanner.nextInt();

        int size = arr.length;
        for (int s = 0; s < shift; s++) {
            for (int i = 0; i < size; i++) {
                int tmp = arr[0][i];
                for (int j = 0; j < size-1; j++) {
                    arr[j][i] = arr[j+1][i];
                }
                arr[size-1][i] = tmp;
            }
        }
    }

    public void shiftDown(int[][] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сдвиг вниз");
        int shift = scanner.nextInt();

        int size = arr.length;
        for (int s = 0; s < shift; s++) {
            for (int i = 0; i < size; i++) {
                int tmp = arr[size-1][i];
                for (int j = size-1; j > 0; j--) {
                    arr[j][i] = arr[j-1][i];
                }
                arr[0][i] = tmp;
            }
        }
    }

//4.     Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
    public void getSum (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int pos1 = -1;
            int pos2 = -1;
            for (int j = 0; j < arr.length; j++) {

                if (arr[i][j] > 0) {
                    if (pos1 == -1) {
                        pos1 = arr[i][j];
                        continue;
                    }else if (pos2 == -1) {
                        pos2 =  arr[i][j];
                        break;
                    }
                }

                if (pos1 >= 0) {
                    sum += arr[i][j];
                }
            }
            if (pos1 >= 0 && pos2 > 0) {
                System.out.printf("Сумма чисел между двумя положительными числами в строке %s = %s \n", i+1, sum);
            } else {
                System.out.printf("Сумма чисел между двумя положительными числами в строке %s = %s \n", i+1, 0);
            }

        }
    }
}
