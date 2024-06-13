package Sequence;

public class Test0074 {
    public static void main(String[] args) {
        new Solution0074_2().searchMatrix(new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        },13);
    }
}

class Solution0074_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //寻找所在数组
        int[] nums = matrix[0];
        int l=0,r=m-1,mid=l;
        while (l<=r){
            if(matrix[l][0]>target||matrix[r][n-1]<target) return false;

            mid = (l + r) / 2;
            nums=matrix[mid];

            if (target<nums[0]){
                r = mid-1;
            } else if (target > nums[n - 1]) {
                l=mid+1;
            }else {
                break;
            }
        }

        l=0;
        r=n-1;
        mid=l;
        while (l<=r){
            mid=(l+r)/2;
            int num = nums[mid];
            if (num>target){
                r=mid-1;
            } else if (num < target) {
                l=mid+1;
            }else {
                return true;
            }
        }

        return false;
    }
}

class Solution0074_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length1 = matrix.length;
        int length2 = matrix[0].length;

        int l=0,r=length1-1,m=l;

        while (l<=r){
            if (target>matrix[r][length2-1]||target<matrix[l][0]) return false;
            m = (l + r) >> 1;

            if (target>matrix[m][length2-1])l=m+1;
            else if (target<matrix[m][0]) r=m-1;
            else if (target<matrix[m][length2-1]&&target>matrix[m][0]) break;
            else return true;

        }

        int[] matrix2 = matrix[m];
        l=0;
        r=length2-1;
        while (l<=r){
            if (matrix2[r]<target||matrix2[l]>target) return false;
            m=(l+r)>>1;
            if (matrix2[m]>target) r=m-1;
            else if (matrix2[m]<target) l=m+1;
            else return true;
        }

        return false;
    }
}