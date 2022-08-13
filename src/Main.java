public class Main {

    public static void main(String[] args){

        //Array constraints:
            //Sorted
            //Equal length
            //Not empty
            //No duplicate elements

        //Feel free to alter the array while adhering to constraints
        int[] A = {1, 2, 3, 4};
        int[] B = {5, 6, 7, 8};
        int answer = findUpperMedianOfTwoSortedLists(A, B);
        System.out.println("Upper median of two sorted lists: " + answer);
    }

    private static int findUpperMedianOfTwoSortedLists(int[] A, int[] B) {
        int n = A.length;
        int upperMedian = (int) (Math.ceil(n / 2.0));
        if (n == 1) return Math.max(A[0], B[0]);
        if (A[upperMedian] > B[upperMedian]){
            A = cutArrayInHalf(0, upperMedian - 1, A);
            B = cutArrayInHalf(n - upperMedian, n - 1, B);
        } else {
            A = cutArrayInHalf(n - upperMedian, n - 1, A);
            B = cutArrayInHalf(0, upperMedian - 1, B);
        }
        return findUpperMedianOfTwoSortedLists(A, B);
    }

    private static int[] cutArrayInHalf(final int start, final int end, int[] array){
        int length = end - start + 1;
        int[] arrayToReturn = new int[length];
        for (int i = 0; i < length; i++) arrayToReturn[i] = array[start+i];
        return arrayToReturn;
    }
}
