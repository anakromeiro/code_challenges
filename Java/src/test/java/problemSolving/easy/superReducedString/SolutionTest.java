package problemSolving.easy.superReducedString;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution s = new Solution();
    Map<String, String> inputExpectedResultMap = new HashMap<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        inputExpectedResultMap.put("baab", "Empty String");
        inputExpectedResultMap.put("aa", "Empty String");
        inputExpectedResultMap.put("bbaab", "b");
        inputExpectedResultMap.put("aaabccddd", "abd");
    }

    @org.junit.jupiter.api.Test
    void superReducedStringCase() {
        for(Map.Entry<String, String> entry : inputExpectedResultMap.entrySet()) {
            assertEquals(entry.getValue(),s.superReducedString(entry.getKey()),"Test case: " + entry.getKey());
        }
    }

    @org.junit.jupiter.api.Test
    void superReducedStringRegex() {
        for(Map.Entry<String, String> entry : inputExpectedResultMap.entrySet()) {
            assertEquals(entry.getValue(),s.superReducedStringRegex(entry.getKey()), "Test case: " + entry.getKey());
        }
    }
}