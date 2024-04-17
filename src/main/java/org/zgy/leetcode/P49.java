package org.zgy.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author z
 * @create 2024/4/8 15:44
 * @Des 字母异位词分组
 */
public class P49 {

    public static void main(String[] args) {
        List<List<String>> lists = new P49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> wordMap = new HashMap<>();
        BigInteger strAsiMul;
        BigInteger strAsiSum;
        String key;
        ArrayList<List<String>> results = new ArrayList<>();
        for (String str : strs) {
            strAsiMul=new BigInteger("1");
            strAsiSum=new BigInteger("1");
            for (char c : str.toCharArray()) {
                strAsiMul=strAsiMul.multiply(BigInteger.valueOf(c));
                strAsiSum=strAsiSum.add(BigInteger.valueOf(c));
            }
            key=strAsiMul+"-"+strAsiSum;
            List orDefault = wordMap.getOrDefault(key, new ArrayList());
            orDefault.add(str);
            results.add(orDefault);
        }
        return results;
    }
}
