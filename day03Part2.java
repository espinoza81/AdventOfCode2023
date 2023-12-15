import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day03Part2 {
    private static char[][] matrix = null;
    private static char current;
    private static StringBuilder number = new StringBuilder();
    private static final List<Long> findNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long out = 0;

        fillMatrix(console);

        int colNumber;
        int rowNumber;

        for (int row = 0; row < 140; row++) {
            for (int col = 0; col < 140; col++) {
                if(matrix[row][col] == '*') {
                    rowNumber = row;
                    colNumber = col-1;

                    if(colNumber >= 0 && Character.isDigit(current = matrix[rowNumber][colNumber])) {
                        insert(colNumber, rowNumber);
                        find();
                    }

                    colNumber = col+1;

                    if(colNumber < 140 && Character.isDigit(current = matrix[rowNumber][colNumber])) {
                        append(colNumber, rowNumber);
                        find();
                    }

                    rowNumber = row - 1;
                    int back = col + 1;
                    colNumber = col;

                    if(rowNumber  >= 0) {
                        number.append(matrix[rowNumber][colNumber]);
                        if(--colNumber >= 0) {
                            insert(colNumber, rowNumber);
                        }

                            colNumber = back;
                        if (colNumber < 140) {
                            append(colNumber, rowNumber);
                        }

                        find();
                    }

                    rowNumber = row + 1;
                    colNumber = col;

                    if(rowNumber  < 140) {
                        number.append(matrix[rowNumber][colNumber]);
                        if(--colNumber >= 0) {
                            insert(colNumber, rowNumber);
                        }

                        colNumber = back;
                        if (colNumber < 140) {
                            append(colNumber, rowNumber);
                        }

                        find();
                    }

                    if(findNumbers.size() == 2) {
                        out += findNumbers.get(0) * findNumbers.get(1);
                    }
                    findNumbers.clear();
                }
            }
        }

        System.out.println(out);
    }

    private static void append(int colNumber, int rowNumber) {
        while (colNumber < 140 && Character.isDigit(current = matrix[rowNumber][colNumber])){
            number.append(current);
            colNumber++;
        }
    }

    private static void insert(int colNumber, int rowNumber) {
        while (colNumber >= 0 && Character.isDigit(current = matrix[rowNumber][colNumber])) {
            number.insert(0, current);
            colNumber--;
        }
    }

    private static void find() {
        if (number.indexOf(".") == 0){
            number.deleteCharAt(0);
        }

        if (number.length() > 0 && number.lastIndexOf(".") == number.length()-1){
            number.deleteCharAt(number.length()-1);
        }

        if (number.length() > 0) {
            if (number.indexOf(".") >= 0) {
                findNumbers.add(Long.parseLong(number.substring(0, number.indexOf("."))));
                findNumbers.add(Long.parseLong(number.substring(number.indexOf(".") + 1)));
            } else {
                findNumbers.add(Long.parseLong(String.valueOf(number)));
            }
            number = new StringBuilder();
        }
    }

    private static void fillMatrix(Scanner console) {
        matrix = new char[140][140];
        for (int i = 0; i < 140; i++) {
            matrix[i] = console.nextLine().toCharArray();
        }
    }
}