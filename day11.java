import java.math.BigInteger;
import java.util.*;

public class day11 {

    private static final Set<Integer> indexesEmptyCol = new TreeSet<>();
    private static final List<long[]> planetIndexes = new ArrayList<>();

    public static void main(String[] args) {

        fillIndexesOfEmptyCol();

        extractPlanetIndexes();

        findSumOfPath();
    }

    private static void findSumOfPath() {
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0; i < planetIndexes.size(); i++) {
            for(int j = i+1; j < planetIndexes.size(); j++) {
                long planetOneRow = planetIndexes.get(i)[0];
                long planetOneCol = planetIndexes.get(i)[1];
                long planetTwoRow = planetIndexes.get(j)[0];
                long planetTwoCol = planetIndexes.get(j)[1];
                sum = sum.add(BigInteger.valueOf(Math.abs(planetOneRow-planetTwoRow) + Math.abs(planetOneCol-planetTwoCol)));
            }
        }
        System.out.println(sum);
    }

    private static void fillIndexesOfEmptyCol() {
        int length = INPUT.indexOf("\n");
        for (int i = 0; i < length; i++) {
            indexesEmptyCol.add(i);
        }
    }

    private static void extractPlanetIndexes() {
        extractPlanetRowIndex();
        extractPlanetColIndex();
    }

    private static void extractPlanetRowIndex() {
        final long[] rowIndex = {0L};
        Arrays.stream(INPUT.split("\n")).forEach(r -> {
            int index = 0;
            while((index = r.indexOf("#", index)) != -1){
                indexesEmptyCol.remove(index);
                planetIndexes.add(new long[]{rowIndex[0], index});
                index++;
            }
            rowIndex[0] = r.contains("#") ? rowIndex[0]+1 : rowIndex[0] + 1000000;
//            rowIndex[0] = r.contains("#") ? rowIndex[0]+1 : rowIndex[0] + 2;
        });
    }

    private static void extractPlanetColIndex() {
       long expandCoefficient = 999999;
//        long expandCoefficient = 1;
        long offset = 0;
        for (Integer index : indexesEmptyCol) {
            for (long[] planetIndex : planetIndexes) {
                if (planetIndex[1] >= index + offset * expandCoefficient) {
                    planetIndex[1] = planetIndex[1] + expandCoefficient;
                }
            }
            offset++;
        }

    }

    private static final String INPUT = """
            ..............................#.........................#.......................#..............................#.........................#..
            ....#.....#...................................#.............................................................................................
            .....................................#..................................#...................................................................
            ...................................................#....................................................................#...................
            ...............................................................#..................#...............................#.........................
            ...............#.......................................#...................................#.....#.......#.........................#........
            ............................................................................................................................................
            ............................................................................#...............................................................
            .......#.......................#....................#.......................................................................................
            ........................#..................#....................................................................#...........................
            ..#.......................................................#.........#....................#....................................#.............
            ..............#...........................................................#..........................................................#......
            ......................................#...........................................#..........................#..............................
            .....................................................#.........#..........................................................................#.
            #.......#....................................#.................................................#............................................
            ..............................#.......................................#..............#....................#..........#......................
            ....#...................................#...................................................................................................
            ....................................................................................................#.......................................
            .....................#...........#...............................................#..................................................#.......
            ...............................................#.........#..................................................#..................#............
            ..........................................................................#...............#........................#........................
            .................#.......................................................................................................#..................
            ......................................................................................#..................#..............................#...
            .............#...................................................................................#..........................................
            #...........................#..........#....................................................................................................
            .........#........................................................................#...............................#.........................
            .....................#.........................#.....................................................#....................#......#..........
            .....................................................................#......................................................................
            ................................#.....................................................................................................#.....
            ...............#..........................................#.................#................#..............................................
            ....................................#...........................#...........................................#...............................
            .......#...................#................#.......................................#..............................#......................#.
            ......................#.................................................#................................................#..................
            ....................................................#......................................#............#...................................
            .............#........................#..........................................................#.............#............................
            ...................#..............................................................#.........................................................
            .........................................................#..................#..........#....................................................
            ........................#.....................#..............................................#.........................................#....
            .................................................................#.........................................#...................#............
            ...................................................#........#.....................................#......................#..................
            .........#....................#.......#................................................................#............#.......................
            #.............................................................................#.....................................................#.......
            ..................#.......#.................................................................................................................
            .............#........................................................#........................#................#..........#..............#.
            .....................................................#......................................................................................
            .......#...............#.................#......................#................#..........................................................
            ...................................#.....................................................#............................#.....................
            ............................................................................................................................................
            ...............................#........................................#.........................#.........................................
            .....#.........#...............................#...................#.....................................................................#..
            ............................................................................................................................................
            ..........#......................................................................#..........................................................
            .........................................#.............................................#......#...................#...................#.....
            ........................#.....#........................................................................#....................................
            ...................................................#.....#...................#..............................................................
            ....................................................................#...............#....................................#........#.........
            ...........................#..............................................................#.................................................
            ...#........................................#.........#.......................................................#..............#..............
            ..........#....................................................#................#...........................................................
            ..................................#..................................................................................#...............#......
            .................#..........................................................................................................................
            ............................................................................................................................................
            ............................#.............#................................#.........................#.....................#................
            .........#.........................................#............#.........................#............................................#....
            ....#................................................................#.........................#..............#.............................
            ...................#......................................#.................................................................................
            ..............................#......#..............................................#..............#................#.......................
            .............................................................................#..............................................................
            .......#.........................................................................................................................#..........
            ..............#............#....................#...................#............#.......#.................................#................
            ................................#......................#................................................#.................................#.
            ............................................................................................................................................
            .#......................#......................................#...............................................#............................
            ........................................................................#............................#......................................
            ..................................................#..........................#..........................................#.......#...........
            .........................................#..........................................#....................#..............................#...
            ......#...............#.................................#...................................................................................
            ....................................#.......................................................................................................
            ...............................................................#................#........#.........................#..........#.............
            ..#........#.....#..........#...................#...................................................#.......................................
            .......................................#...........................#...........................................#............................
            .............................................................................#..............................................................
            .......................#..................................#............#...............#.......#.....................................#......
            ............................................................................................................................................
            ............#.....#................................#...........#...................................................#............#...........
            ...........................................#..............................................#.................................................
            ..................................#..............................................#.....................#....................................
            ..................................................................#.........................................................................
            ...#..........................#............................................#................................................................
            .......................................................#..........................................#........#........#.......................
            .......................................#.................................................................................#......#...........
            .................................................#..........#.........#.......................#.............................................
            ............................................................................................................................................
            ....#...........#........................................................................................#.......#...........#..............
            ......................#...........#.......#....................#..............#.....#.......................................................
            .........#...............................................................................#..................................................
            ..................................................#.........................................................................................
            ...................#......................................#...........................................#...........................#......#..
            .............#..........#.....................#....................#........................................................................
            ...............................................................................#.....#.....#.................#......#.......................
            ...#.........................#...................................................................#........................#.................
            ............................................................................................................................................
            .......#.........#..........................................#...............................................................................
            .................................#..............................................................................................#...........
            ........................................................................#..............#.......#..................#........................#
            .#...................................#......#......#........................................................................................
            ............................................................................................................................................
            .............#................#............................................................#..............#.................................
            ......#.....................................................#.......................#................#...............................#......
            ...................#..............................................#.......................................................#.................
            ....................................#.....................................#.................................................................
            ........................................................................................................#.......#...........................
            ....#.....................................#...............#...................#...............#.........................................#...
            .....................................................................................#......................................................
            ....................................................#...........#......................................................#............#.......
            ........................#...................................................................................#...............................
            ............................................................................#.....#.........#......................#........................
            ...#.....#.....#.......................#....................................................................................................
            ............................................................................................................................................
            ......................................................................#.....................................................................
            ......................................................................................#............#..........................#.............
            .....#.............#.........................................................#................#.............................................
            ..............................#..........#............#.....#...........................................................#.............#.....
            ........................................................................#................#..................................................
            ..................................................................................#.........................................................
            ......................#.............#....................#........................................................#.........................
            .................#................................#.............#.............#.............................................................
            ............................................................................................................................................
            ...#..........................#.............#....................................................#.......#...............#.........#........
            ........#...........#.................#..................................................................................................#..
            ..............#.................................#.....#..........................................................#..........................
            ...........................................................#......#.........................................................................
            ............................#..................................................#.....................................#......................
            ...................................................#.......................................#................................................
            .#................#................#...............................................#...........................................#.....#......
            .............#....................................................................................................#.........................
            .........................#...........................................#.....#......................#..........#..............................
            ........................................#...................#...........................................#...................................
            ...#......#............................................................................#....................................................
            ...............................................#.......................................................................#....................""";
}
