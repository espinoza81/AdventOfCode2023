public class GCD {
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
        int[] numbers = {21883, 13019, 11911, 16897, 19667, 18559};

        // Намиране на НОД между всички числа
        int resultGCD = findGCD(numbers);

        System.out.println("Най-малкият общ делител на числата е: " + resultGCD);
    }
}

