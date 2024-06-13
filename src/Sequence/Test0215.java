package Sequence;

public class Test0215 {
}

class Solution0215_1 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize=nums.length;
        buildMaxHeap(nums,heapSize);
        for (int i = heapSize-1; i > nums.length-k; i--) {
            swap(nums,0,i);
            heapSize--;
            maxHeapfy(nums,0,heapSize);
        }

        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapfy(nums, i, heapSize);
        }

    }

    public void maxHeapfy(int[] nums, int order,int heapSize){
        int l=2*order+1,r=2*order+2,largest=order;
        if (r<heapSize&&nums[r]>nums[largest]) {
            largest=r;
        }

        if (l<heapSize&&nums[l]>nums[largest]) {
            largest=l;
        }

        if (order!=largest) {
            swap(nums,order,largest);
            maxHeapfy(nums,largest,heapSize);
        }
    }

    public void swap(int[] nums, int oldI,int newI) {
        int temp = nums[oldI];
        nums[oldI] = nums[newI];
        nums[newI] = temp;
    }
}

class Solution0215_2 {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        buildMaxHeap(nums,length);

        for (int i = 1; i < k; i++) {
            swap(nums,0,length-i);
            traverse(nums,0,length-i);
        }

        return nums[0];
    }

    public void buildMaxHeap(int[] nums,int length) {

        for (int i=length/2;i>=0;i--) {
            traverse(nums,i,length);
        }
    }

    public void traverse(int[] nums, int index,int length) {
        int l = index * 2 + 1,r = index * 2 + 2,big=index;

        if (l<length&&nums[l]>nums[big]) big=l;
        if (r<length&&nums[r]>nums[big]) big=r;

        if (big!=index){
            swap(nums,big,index);
            traverse(nums,big,length);
        }
    }

    private void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}