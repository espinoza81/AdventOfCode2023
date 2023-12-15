import java.util.Scanner;

public class day02 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        String[] line;
        String[] cubes;
        String[] taken;
        int out = 0;
//        int gameIndex;
        int count;
        String colour;
//        boolean plus = true;
        while (!"end".equals(input = console.nextLine())) {
            int power = 0;
            int redMax = 0;
            int greenMax = 0;
            int blueMax = 0;
            //Game 1: 4 red, 5 blue, 9 green; 7 green, 7 blue, 3 red; 16 red, 7 blue, 3 green; 11 green, 11 blue, 6 red; 12 red, 14 blue
            line = input.split(":\\s+");
//            gameIndex = Integer.parseInt(line[0].split("\\s+")[1]);
            taken = line[1].split(";\\s+");
            for (String take : taken) {
                cubes = take.split(",\\s+");
                for (String cube : cubes) {
                    count = Integer.parseInt(cube.split("\\s+")[0]);
                    colour = cube.split("\\s+")[1];
                    switch (colour){
                        case "red":
                            if(count > redMax) redMax = count;
                            break;
                        case "blue":
                            if(count > blueMax) blueMax = count;
                            break;
                        case "green":
                            if(count > greenMax) greenMax = count;
                            break;
                    }
                    //plus = (colour.equals("red") && count <= 12) || (colour.equals("green") && count <= 13) || (colour.equals("blue") && count <= 14);
                    //if(!plus) break;
                }
                //if(!plus) break;
            }

            //if (!plus) continue;
            out += redMax*greenMax*blueMax;
        }

        System.out.println(out);

    }
}