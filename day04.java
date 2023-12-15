import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class day04 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        String[] line;
        List<String> winNumbers;
        List<String> hasNumbers;

        int[] cards = new int[192];
        for (int i = 0; i < 192; i++) {
            cards[i] = 1;
        }

        int cardNumber = 0;
        while (!"end".equals(input = console.nextLine())) {
            line = input.split(":\\s+|\\s+\\|\\s+");
            winNumbers = Arrays.stream(line[1].split("\\s+")).toList();
            hasNumbers = Arrays.stream(line[2].split("\\s+")).toList();
            int count = 0;
            for (String winNumber : winNumbers) {
                if (hasNumbers.contains(winNumber)) count++;
            }

            for (int i=1; i <= count; i++){
                cards[cardNumber+i] += cards[cardNumber];
            }
            cardNumber++;
        }
        System.out.println(Arrays.stream(cards).sum());
    }
}