package oyvindr.rammeverk.beregning;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by x0xoyr on 09.02.17.
 */
public class InfoTre {

    static Map<String, String> tre = new HashMap<String, String>();

    static public void test() {

        tre.put("FormueInntekt.Bank(DnB).Konto(12345).OpptjenteRenter",      "100");
        tre.put("FormueInntekt.Bank(DnB).Konto(12345).Innskudd",    "10000");
        tre.put("FormueInntekt.Bank(DnB).Konto(11111).OpptjenteRenter",      "111");
        tre.put("FormueInntekt.Bank(DnB).Konto(11111).Innskudd",    "11000");
        tre.put("FormueInntekt.Bank(DnB).Konto(22222).OpptjenteRenter",      "222");
        tre.put("FormueInntekt.Bank(DnB).Konto(22222).Innskudd",    "22000");
        tre.put("FormueInntekt.Bank(SpB1).Konto(X22222).OpptjenteRenter",    "999");
        tre.put("FormueInntekt.Bank(SpB1).Konto(X22222).Innskudd",  "99 000");
        tre.put("FormueInntekt.Diverse.OpptjenteRenter",                     "7777");
        tre.put("FormueInntekt.Bank(DnB).Orgnr",                    "987654321");

        // sum av DnB verdier
        long antall_DnB = tre.entrySet().stream()
                .filter(e -> e.getKey().contains("DnB"))
                .map(e -> Integer.parseInt(e.getValue()))
                .count();

        // sum av DnB verdier

        long sum_DnB = tre.entrySet().stream()
                .filter(e -> e.getKey().contains("DnB"))
                .mapToInt(e -> Integer.parseInt(e.getValue()))
                .sum();


        long sum_SpB1_renter = tre.entrySet().stream()
                .filter(e -> e.getKey().contains("SpB1"))
                .filter(e -> e.getKey().contains("OpptjenteRenter"))
                .mapToInt(e -> Integer.parseInt(e.getValue()))
                .sum();

        tre.put("FormueInntekt.Bank(SpB1).SamletInnskudd", String.valueOf(sum_SpB1_renter));
        tre.put("FormueInntekt.Bank(SpB1).SamletInnskudd", String.valueOf(sum_SpB1_renter+100)); // test på oppdatering

        //String test = tre.get("FormueInntekt.Bank(DnB).Orgnr");
        System.out.println("Dnb orgnr " + tre.get("FormueInntekt.Bank(DnB).Orgnr") + " Antall: " + antall_DnB + " SumDnb: " + sum_DnB + " DnBRenter:" + sum_SpB1_renter);


        tre.forEach((k,v)->System.out.println("Item : " + k + " Value : " + v));

        testAppend(tre);
        skivUtSortert();
    }

    static private void skivUtSortert () {

        tre.entrySet().stream()
                .sorted((e1,e2)-> e1.getKey().compareTo(e2.getKey()))
                .forEach(e->{ System.out.println("Key." + e.getKey() + " Value:" + e.getValue() );
        });
    }

    static private void testAppend (Map inMap) {

            HashMap<String, String> newmap1 = new HashMap<String, String>();

            newmap1.put("FormueInntekt.Bank(DnB).Konto(11111).Innskudd",    "11000");
            newmap1.put("FormueInntekt.Bank(DnB).Konto(22222).OpptjenteRenter",      "222");
            newmap1.put("FormueInntekt.Bank(DnB).Konto(22222).Innskudd",    "22000");
            newmap1.put("FormueInntekt.Bank(SpB1).Konto(X22222).OpptjenteRenter",    "999");


            System.out.println("Values in newmap1: "+ newmap1);

            // put all values in newmap2
            inMap.putAll(newmap1);

            //System.out.println("Values in newmap2: "+ newmap2);

    }


}
