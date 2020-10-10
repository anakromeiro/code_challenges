package interviewPreparationKit.arrays.leftRotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution s = new Solution();
    Map<Solution.InputParams, int[]> inputExpectedResultMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        inputExpectedResultMap.put(new Solution.InputParams(new int[]{1,2,3,4,5},4), new int[]{5,1,2,3,4});
        inputExpectedResultMap.put(new Solution.InputParams(new int[]{1,2,3,4,5},5), new int[]{1,2,3,4,5});
        inputExpectedResultMap.put(new Solution.InputParams(new int[]{1,2,3,4,5},1), new int[]{2,3,4,5,1});
    }

    @Test
    void rotLeft() {
        for(Map.Entry<Solution.InputParams, int[]> entry : inputExpectedResultMap.entrySet()) {
            //  EXP02-J. Do not use the Object.equals() method to compare two arrays. Arrays.equals is the compliant solution
            assertTrue(Arrays.equals(entry.getValue(),s.rotLeft(entry.getKey().getArray(),entry.getKey().getRotation())),"Test case: Array: " + Arrays.toString(entry.getKey().getArray()) + " Rotation: " + entry.getKey().getRotation());
        }
    }
}