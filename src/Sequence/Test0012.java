package Sequence;

import java.util.HashMap;

public class Test0012 {
}

/*
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给你一个整数，将其转为罗马数字。



示例 1:

输入: num = 3
输出: "III"
示例 2:

输入: num = 4
输出: "IV"
示例 3:

输入: num = 9
输出: "IX"
示例 4:

输入: num = 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
示例 5:

输入: num = 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.


提示：

1 <= num <= 3999
*/

class Solution0012_1 {
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"I");
        map.put(2,"X");
        map.put(3,"C");
        map.put(4,"M");
        map.put(5,"V");
        map.put(6,"L");
        map.put(7,"D");

        char[] chars = (num + "").toCharArray();
        int len=chars.length;

        for (char c : chars) {
            c-=48;
            if (c==9){
                stringBuilder.append(map.get(len));
                stringBuilder.append(map.get(len+1));
            } else if (c>=5){
                stringBuilder.append(map.get(len+4));
                c-=5;

                if (c==4){
                    stringBuilder.append(map.get(len));
                    stringBuilder.append(map.get(len+4));
                }else {
                    for ( ;c>0 ; c--) {
                        stringBuilder.append(map.get(len));
                    }
                }
            } else if (c==4){
                stringBuilder.append(map.get(len));
                stringBuilder.append(map.get(len+4));
            }else {
                for ( ;c>0 ; c--) {
                    stringBuilder.append(map.get(len));
                }
            }
            len--;
        }
        return stringBuilder.toString();
    }
}

class Solution0012_2 {
    int[] val = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length && x > 0; i++) {
            int cv = val[i];
            String cs = str[i];
            while (x >= cv) {
                sb.append(cs);
                x -= cv;
            }
        }
        return sb.toString();
    }
}

class Solution0012_second {
    int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int x) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < val.length&&x>0; i++) {
            int n=val[i];
            String s=str[i];

            while (x>=n){
                x-=n;
                builder.append(s);
            }
        }

        return builder.toString();
    }
}
