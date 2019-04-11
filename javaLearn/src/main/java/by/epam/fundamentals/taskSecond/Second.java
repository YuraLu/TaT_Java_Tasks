package by.epam.fundamentals.taskSecond;

import java.util.ArrayList;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {

            System.out.println("Please enter positive numbers.");
            System.out.println("To end entering input negative number or Zero");
            Scanner scan = new Scanner(System.in);
            int num;
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num > 0 && num < Integer.MAX_VALUE) {
                    arrayList.add(num);
                } else {
                    System.out.println("You have entered = " + num);
                    System.out.print("Do you need to reenter numbers Y/N (Enter No to finish entering numbers): ");
                    if (scan.next().equalsIgnoreCase("Y")) {
                        return;
                    } else {
                        break;
                    }
                }
            }
            System.out.println("You have entered next numbers " + arrayList.toString());

        new Second().numbersLength(arrayList);
        new Second().bubbleSortUp(arrayList);
        new Second().bubbleSortDown(arrayList);
        new Second().averageNumLength(arrayList);
        new Second().diffDigitsNumber(arrayList);
        new Second().diffDigitsMinNumber(arrayList);
        new Second().countEven(arrayList);
        new Second().palindrome(arrayList);
        new Second().risingDigitsNumber(arrayList);
    }

// 1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    public void numbersLength(ArrayList<Integer> input) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            int num = input.get(i);
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        int minLength = Integer.toString(min).length();
        int maxLength = String.valueOf(max).length();
        System.out.println("Cамое короткое число: " + min + "." + " Его длина: " + minLength + ";");
        System.out.println("Cамое длинное число: " + max + "." + " Его длина: " + maxLength + ";");
        System.out.println();
    }

    //2.Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
    public void bubbleSortUp(ArrayList<Integer> input) {
        for (int i = input.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (input.get(j) > input.get(j+1)) {
                    int tmp = input.get(j);
                    input.set(j,input.get(j+1));
                    input.set(j + 1,tmp);
                }
            }
        }
        System.out.println("Отсортированный массив в порядке возрастания");
        for (int num : input) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
    }

    public void bubbleSortDown(ArrayList<Integer> input) {
        for (int i = input.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (input.get(j) < input.get(j+1)) {
                    int tmp = input.get(j);
                    input.set(j,input.get(j+1));
                    input.set(j + 1,tmp);
                }
            }
        }
        System.out.println("Отсортированный массив в порядке убывания");
        for (int num : input) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
    }

    //3.     Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
    public void averageNumLength(ArrayList<Integer> input) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < input.size(); i++) {
            int num = input.get(i);
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num ;
            }
        }
        int totalLength = 0;
        for (int num : input) {
            totalLength += String.valueOf(num).length();
        }
        int avgLength = totalLength / input.size();
        System.out.println("Cредняя длина: " + avgLength + ";");
        for (int num : input) {
            if (Integer.toString(num).length() < avgLength)
                System.out.println("Число меньше средней длины: " + num + "." + " Его длина: " + Integer.toString(num).length() + ";");
            else if (Integer.toString(num).length() > avgLength)
                System.out.println("Число больше средней длины: " + num + "." + " Его длина: " + Integer.toString(num).length() + ";");
        }
        System.out.println();
    }

    private int[] getArrayOfDigits (int num){
        int size = String.valueOf(num).length();
        int[] digitArray = new int[size];
        int digitNum = size-1;
        while (num != 0) {
            digitArray[digitNum] = num % 10;
            num /= 10;
            digitNum--;
        }
        return digitArray;
    }

//    4.Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
    private int countDifDigits (int num) {
        int result = 0;
        int[] arrDigits = getArrayOfDigits(num);
        for (int i = 0; i < arrDigits.length ; i++) {
            if (arrDigits[0] != arrDigits[i]){
                result++;
            }
        }
        return result;
    }

    public void diffDigitsMinNumber (ArrayList<Integer> input) {
        int result = input.get(0);
        for (int num: input) {
            if (countDifDigits(result) > countDifDigits(num)) {
                result = num;
            }
        }
         System.out.printf("1-ое число в котором число различных цифр минимально и равно %s: %s", countDifDigits(result), result);
        System.out.println();
        System.out.println();
    }

//5.     Найти количество чисел, содержащих только четные цифры, а среди
// них — количество чисел с равным числом четных и нечетных цифр.
    private boolean isOddEqualsEven(String str) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < str.length(); i++) {
            int element = (int) str.charAt(i);
            if (element % 2 == 0) {
                even++;
            }else {
                odd++;
            }
        }
        return (even == odd);
    }

    public void countEven(ArrayList<Integer> input) {
        ArrayList<Integer> evenNumbers =new ArrayList<>();
        ArrayList<Integer> evenequalOddEvenNumbers =new ArrayList<>();
        for (int i = 0; i < input.size() ; i++) {
            String str = String.valueOf(input.get(i));
            if (input.get(i) % 2 == 0) {
                evenNumbers.add(input.get(i));
            }
            if (isOddEqualsEven(str)){
                evenequalOddEvenNumbers.add(input.get(i));
            }
        }
        System.out.println("Even numbers count is " + evenNumbers.size());
        for (Integer num: evenNumbers) {
            System.out.println(num);
        }
        System.out.println("Even numbers with equal number of odd and even digits is " + evenequalOddEvenNumbers.size());
        for (Integer num: evenequalOddEvenNumbers) {
            System.out.println(num);
        }
        System.out.println();
    }

//        6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    public void risingDigitsNumber (ArrayList<Integer> input) {
        boolean isNumberOfRiseDigits = false;
        int count = 0;
        while (!isNumberOfRiseDigits && count<input.size()) {
                int numberToCheck = input.get(count);
                int[] digitsArray = getArrayOfDigits(numberToCheck);

                for (int i = 0; i < digitsArray.length-1; i++) {
                    if (digitsArray[i] < digitsArray[i+1]) {
                        isNumberOfRiseDigits = true;
                    } else {
                        isNumberOfRiseDigits = false;
                    }
                }
                if (isNumberOfRiseDigits) {
                    System.out.println();
                    System.out.println("1-ое число состоящее из цифр по возрастанию: " + numberToCheck + ".");
                    break;
                }
            count++;
        }
        System.out.println();
    }

//        7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
    public void diffDigitsNumber (ArrayList<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            int numberToCheck = input.get(i);
            if (isDigitsDiffers(numberToCheck)){
                System.out.println();
                System.out.printf("Число состоящее только из различных цифр: %d%n", numberToCheck);
            }
        }
        System.out.println();
    }

    private boolean isDigitsDiffers(int num) {
        boolean isDigitsDiffers = true;
        int[] arr = new int[10];

        for (int x: getArrayOfDigits(num)) {
            arr[x] +=1;
            if (arr[x] > 1) {
                isDigitsDiffers = false;
                break;
            }
        }
        return isDigitsDiffers;
    }

//8.     Среди чисел найти число-палиндром. Если таких чисел больше одного, найти второе.
    public void palindrome(ArrayList<Integer> input) {
        boolean numberIsPalindrom = false;
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            int numberToCheck = input.get(i);
            int[] digitsArray = getArrayOfDigits(numberToCheck);

            for (int j = 0; j < digitsArray.length/2; j++) {
                if (digitsArray[j] == digitsArray[(digitsArray.length-j-1)]) {
                    numberIsPalindrom = true;
                } else {
                    numberIsPalindrom = false;
                }
            }
            if (numberIsPalindrom) {
                System.out.println(i + 1 + "-ое число-палиндром: " + numberToCheck + ".");
                count++;
            }
        }
        if (count ==0 && !numberIsPalindrom) {
            System.out.println("Число-палиндром не найдено.");
        }
    }
}



