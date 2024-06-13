package Sequence;

public class Test0166 {
}

/*

代码

测试用例
测试用例
测试结果

169. 多数元素
简单
相关标签
相关企业
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。
*/

class Solution166_1 {
    public int majorityElement(int[] nums) {
        int result=0;
        int count=0;
        for (int num : nums) {
            if (count==0){
                result=num;
            }
            if (result!=num){
                count--;
            }else {
                count++;
            }
        }
        return result;
    }
}
