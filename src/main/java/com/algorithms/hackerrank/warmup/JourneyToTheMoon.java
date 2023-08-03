package com.algorithms.hackerrank.warmup;

import org.apache.commons.lang3.tuple.Pair;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class JourneyToTheMoonSolution {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER (number of possible austronauts pairs from different countries)
     * The function accepts following parameters:
     *  1. INTEGER n - number of astronauts
     *  2. 2D_INTEGER_ARRAY - pair of astronauts
     */

    public static Integer journeyToMoon(int n, List<List<Integer>> astronaut) {
        Long astronautsLimit = 2L;
        List<List<Integer>> uniqueAstronautsByCountry = getUniqueAstronautsGroupedByCountry(n, astronaut);
        List<Integer> allCountrySizes = uniqueAstronautsByCountry.stream().map(country -> country.size()).collect(Collectors.toList());
        List<Pair<Integer, Integer>> combinationsOfCountries = makeCombiPairsWithoutRepetition(allCountrySizes.size(), 2);
        return countAllPossiblePairs(allCountrySizes, combinationsOfCountries);
        //Long countOfSingleCountries = allCountrySizes.stream().filter(size -> size == 1).count();
        //Long combinationOfSingleCountriesWithoutRepetition = getCombinationsWithoutRepetition(countOfSingleCountries, astronautsLimit);
        //List<Integer> multiAstroCountries = allCountrySizes.stream().filter(size -> size > 1).collect(Collectors.toList());
    }

    private static List<Pair<Integer, Integer>> makeCombiPairsWithoutRepetition(int m, int n) {
        //TODO Journey to the moon: Complete the method implementation
        return Collections.emptyList();
    }

    private static List<List<Integer>> getUniqueAstronautsGroupedByCountry(int n, List<List<Integer>> astronautsByCountry){
        Set<Integer> countriesWithSingleAstronaut = IntStream.range(0, n).boxed().collect(Collectors.toSet());
        Set<Integer> uniqueAstronautsWithoutCountry = astronautsByCountry
                .stream()
                .flatMap(astronautsFromOneCountry -> astronautsFromOneCountry.stream())
                .collect(Collectors.toSet());
        countriesWithSingleAstronaut.removeAll(uniqueAstronautsWithoutCountry);
        //TODO Journey to the moon: Complete the method implementation
/*        countriesWithSingleAstronaut = countriesWithSingleAstronaut.stream()
                .map(countryId -> List.of(countryId))
                .collect(Collectors.toSet());*/

        return Collections.emptyList();
    }

    private static Integer countAllPossiblePairs(List<Integer> allCountrySizes, List<Pair<Integer, Integer>> combinationsOfCountries){
        return combinationsOfCountries.stream()
                .map(combi -> allCountrySizes.get(combi.getLeft()) * allCountrySizes.get(combi.getRight()))
                .reduce(0, Integer::sum);
    }

    public static long getCombinationsWithoutRepetition(long fullCountOfElements, long subsetSize){
        return factorial(fullCountOfElements) / ( factorial(subsetSize) * factorial(fullCountOfElements - subsetSize));
    }
    public static long factorial(long x){
        if (x==0 || x==1)
            return 1;

        return x * factorial(x-1);
    }

}

public class JourneyToTheMoon {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = JourneyToTheMoonSolution.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}