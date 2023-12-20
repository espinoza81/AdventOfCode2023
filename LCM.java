public class LCM {
    // Функция за намиране на НОД между две числа
    public static int findGCD(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    // Функция за намиране на НОК между две числа
    public static int findLCM(int x, int y) {
        return (x * y) / findGCD(x, y);
    }

    // Функция за намиране на НОК между множество числа
    public static int findLCM(int[] numbers) {
        int resultLCM = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            resultLCM = findLCM(resultLCM, numbers[i]);
        }
        return resultLCM;
    }

    public static void main(String[] args) {
        // Дадени числа
        int[] numbers = {21883, 13019, 11911, 16897, 19667, 18559};

        // Намиране на НОК между всички числа
        int resultLCM = findLCM(numbers);

        System.out.println("Търсеното число Z е: " + resultLCM);
    }
}

