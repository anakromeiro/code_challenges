package interviewPreparationKit.arrays.leftRotation;

/**
 * Difficulty: EASY
 */
public class Solution {

    public int[] rotLeft(int[] a, int d){
        int[] resultArray = new int[a.length];
        int indexAux = 0;
        if (a.length == d){
            return a;
        }
        for (int i = d; i < a.length ; i++) {
            resultArray[indexAux] = a[i];
            indexAux++;
        }
        for (int i = 0; i < d; i++) {
            resultArray[indexAux] = a[i];
            indexAux++;
        }
        return resultArray;
    }

    /**
     * This class is used only to support the tests.
     */
    static class InputParams{
        private int[] array;
        private int rotation;

        public InputParams(int[] array, int rotation) {
            this.array = array;
            this.rotation = rotation;
        }

        public int[] getArray() {
            return array;
        }

        public int getRotation() {
            return rotation;
        }
    }
}
