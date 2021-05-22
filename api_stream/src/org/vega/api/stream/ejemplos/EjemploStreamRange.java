package org.vega.api.stream.ejemplos;


import java.util.IntSummaryStatistics;
import java.util.stream.*;

public class EjemploStreamRange {
    public static void main(String[] args) {



        IntStream stream = IntStream.range(5, 20).peek(System.out::println);

        // Using IntStream summaryStatistics()
        IntSummaryStatistics summary_data =
                stream.summaryStatistics();

        // Displaying the various summary data
        // about the elements of the stream
        System.out.println(summary_data);



        System.out.println("el num max = " + summary_data.getMax());
        System.out.println("el num min = " + summary_data.getMin());

    }
}
