class HW1 {
    public static void main(String args[]) {
        
        System.out.println("==== Test Problem 1 ====");
        double threshold = 1E-8;
        int[] arr1 = new int[] {3, 5, 1, 6, 7};
        double yourAverage = average(arr1);
        double expectAverage = (3 + 5 + 1 + 6 + 7) * 1.0 / 5;
        if(arr1.length > 0){
            if (Math.abs(yourAverage - expectAverage)<threshold){
                System.out.println("Pass");
            }
            else{
                System.out.println("Fail");
                System.out.println("Got: "+yourAverage);
                System.out.println("Expect: "+expectAverage);
            }
        }
        System.out.println("==== End of Problem 1 test ====");
        System.out.println("\n");

        System.out.println("==== Test Problem 1 ====");
        arr1 = new int[] {0, 0, 0};
        yourAverage = average(arr1);
        expectAverage = 0;
        if(arr1.length > 0){
            if (Math.abs(yourAverage - expectAverage)<threshold){
                System.out.println("Pass");
            }
            else{
                System.out.println("Fail");
                System.out.println("Got: "+yourAverage);
                System.out.println("Expect: "+expectAverage);
            }
        }
        System.out.println("==== End of Problem 1 test ====");
        System.out.println("\n");

        System.out.println("==== Test Problem 2 ====");
        double[] arr2 = new double[] {41.2, 15.5, 250.2, 92.8, 271.2, 31.2};
        double yourMaxDouble = maxOfArray(arr2);
        double expectMaxDouble = 271.2;
        if (yourMaxDouble == expectMaxDouble){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
            System.out.println("Got: "+yourMaxDouble);
            System.out.println("Expect: "+expectMaxDouble);
        }

        char[] arr3 = new char[] {'u', 'c', 'l', 'a', 'P', 'I', 'C', '2', '0', 'A'};
        char yourMaxChar = maxOfArray(arr3);
        char expectMaxChar = 'u';
        if (yourMaxChar == expectMaxChar){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
            System.out.println("Got: "+yourMaxChar);
            System.out.println("Expect: "+expectMaxChar);
        }
        System.out.println("==== End of Problem 2 test ====");
        System.out.println("\n");



        System.out.println("==== Test Problem 3 ==== ");
        int[][] square = new int[][] {{2,7,14,11}, {9,16,5,4},{15,10,3,6},{8,1,12,13}};
        boolean yourFlag = isMagicSquare(square);
        boolean expectFlag = true;
        if(yourFlag == expectFlag){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
            System.out.println("Got: "+yourFlag);
            System.out.println("Expect: "+expectFlag);
        }
        System.out.println("==== End of Problem 3 test ====");
        System.out.println("\n");



        System.out.println("==== Test Problem 4 ====");
        int[] yourFirstNPrimes = firstPrimes(1);
        int[] expectFirstNPrimes = new int[] {2, 3, 5, 7, 11, 13, 17, 19};
        if(java.util.Arrays.equals(yourFirstNPrimes, expectFirstNPrimes)){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
            System.out.println("Got: "+java.util.Arrays.toString(yourFirstNPrimes));
            System.out.println("Expect: "+java.util.Arrays.toString(expectFirstNPrimes));
        }
        System.out.println("==== End of Problem 4 test ====");
        System.out.println("\n");


    }


    /**
     * Problem 1
     * Computes the mean of the values in an array of ints.
     * 
     * By convention, the mean of no ints is Double.NaN. 
     * That is, if arr is empty, you directly return Double.NaN.
     * 
     * @param arr a reference to an array of ints
     * @return the mean of the values stored
     *         in the array that 'arr' references
    */
    public static double average(int[] arr) {
        if(arr.length == 0){
            return Double.NaN;
        }
        double sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];

        }
        return sum / arr.length;
        
    }


    /**
     * Problem 2
     * Returns the maximum value of a double array
     * 
     * By convention, if arr is empty, you directly return Double.NaN.
     * 
     * Example:
     * 
     * double[] arr = new double[] {4.0, 5.1, 8.2, 1.4};
     * maxValue = maxOfArray(arr); // maxValue should equal to 8.2
     * 
     * @param arr the double array
     * @return maximum value of arr
    */
    public static double maxOfArray(double[] arr) {
        if(arr.length == 0){
            return Double.NaN;
        }
        double max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Returns the maximum value (in ASCII value) of a char array
     * 
     * By convention, if arr is empty, you directly return 0.
     * 
     * Example:
     * 
     * char[] arr = new char[] {'P', 'I', 'C', '2', '0', 'A'};
     * maxValue = maxOfArray(arr); // maxValue should equal to 'P' which has the maximum ASCII value 80
     * 
     * hint: You can directly use ">" or "<" to compare the ASCII values of char variables.
     * 
     * @param arr the char array
     * @return maximum value of arr
     */
    public static char maxOfArray(char[] arr) {
        if(arr.length == 0){
            return 0;
        }
        char max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }


    /**
     * Problem 3
     * Says whether an array of an array of ints
     * is a magic square or not.
     * 
     * The conditions to be a magic square are...
     *   1. it's a square;
     *   2. if square.length == N, then it stores
     *     each of the numbers 1 through N*N exactly once;
     *   3. the sums of
     *      - the rows
     *      - the columns
     *      - both main diagonals
     *     are the same.
     * 
     * We will always test your function by using arrays that SATISFY conditions 1 and 2,
     * that means, you ONLY need to check condition 3 in the function isMagicSquare.
     * 
     * For example, the following are magic squares...
     *      
     *     8 3 4
     *     1 5 9
     *     6 7 2
     * 
     *      2  7 14 11
     *      9 16  5  4
     *     15 10  3  6
     *      8  1 12 13
     * 
     * ...and the following are NOT magic squares.
     * 
     *     1 4
     *     2 3
     * 
     *     5 5 5
     *     5 5 5
     *     5 5 5
     * 
     * One can regard the empty array of arrays as magic.
     * 
     * @param square a reference to an array of an array of ints
     * @return true if 'square' references a magic square;
     *         false otherwise
    */
    public static boolean isMagicSquare(int[][] square) {
        int sum = 0;
        int sum2 = 0;
        int j = 0; 

        if(square.length == 0){
            return true; 
        }


        //base sum
        for(int i = 0; i<square.length; i++){
            sum += square[0][i];
        }
        

        for(int i = 1; i<square.length; i++){
            j = 0;
            sum2 = 0;
            while(sum2 < sum){
                sum2 += square[i][j];
                j++;
            }  
            if(sum2 != sum){
                return false;
            }
        }

        for(int i = 0; i<square.length; i++){
            j = 0;
            sum2 = 0;
            while(sum2 < sum){
                sum2 += square[j][i];
                j++;
            }  
            if(sum2 != sum){
                return false;
            }
        }

        //diagonal one
        
            j = 0;
            sum2 = 0;
            while(sum2 < sum){
                sum2 += square[j][j];
                j++;
            }  
            if(sum2 != sum){
                return false;
            }

        //diagonal two 
            j = 0;
            sum2 = 0;
            while(sum2 < sum){
                for(int i = square.length-1; i >= 0; i--){
                sum2 += square[i][j];
                }
                j++;
            }  
            if(sum2 != sum){
                return false;
            }
    



        
          return true;
    }


    /**
     * Problem 4
     * Returns a reference to an array storing the first n prime numbers.
     * The function argument specifies how many prime numbers to store;
     * a non positive argument results in returning null.
     * 
     * For example,
     *     java.util.Arrays.equals(firstPrimes(-1), null)
     *     java.util.Arrays.equals(firstPrimes(0), null)
     *     java.util.Arrays.equals(
     *         firstPrimes(8), new int[] {2, 3, 5, 7, 11, 13, 17, 19}
     *     )
     * 
     * @param N the number of prime numbers the array will store
     * @return a reference to an array storing the first N prime numbers;
     *         or null if N < 0
    */
    public static int[] firstPrimes(int N) {
        boolean isprime = true; 
        
        if(N <= 0){
        return null;
        }
        int[] arr = new int[N];

        if(N >= 1){
        arr[0] = 2;
        
        }
        if(N >= 2){
            arr[1] = 3;
            
        }
        if(N >= 3){
            int counter = 2; 
            for(int j = 5; ; j++){
                isprime = true; 
            if(counter >=N){
                return arr; 
            }
            
            for(int i = 2; i < j/2; i++){
            // System.out.println(j);
            // System.out.println(i);
            if(j % i == 0){isprime = false; break;}
        }

        if(isprime == true){
            arr[counter] = j;
            counter++; 
        }

            }
        }

            return arr; 
    }

}
