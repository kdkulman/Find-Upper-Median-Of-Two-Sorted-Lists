public class Main {

    public static void main(String[] args){

        //Array constraints:
            //Sorted
            //Equal length
            //Not empty
            //No duplicate elements

        //Feel free to alter the array while adhering to constraints
        int[] A = {3, 7, 20, 43, 50};
        int[] B = {1, 14, 16, 37, 42};
        int answer = findUpperMedianOfTwoSortedLists(A, B);
        System.out.println("Upper median of two sorted lists: " + answer);
    }

    private static int findUpperMedianOfTwoSortedLists(int[] A, int[] B) {
        int n = A.length;
        int upperMedian = (int) (Math.floor(n / 2.0));
        if (n == 1) return Math.max(A[0], B[0]);
        if (A[upperMedian] > B[upperMedian]){
            A = cutArrayInHalf(0, upperMedian, A);
            B = cutArrayInHalf(upperMedian, n - 1, B);
        } else {
            A = cutArrayInHalf(upperMedian, n - 1, A);
            B = cutArrayInHalf(0, upperMedian, B);
        }
        return findUpperMedianOfTwoSortedLists(A, B);
    }

    private static int[] cutArrayInHalf(final int start, final int end, int[] array){
        int[] arrayToReturn = new int[end - start + 1];
        for (int i = 0; i < arrayToReturn.length; i++){
            arrayToReturn[i] = array[start+i];
        }
        return arrayToReturn;
    }
}
