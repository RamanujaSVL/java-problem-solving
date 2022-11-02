package practice.easy;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number");

        int num = scanner.nextInt();
        String reversedNumber = "0";
        int numHolder = num;

        while(numHolder / 10 > 0) {
            reversedNumber = reversedNumber.concat(String.valueOf(numHolder%10));
            numHolder /= 10;
        }

        reversedNumber = reversedNumber.concat(String.valueOf(numHolder));

        System.out.println("Reversed Number  - "+Integer.parseInt(reversedNumber));
    }

}
