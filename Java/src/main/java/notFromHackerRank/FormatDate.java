package notFromHackerRank;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class FormatDate {
    public static void main(String[] args) throws IOException, ParseException {
        Map months = new HashMap<String, String>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        String dateToTransform = "1st Mar 1984";

        String dataRegex[] = dateToTransform.split(" ");

        StringBuilder dateNewFormat = new StringBuilder();
        dateNewFormat.append(dataRegex[2]);
        dateNewFormat.append("-");
        dateNewFormat.append(months.get(dataRegex[1]));
        dateNewFormat.append("-");
        dateNewFormat.append(formatDay(dataRegex[0]));
        System.out.println(dateNewFormat);
    }

    private static String formatDay(String s){
        String removeString = s.replaceAll("(st|nd|th)$", "");
//        removeString = removeString.replaceAll("^(\\d)$", "0$1");
        removeString = removeString.replaceAll("^([0-9])$", "0$1");
        if (removeString.length() == 1){
            //removeString = "0"+removeString;
        }
        return removeString;
    }
}
