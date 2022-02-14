package org.zgy.leetcode;

/**
 * @author ：z
 * @date ：Created in 2022/1/30 下午2:34
 * @description：
 */
public class P6 {

    public static void main(String[] args) {
        String s = "ABC";
        int numRows = 1;
        String convert = new P6().convert(s, numRows);
        System.out.println(convert);
    }

    public String convert(String s, int numRows) {
        //第一列：numRows,第二列：numRows/2,第三列：numRows
        char[] chars = s.toCharArray();
        String [] strs = new String[numRows];
        int si = 0;
        boolean isAdd = true;
        for (int i = 0; i < chars.length; i++) {
            if(isAdd){
                strs[si]=(strs[si]==null?"":strs[si])+ chars[i];
                si++;
            }else{
                strs[--si]+=String.valueOf(chars[i]);
            }
            if(si==numRows){
                isAdd=false;
                if(si>1){
                    si--;
                }
            }else if(si==0){
                isAdd=true;
                if(si+1<numRows){
                    si++;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(str==null?"":str);
        }
        return sb.toString();
    }
}
