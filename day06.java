import java.math.BigInteger;
import java.util.List;

public class day06 {
    public static void main(String[] args) {
        List<Integer> times = List.of(52, 94, 75, 94);
        List<Integer> distances = List.of(426, 1374, 1279, 1216);
        long out = 1;

        for (int i = 0; i < times.size(); i++) {
            long time = times.get(i);
            long distance = distances.get(i);
            long numbers = (long) ((time - Math.sqrt(Math.pow(time, 2) - 4*distance))/2) + 1;
            out *= time + 1 - 2 * numbers;
        }

        System.out.println(out);

        BigInteger timePartTwo = new BigInteger("Time:        52     94     75     94".replaceAll("\\D|:", ""));
        BigInteger distancePartTwo = new BigInteger("Distance:   426   1374   1279   1216".replaceAll("\\D|:", ""));
        BigInteger numbersPartTwo = (timePartTwo.subtract(timePartTwo.pow(2).subtract(distancePartTwo.multiply(BigInteger.valueOf(4))).sqrt())).divide(BigInteger.TWO).add(BigInteger.ONE);

        System.out.println(timePartTwo.add(BigInteger.ONE).subtract(BigInteger.TWO.multiply(numbersPartTwo)));


    }

    public static String INPUT =
            "Time:        52     94     75     94\n" +
            "Distance:   426   1374   1279   1216";
}
