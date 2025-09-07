package homeworks.homework010;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] array = {12, 22, 34, 48, 56, 67, 78, 89, 91};

        int[] evenNumbers = Sequence.filter(array, n -> n % 2 == 0);
        System.out.println("Четные числа: " + Arrays.toString(evenNumbers));

        int[] sumEvenNumbers = Sequence.filter(array, n -> {
            int sum = 0;
            int temp = n;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            return sum % 2 == 0;
        });
        System.out.println("Числа, сумма цифр которых четна: " + Arrays.toString(sumEvenNumbers));
    }
}
