public class GCD_LCM {
    // Функция за намиране на НОД между две числа
    public static int findGCD(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    // Функция за намиране на НОД между множество числа
    public static int findGCD(int[] numbers) {
        int resultGCD = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            resultGCD = findGCD(resultGCD, numbers[i]);
        }
        return resultGCD;
    }

    public static void main(String[] args) {
        // Дадени числа
        int A = 21883;
        int B = 13019;
        int C = 11911;
        int D = 11911;
        int E = 11911;
        int F = 11911;

        // Намиране на НОД между A и B
        int gcd_AB = findGCD(A, B);

        // Намиране на НОД между gcd_AB и C
        int[] numbers = {gcd_AB, C};
        int gcd_ABC = findGCD(numbers);

        // Намиране на търсеното число Z
        int Z = (A * B * C) / gcd_ABC;

        System.out.println("Търсеното число Z е: " + Z);
    }
}

