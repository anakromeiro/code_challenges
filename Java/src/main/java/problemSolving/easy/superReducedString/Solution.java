package problemSolving.easy.superReducedString;

import java.util.regex.Pattern;

public class Solution {

    public String superReducedString(String s) {
        int i = 0;
        while (i+1 < s.length()){
            if (s.charAt(i) == s.charAt(i+1)){
                s = s.substring(0,i) + s.substring(i+2);
                if (i != 0) {
                    i--;
                }
                //TODO What is the cost?
                continue;
            }
            i++;
        }
        if (s.isEmpty())
            return "Empty String";
        return s;
    }

    public String superReducedStringRegex(String s) {
        Pattern p = Pattern.compile("([a-z])\\1");
        while (p.matcher(s).find()){
            s = s.replaceAll(p.pattern(), "");
        }
        if (s.isEmpty())
            return "Empty String";
        return s;
    }
}
