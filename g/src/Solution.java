import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'sortIntersect' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY volcanic
     *  2. INTEGER_ARRAY nonVolcanic
     */

    public static List<Integer> sortIntersect(List<Integer> volcanic, List<Integer> nonVolcanic) {
        // Write your code here

        ArrayList<Integer> salida = new ArrayList<>();

        int tam1 = nonVolcanic.size();
        for (int i = 0; i < tam1; i++) {

            if (volcanic.contains(nonVolcanic.get(i))) {
                if (!salida.contains(nonVolcanic.get(i))) {
                    salida.add(nonVolcanic.get(i));
                }
            }
        }
        Collections.sort(salida, Collections.reverseOrder());
        return salida;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int volcanicCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> volcanic = IntStream.range(0, volcanicCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int nonVolcanicCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> nonVolcanic = IntStream.range(0, nonVolcanicCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.sortIntersect(volcanic, nonVolcanic);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}