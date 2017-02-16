package oyvindr.rammeverk.beregning;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oyvin on 16.02.2017.
 */
public class TestSpeedHashmap {

    public static void main(final String[] args)  {
        Map<String, Integer> xmlHM = new HashMap<>();

        for (Integer i=0; i < 100000; i++)
            xmlHM.put (Integer.toString(i), i);

        Stopwatch timer1 = new Stopwatch();
        xmlHM.entrySet().stream().parallel()
            .mapToInt(e ->e.getValue()).sum();

        double time1 = timer1.elapsedTime();
        System.out.printf ("%.6f seconds", time1);
    }
}
