import java.util.*;

public class day05 {

    private static final Map<Long, long[]> seedsToSoilMap = new TreeMap<>();
    private static final Map<Long, long[]> soilToFertilizerMap = new TreeMap<>();
    private static final Map<Long, long[]> fertilizerToWaterMap = new TreeMap<>();
    private static final Map<Long, long[]> waterToLightMap = new TreeMap<>();
    private static final Map<Long, long[]> lightToTemperatureMap = new TreeMap<>();
    private static final Map<Long, long[]> temperatureToHumidityMap = new TreeMap<>();
    private static final Map<Long, long[]> humidityToLocationMap = new TreeMap<>();

    private static List<String> seedsToSoil = new ArrayList<>();
    private static List<String> soilToFertilizer = new ArrayList<>();
    private static List<String> fertilizerToWater = new ArrayList<>();
    private static List<String> waterToLight = new ArrayList<>();
    private static List<String> lightToTemperature = new ArrayList<>();
    private static List<String> temperatureToHumidity = new ArrayList<>();
    private static List<String> humidityToLocation = new ArrayList<>();

    public static void main(String[] args) {
        String[] category = INPUT.split("\\s{2,}");
        long[] seeds = Arrays.stream(category[0].substring(category[0].indexOf(" ") + 1).split("\\s+")).mapToLong(Long::parseLong).toArray();

        categoryToList(category);
        mapAllCategory();

        long minLocation = Long.MAX_VALUE;

        for (int i = 0; i < seeds.length; i += 2) {
            long seedStart = seeds[i];
            long seedEnd = seedStart + seeds[i+1];

            for (long source = seedStart ; source <= seedEnd; source++ ) {
                long location = getLocation(source);
                if (location < minLocation) minLocation = location;
            }
        }

        System.out.println(minLocation);
    }

    private static long getLocation(long source) {
        long location = 0;
        location = getNextLocation(source, seedsToSoilMap);
        location = getNextLocation(location, soilToFertilizerMap);
        location = getNextLocation(location, fertilizerToWaterMap);
        location = getNextLocation(location, waterToLightMap);
        location = getNextLocation(location, lightToTemperatureMap);
        location = getNextLocation(location, temperatureToHumidityMap);
        location = getNextLocation(location, humidityToLocationMap);
        return location;
    }

    private static long getNextLocation(long source, Map<Long, long[]> map) {
        List<Long> keysToList = map.keySet().stream().toList();

        for (int i = keysToList.size()-1; i >= 0; i--) {
            Long sourceInMap = keysToList.get(i);

            if (source >= sourceInMap) {
                if(source > sourceInMap + map.get(sourceInMap)[1]) {
                    return source;
                } else {
                    long diff = source - sourceInMap;
                    return map.get(sourceInMap)[0] + diff;
                }
            }
        }

        return source;
    }

    private static void categoryToList(String[] category) {
        seedsToSoil = getCategoryToList(category[1], "seed-to-soil");
        soilToFertilizer = getCategoryToList(category[2], "soil-to-fertilizer");
        fertilizerToWater = getCategoryToList(category[3], "fertilizer-to-water");
        waterToLight = getCategoryToList(category[4], "water-to-light");
        lightToTemperature = getCategoryToList(category[5], "light-to-temperature");
        temperatureToHumidity = getCategoryToList(category[6], "temperature-to-humidity");
        humidityToLocation = getCategoryToList(category[7], "humidity-to-location");
    }

    private static void mapAllCategory() {
        mapCategory(seedsToSoil, seedsToSoilMap);
        mapCategory(soilToFertilizer, soilToFertilizerMap);
        mapCategory(fertilizerToWater, fertilizerToWaterMap);
        mapCategory(waterToLight, waterToLightMap);
        mapCategory(lightToTemperature, lightToTemperatureMap);
        mapCategory(temperatureToHumidity, temperatureToHumidityMap);
        mapCategory(humidityToLocation, humidityToLocationMap);
    }

    private static void mapCategory(List<String> source, Map<Long, long[]> destinationMap) {
        source.forEach(e -> {
            long[] split = Arrays.stream(e.split("\\s")).mapToLong(Long::parseLong).toArray();
            long[] location = new long[2];
            long destination = split[1];
            location[0] = split[0];
            location[1] = split[2];
            destinationMap.put(destination, location);
        });

    }

    private static List<String> getCategoryToList(String category, String categoryRegex) {
        return Arrays.stream(category.split(categoryRegex + " map:\\s+|\\n+")).skip(1).toList();
    }

    public static String INPUT =
            "seeds: 1972667147 405592018 1450194064 27782252 348350443 61862174 3911195009 181169206 626861593 138786487 2886966111 275299008 825403564 478003391 514585599 6102091 2526020300 15491453 3211013652 546191739\n" +
                    "\n" +
                    "seed-to-soil map:\n" +
                    "325190047 421798005 78544109\n" +
                    "4034765382 1473940091 137996533\n" +
                    "403734156 658668780 288666603\n" +
                    "2574766003 2624114227 17352982\n" +
                    "1931650757 2203381572 98211987\n" +
                    "4263596455 2843660329 31370841\n" +
                    "1614547845 2641467209 55121215\n" +
                    "3441604278 2032673361 170708211\n" +
                    "692400759 563703672 94965108\n" +
                    "2992851755 3824700930 114550818\n" +
                    "3957953582 2540115966 24844899\n" +
                    "0 500342114 59804107\n" +
                    "4172761915 2577017231 47096996\n" +
                    "2029862744 3548344768 52256082\n" +
                    "2620304610 2875031170 99567251\n" +
                    "3982798481 3939251748 51966901\n" +
                    "2325101894 1616388089 203150170\n" +
                    "3612312489 1611936624 4451465\n" +
                    "787365867 0 77461445\n" +
                    "1341614907 4162572181 132395115\n" +
                    "2542801978 3468402968 31964025\n" +
                    "223387052 947335383 59156225\n" +
                    "2297805420 1819538259 27296474\n" +
                    "2082118826 3991218649 171353532\n" +
                    "3374211778 3040047171 67392500\n" +
                    "2592118985 1341614907 28185625\n" +
                    "2253472358 2495782904 44333062\n" +
                    "4219858911 3780963386 43737544\n" +
                    "59804107 560146221 3557451\n" +
                    "3107402573 3600600850 64973479\n" +
                    "1669669060 3115086052 235712356\n" +
                    "2719871861 1369800532 104139559\n" +
                    "3172376052 2301593559 194189345\n" +
                    "2980795389 2564960865 12056366\n" +
                    "1905381416 3350798408 26269341\n" +
                    "63361558 261772511 160025494\n" +
                    "2824011420 3377067749 91335219\n" +
                    "3366565397 3107439671 7646381\n" +
                    "282543277 77461445 42646770\n" +
                    "3713793353 2696588424 147071905\n" +
                    "2528252064 1877585624 14549914\n" +
                    "3927202691 1846834733 30750891\n" +
                    "3665815578 3500366993 47977775\n" +
                    "1474010022 1892135538 140537823\n" +
                    "3616763954 3665574329 49051624\n" +
                    "2915346639 2974598421 65448750\n" +
                    "864827312 120108215 141664296\n" +
                    "3860865258 3714625953 66337433\n" +
                    "\n" +
                    "soil-to-fertilizer map:\n" +
                    "3835605444 4098164436 1662218\n" +
                    "682286299 0 63480553\n" +
                    "396476124 2072802434 285810175\n" +
                    "1644893571 655614677 162631098\n" +
                    "3625179075 4099826654 40627721\n" +
                    "1431211762 1859120625 213681809\n" +
                    "2853687843 4140454375 103601386\n" +
                    "1390165578 2358612609 41046184\n" +
                    "2405285827 3959200676 138963760\n" +
                    "900243562 1478767251 170015757\n" +
                    "3727732722 3084190064 107872722\n" +
                    "893948759 1084467374 6294803\n" +
                    "210337617 818245775 186138507\n" +
                    "1807524669 63480553 592134124\n" +
                    "825849944 1090762177 68098815\n" +
                    "3837267662 3192062786 457699634\n" +
                    "0 1648783008 210337617\n" +
                    "3665806796 2405285827 61925926\n" +
                    "1070259319 1158860992 319906259\n" +
                    "745766852 1004384282 80083092\n" +
                    "2957289229 4244055761 50911535\n" +
                    "2544249587 3649762420 309438256\n" +
                    "3008200764 2467211753 616978311\n" +
                    "\n" +
                    "fertilizer-to-water map:\n" +
                    "1169336944 3024036226 46676171\n" +
                    "1263157944 1445876546 148868263\n" +
                    "2080390054 2683279801 65621604\n" +
                    "949040795 1266013203 61140343\n" +
                    "2146011658 2793621589 110265098\n" +
                    "525510412 2618124082 65155719\n" +
                    "2977122301 3122211455 179751286\n" +
                    "3885825304 713560214 409141992\n" +
                    "1081017627 4124851079 88319317\n" +
                    "590666131 2039951828 38597255\n" +
                    "3596454634 1981772613 58179215\n" +
                    "2256276756 2078549083 315165891\n" +
                    "1639631621 1122702206 143310997\n" +
                    "2858399301 1327153546 118723000\n" +
                    "3654633849 3301962741 72039868\n" +
                    "749412925 3549292249 161128796\n" +
                    "1412026207 541983534 151190298\n" +
                    "1054901322 4268850991 26116305\n" +
                    "1829368778 3374002609 175289640\n" +
                    "1216013115 2570979253 47144829\n" +
                    "2806900243 3070712397 51499058\n" +
                    "1563216505 3760425124 76415116\n" +
                    "1782942618 3710421045 29953038\n" +
                    "629263386 2903886687 120149539\n" +
                    "2060339013 3740374083 20051041\n" +
                    "3156873587 3836840240 52553243\n" +
                    "2693038006 4010988842 113862237\n" +
                    "3726673717 2411827666 159151587\n" +
                    "2004658418 4213170396 55680595\n" +
                    "1812895656 525510412 16473122\n" +
                    "1010181138 2748901405 44720184\n" +
                    "910541721 693173832 20386382\n" +
                    "930928103 2393714974 18112692\n" +
                    "3209426830 1594744809 387027804\n" +
                    "2571442647 3889393483 121595359\n" +
                    "\n" +
                    "water-to-light map:\n" +
                    "555269773 2142838063 230952411\n" +
                    "2879443939 2889030006 80512763\n" +
                    "192641991 2686257040 106620606\n" +
                    "786222184 967781117 56662479\n" +
                    "3467110983 4162792381 132174915\n" +
                    "1955778230 0 505352386\n" +
                    "2461130616 1138855522 99691153\n" +
                    "1436321461 1403321335 440861327\n" +
                    "2625559119 1024443596 104825859\n" +
                    "1255310011 2792877646 96152360\n" +
                    "1877182788 697994377 78595442\n" +
                    "3732975066 3467110983 374194949\n" +
                    "842884663 2373790474 56459390\n" +
                    "299262597 2430249864 256007176\n" +
                    "3599285898 3841305932 133689168\n" +
                    "4107170015 3974995100 187797281\n" +
                    "0 505352386 192641991\n" +
                    "1090535351 1238546675 164774660\n" +
                    "2959956702 1129269455 9586067\n" +
                    "1351462371 1844182662 84859090\n" +
                    "2730384978 1929041752 149058961\n" +
                    "899344053 776589819 191191298\n" +
                    "2560821769 2078100713 64737350\n" +
                    "\n" +
                    "light-to-temperature map:\n" +
                    "4103141199 3912772142 105835099\n" +
                    "1994281004 833968687 112844016\n" +
                    "4208976298 1124841590 85990998\n" +
                    "3756966983 4018607241 111390720\n" +
                    "3868357703 1907239336 234783496\n" +
                    "2368591640 1210832588 293667703\n" +
                    "882426579 2320467318 1111854425\n" +
                    "3064998388 717457244 33489309\n" +
                    "3578938096 946812703 178028887\n" +
                    "2107125020 750946553 83022134\n" +
                    "3157760738 3432321743 421177358\n" +
                    "717457244 4129997961 164969335\n" +
                    "2190147154 2142022832 178444486\n" +
                    "3098487697 3853499101 59273041\n" +
                    "2662259343 1504500291 402739045\n" +
                    "\n" +
                    "temperature-to-humidity map:\n" +
                    "0 1820412620 129662806\n" +
                    "613828383 2855382935 55943394\n" +
                    "4004726464 3519717349 290240832\n" +
                    "769767991 99996214 1720416406\n" +
                    "3126066249 3043992795 475724554\n" +
                    "2490184397 2434241003 421141932\n" +
                    "129662806 1950075426 484165577\n" +
                    "689805485 0 79962506\n" +
                    "669771777 79962506 20033708\n" +
                    "3601790803 3809958181 402935661\n" +
                    "3043992795 4212893842 82073454\n" +
                    "\n" +
                    "humidity-to-location map:\n" +
                    "1305211417 3371927062 89487200\n" +
                    "947159122 0 358052295\n" +
                    "324330151 2021970861 8067408\n" +
                    "332397559 654359706 174171341\n" +
                    "506568900 3311893445 60033617\n" +
                    "11065691 828531047 45586147\n" +
                    "3556729147 369117986 26689998\n" +
                    "3583419145 395807984 258551722\n" +
                    "2356886904 984938593 400606547\n" +
                    "1394698617 874117194 110821399\n" +
                    "566602517 3946624826 164852367\n" +
                    "2998901322 2301963630 256425441\n" +
                    "0 358052295 11065691\n" +
                    "3331964991 3087129289 34908052\n" +
                    "1505520016 2106676497 195287133\n" +
                    "56651838 2819450976 267678313\n" +
                    "3366873043 3293025783 18867662\n" +
                    "3385740705 3122037341 170988442\n" +
                    "2281795782 2799796942 19654034\n" +
                    "2301449816 1966533773 55437088\n" +
                    "3992934054 3677118500 118543139\n" +
                    "3255326763 2030038269 76638228\n" +
                    "3849868384 3803559156 143065670\n" +
                    "2757493451 2558389071 241407871\n" +
                    "3841970867 3795661639 7897517\n" +
                    "1700807149 1385545140 580988633\n" +
                    "731454884 3461414262 215704238";

    public static String INPUT_ONE = "seeds: 79 14 55 13\n" +
            "\n" +
            "seed-to-soil map:\n" +
            "50 98 2\n" +
            "52 50 48\n" +
            "\n" +
            "soil-to-fertilizer map:\n" +
            "0 15 37\n" +
            "37 52 2\n" +
            "39 0 15\n" +
            "\n" +
            "fertilizer-to-water map:\n" +
            "49 53 8\n" +
            "0 11 42\n" +
            "42 0 7\n" +
            "57 7 4\n" +
            "\n" +
            "water-to-light map:\n" +
            "88 18 7\n" +
            "18 25 70\n" +
            "\n" +
            "light-to-temperature map:\n" +
            "45 77 23\n" +
            "81 45 19\n" +
            "68 64 13\n" +
            "\n" +
            "temperature-to-humidity map:\n" +
            "0 69 1\n" +
            "1 0 69\n" +
            "\n" +
            "humidity-to-location map:\n" +
            "60 56 37\n" +
            "56 93 4";
}
