package oyvindr.rammeverk.beregning;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by x0xoyr on 09.02.17.
 */
public class InfoTre {


    static public void test() {
        HashMap<String, String> tre = new HashMap<String, String>();

        tre.put("FormueInntekt.Bank(DnB).Konto(12345).Renter",      "100");
        tre.put("FormueInntekt.Bank(DnB).Konto(12345).Innskudd",    "10000");
        tre.put("FormueInntekt.Bank(DnB).Konto(11111).Renter",      "111");
        tre.put("FormueInntekt.Bank(DnB).Konto(11111).Innskudd",    "11000");
        tre.put("FormueInntekt.Bank(DnB).Konto(22222).Renter",      "222");
        tre.put("FormueInntekt.Bank(DnB).Konto(22222).Innskudd",    "22000");
        tre.put("FormueInntekt.Bank(SpB1).Konto(X22222).Renter",    "999");
        tre.put("FormueInntekt.Bank(SpB1).Konto(X22222).Innskudd",  "99 000");
        tre.put("FormueInntekt.Diverse.Renter",                     "7777");
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


        long sum_DnB_renter = tre.entrySet().stream()
                .filter(e -> e.getKey().contains("DnB"))
                .filter(e -> e.getKey().contains("Renter"))
                .mapToInt(e -> Integer.parseInt(e.getValue()))
                .sum();

        //String test = tre.get("FormueInntekt.Bank(DnB).Orgnr");
        System.out.println("Dnb orgnr " + tre.get("FormueInntekt.Bank(DnB).Orgnr") + " Antall: " + antall_DnB + " SumDnb: " + sum_DnB + " DnBRenter:" + sum_DnB_renter);
    }

}
