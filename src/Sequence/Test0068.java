package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0068 {
}


class Solution_0068_1 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int i;
        int temp = 0;
        for (i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            if (count+ len <= maxWidth) {
                count+=len+1;
            }else {
                int avg= 0;
                int yu= 0;
                if (i-temp-1>0) {
                    avg = (maxWidth-count+(i-temp))/(i-temp-1);
                    yu = (maxWidth-count+(i-temp))%(i-temp-1);
                }
                int j;
                count=0;
                for (j = 0; j <yu;j++){
                    stringBuilder.append(words[temp+j]);
                    stringBuilder.append(" ".repeat(avg+1));
                    count+=words[temp+j].length()+avg+1;
                }
                for (; j < (i-temp-1); j++){
                    stringBuilder.append(words[temp+j]);
                    stringBuilder.append(" ".repeat(avg));
                    count+=words[temp+j].length()+avg;
                }
                stringBuilder.append(words[temp+j]);
                stringBuilder.append(" ".repeat(maxWidth-count-words[temp+j].length()));
                temp=i;
                result.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                count=word.length()+1;
            }
        }

        int j;
        count=0;
        for (j = 0; j <i-temp-1; j++) {
            stringBuilder.append(words[temp+j]);
            stringBuilder.append(" ");
            count+=words[temp+j].length()+1;
        }
        stringBuilder.append(words[temp+j]);
        stringBuilder.append(" ".repeat(maxWidth-count-words[temp+j].length()));
        result.add(stringBuilder.toString());
        return result;
    }
}
