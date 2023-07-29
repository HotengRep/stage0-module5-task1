package com.epam.mjc.stage0;



/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
     String[] seasons =  {"winter", "spring", "summer", "autumn"};
     return  seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] returnArray = new int[length];
        for (int i = 0; i <length; i++)
        {
            returnArray[i] = i+1;
        }
        return  returnArray;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        return  sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] == number)
            {
                return  i;
            }
        }

        return  -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reverseArr = new String[arr.length];

        for (int i = arr.length-1; i >= 0; i--)
        {
            reverseArr[arr.length - i - 1] = arr[i];
        }

        return  reverseArr;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int lengthNewArray = 0;
        for(int i = 0; i<arr.length; i++)
        {
            if(arr[i] > 0){
                lengthNewArray++;
            }
        }
        int[] positiveArr = new int[lengthNewArray];
        lengthNewArray = 0;
        for(int i = 0; i <arr.length; i++)
        {
            if(lengthNewArray == positiveArr.length)
            {
                return  positiveArr;
            }

            if(arr[i] > 0){
                positiveArr[lengthNewArray] = arr[i];
                lengthNewArray++;

            }

        }

        return positiveArr;

    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        int lowestNumber = 0;
        int index = 0;
        int[] temp;
        for(int i = 0 ; i < arr.length ; i ++)
        {
           arr[i] = sortArray(arr[i]);
        }

        for(int i = 0; i < arr.length; i++)
        {
            lowestNumber = arr[i].length;
            index = i;
            for (int j = i; j <arr.length ; j ++)
            {
                if(lowestNumber > arr[j].length )
                {
                    lowestNumber = arr[j].length;
                    index = j;
                }
            }
            if(index != i )
            {
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }

        }
        return  arr;
    }

    public  int[] sortArray(int[] arr)
    {

        if(arr.length != 1 )
        {
            int[] firstPartArray = new int[arr.length/2];
            int[] secondPartArray = new int[arr.length - firstPartArray.length];

            System.arraycopy(arr, 0, firstPartArray,0,firstPartArray.length);
            System.arraycopy(arr, firstPartArray.length, secondPartArray,0 ,secondPartArray.length);

            firstPartArray = sortArray(firstPartArray);
            secondPartArray = sortArray(secondPartArray);


            int countFirst = 0;
            int countSecond = 0;

            while (countFirst < firstPartArray.length && countSecond < secondPartArray.length)
            {
                if(firstPartArray[countFirst] > secondPartArray[countSecond])
                {
                    arr[countFirst+countSecond] = secondPartArray[countSecond];
                    countSecond++;
                }else {
                    arr[countFirst+countSecond] = firstPartArray[countFirst];
                    countFirst++;
                }
            }

            if (countFirst < firstPartArray.length)
            {
                arr[countFirst+countSecond] = firstPartArray[countFirst];
                countFirst++;
            }

            if (countSecond < secondPartArray.length)
            {
                arr[countFirst+countSecond] = secondPartArray[countSecond];
                countSecond++;
            }

            return arr;

        }
        return arr;
    }
}
