public class Alternate_Solution_Find_Numbers_Even_No_Digits {
    public int findNumbers(int[] nums) {
        /*
         * Given: 1 <= nums[i] <= 10^5 --> maximum value of nums[i] is 100000 which has
         * 6 digits.
         * So possibilities are 2-digit, 4-digit numbers and 100000
         * 
         * Logic: We use a simple if else condition to filter the numbers that have even
         * number of digits
         */
        int count = 0;
        
        for (int num : nums) {
            if ((num > 9 && num <= 99) || (num > 999 && num <= 9999) || num == 100000)
                count++;
        }

        return count;
    }
}
