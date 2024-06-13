package ShuanFa_easy;

public class Practice01 {
    public static void main(String[] args) {
        int[] list={-1,0,3,5,9,12};
        System.out.println(search(list,2));
    }
    public static int search(int[] nums, int target) {
        int maxIndex=nums.length-1;
        int minIndex=0;
        if (target>nums[maxIndex]||target<nums[minIndex]) {
            return -1;
        }
        while (maxIndex>minIndex) {
            int midIndex=(maxIndex-minIndex)/2+minIndex;
            if (target>nums[midIndex]) {
                minIndex=midIndex;
            } else if (target<nums[midIndex]) {
                maxIndex=midIndex-1;   
            } else {
                return midIndex+1;
            }
        }
        return -1;
    }
}
