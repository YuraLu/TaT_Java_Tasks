package by.epam.fundamentals.taskFirst;

public class First {

    public static void main(String[] args) {

        new First().sayHelloToUser(args);
        new First().printArgsReversed(args);
        new First().printNumbers(args);
        new First().sumArgs(args);
    }
    //1. Приветствовать любого пользователя при вводе его имени через командную строку.
    public void sayHelloToUser(String[] args) {
        System.out.println("First arg = userName");
        if (args.length < 1) {
            System.out.println("You forgot to enter command line arguments");
        }else{
            System.out.println("Hello, " + args[0]);
        }
        System.out.println();
    }
    // 2.Отобразить в окне консоли аргументы командной строки в обратном порядке.
    public void printArgsReversed(String[] args) {
        System.out.println("Arg in reverse order:");
        for (int i=args.length-1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }
    //3.Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
    public void printNumbers(String[] args) {
        System.out.println("Arg printed on new line each:");
        for (int i=0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println();
    }
    //4.  Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.
    public void sumArgs(String[] args) {
        int sum = 0;
        for (int i=0; i<args.length;i++) {
            if (args[i].matches("\\D+")){
                continue;
            }else {
                sum += Integer.parseInt(args[i]);

            }
        }

        System.out.println("Sum of all args = " + sum);
    }
}



