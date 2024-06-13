package Sequence;

public class Test0042 {
    public static void main(String[] args) {
        new Solution0042_1().trap(new int[]{9,8,2,6});
    }
}

class Solution0042_1 {
    public int trap(int[] height) {
        int length = height.length;
        if (length<=2) return 0;

        int ans=0,l=0,r=length-1;
        int lMax=height[l],rMax=height[r];

        while (l<r){
            if (height[l]>=height[r]){
                rMax=Math.max(height[r],rMax);
                ans+=rMax-height[r];
                r--;
            }else {
                lMax=Math.max(height[l],lMax);
                ans+=lMax-height[l];
                l++;
            }
        }

        return ans;
    }

}