import java.util.Scanner;

public class day03 {
    private static char[][] matrix = null;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int out = 0;
        boolean hasSymbol = false;
        StringBuilder number = new StringBuilder();
        fillMatrix(console);

        for (int row = 0; row < 140; row++) {
            for (int col = 0; col < 140; col++) {
                char current = matrix[row][col];
                if(Character.isDigit(matrix[row][col])) {
                    number.append(current);

                    if(col-1 >= 0 && !((matrix[row][col-1])=='.' || Character.isDigit(matrix[row][col-1]))) hasSymbol = true;
                    if(col+1 < 140 && !((matrix[row][col+1])=='.' || Character.isDigit(matrix[row][col+1]))) hasSymbol = true;
                    if(row-1 >= 0 && !((matrix[row-1][col])=='.' || Character.isDigit(matrix[row-1][col]))) hasSymbol = true;
                    if(row+1 < 140 && !((matrix[row+1][col])=='.' || Character.isDigit(matrix[row+1][col]))) hasSymbol = true;
                    if((row-1 >= 0 && col-1 >= 0)&& !((matrix[row-1][col-1])=='.' || Character.isDigit(matrix[row-1][col-1]))) hasSymbol = true;
                    if((row-1 >= 0 && col+1 < 140)&& !((matrix[row-1][col+1])=='.' || Character.isDigit(matrix[row-1][col+1]))) hasSymbol = true;
                    if((row+1 < 140 && col-1 >= 0)&& !((matrix[row+1][col-1])=='.' || Character.isDigit(matrix[row+1][col-1]))) hasSymbol = true;
                    if((row+1 < 140 && col+1 < 140)&& !((matrix[row+1][col+1])=='.' || Character.isDigit(matrix[row+1][col+1]))) hasSymbol = true;


                    if(col + 1 >= 140 || !Character.isDigit(matrix[row][col + 1])) {
                        if (hasSymbol) {
                            out += Integer.parseInt(String.valueOf(number));
                            hasSymbol = false;
                        }
                        number = new StringBuilder();
                    }
                }
            }
        }

        System.out.println(out);

    }

    private static void fillMatrix(Scanner console) {
        matrix = new char[140][140];
        for (int i = 0; i < 140; i++) {
            matrix[i] = console.nextLine().toCharArray();
        }
    }
}

