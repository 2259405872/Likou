package Sequence;

import java.util.HashSet;
import java.util.Set;

/*
给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

        考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：

        更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
        返回 k 。
        示例 1：

        输入：nums = [1,1,2]
        输出：2, nums = [1,2,_]
        解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
        示例 2：

        输入：nums = [0,0,1,1,1,2,2,3,3,4]
        输出：5, nums = [0,1,2,3,4]
        解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。*/
class Solution0026_1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int a=1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]!=nums[i+1]){
                nums[a]=nums[i+1];
                a++;
            }
        }
        return a;
    }
}

class Solution0026_2 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length<=1) return length;

        int pre =nums[0],count=1;
        for (int i = 1; i < length; i++) {
            if (nums[i]==pre) continue;

            nums[count++] = nums[i];
            pre = nums[i];
        }

        return count;
    }
}