package by.epam.fundamentals.taskThree;


import java.util.Scanner;

public class Third {

    public static void main(String[] args) {
        new Third().defineIntervalForInput();
        new Third().inputNumberAndGetMonthName();
    }

    //1.     Определить принадлежность некоторого значения k интервалам (n, m], [n, m), (n, m), [n, m].
    public void defineIntervalForInput (){
        System.out.println("Введите границы интервала через пробел и нажмите <Enter>:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println();
        System.out.println("Сейчас введите ваше число внутри этих границ и нажмите <Enter>:");
        int k = scan.nextInt();

        if (k > n && k <= m) {
            System.out.println(k + " принадлежит интервалу (" + n + "," + m + "]");
        }else if (k >= n && k < m) {
            System.out.println(k + " принадлежит интервалу [" + n + "," + m + ")");
        } else if (k > n && k < m) {
            System.out.println(k + " принадлежит интервалу (" + n + "," + m + ")");
        } else if (k >= n && k <= m) {
            System.out.println(k + " принадлежит интервалу [" + n + "," + m + "]");
        }
    }


    //2.     Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
    public void inputNumberAndGetMonthName() {
        System.out.println("Введите число от 1 до 12 и нажмите <Enter>:");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        switch (x) {
                case 1: System.out.println("Месяц под номером " + x + " - Январь"); break;
                case 2: System.out.println("Месяц под номером " + x + " - Февраль"); break;
                case 3: System.out.println("Месяц под номером " + x + " - Март"); break;
                case 4: System.out.println("Месяц под номером " + x + " - Апрель"); break;
                case 5: System.out.println("Месяц под номером " + x + " - Май"); break;
                case 6: System.out.println("Месяц под номером " + x + " - Июнь"); break;
                case 7: System.out.println("Месяц под номером " + x + " - Июль"); break;
                case 8: System.out.println("Месяц под номером " + x + " - Август"); break;
                case 9: System.out.println("Месяц под номером " + x + " - Сентябрь"); break;
                case 10: System.out.println("Месяц под номером " + x + " - Октябрь"); break;
                case 11: System.out.println("Месяц под номером " + x + " - Ноябрь"); break;
                case 12: System.out.println("Месяц под номером " + x + " - Декабрь"); break;
                default: System.out.println("Введите число от 1 до 12 включительно"); break;
            }
    }

}
