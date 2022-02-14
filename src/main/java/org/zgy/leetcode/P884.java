package org.zgy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author ：z
 * @date ：Created in 2022/1/30 下午2:03
 * @description：
 */
public class P884 {

    public static void main(String[] args) {
        String s1 = "a a";
        String s2 = "b";
        String[] strings = new P884().uncommonFromSentences(s1, s2);
        Arrays.stream(strings).forEach(s -> System.out.println(s));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> multi = new HashMap<>();
        HashMap<String, Integer> single = new HashMap<>();
        String[] sa1 = s1.split(" ");
        String[] sa2 = s2.split(" ");
        for (String s : sa1) {
            if(multi.get(s)==null&&single.get(s)==null){
                single.put(s,1);
            }else{
                if(single.get(s)!=null){
                    single.remove(s);
                }
                if(multi.get(s)==null){
                    multi.put(s,1);
                }
            }
        }
        for (String s : sa2) {
            if(multi.get(s)==null&&single.get(s)==null){
                single.put(s,1);
            }else{
                if(single.get(s)!=null){
                    single.remove(s);
                }
                if(multi.get(s)==null){
                    multi.put(s,1);
                }
            }
        }
        String[] res = new String[single.size()];
        final int[] i = {0};
        single.forEach((s, integer) -> {
            res[i[0]]=s;
            i[0]++;
        });
        return res;
    }
}
