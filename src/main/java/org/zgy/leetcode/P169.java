package org.zgy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author ：z
 * @date ：Created in 2022/2/1 上午10:43
 * @description：
 */
public class P169 {

    public static void main(String[] args) {
        int [] nums = new int[]{12,52,12,70,12,61,12,12,50,72,82,12,11,25,28,43,40,12,12,53,12,12,98,12,12,92,81,2,12,15,40,12,12,9,12,31,12,12,12,12,77,12,12,50,12,12,12,93,41,92,12,12,12,12,12,12,12,12,12,37,48,14,12,70,82,12,80,12,12,12,12,56,30,12,8,12,50,12,20,12,21,97,12,42,12,10,12,38,73,15,9,11,79,12,12,28,51,12,15,12};
        System.out.println(new P169().majorityElement2(nums));
    }

    public int majorityElement(int[] nums){
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            if (!numList.contains(num)) {
                numList.add(num);
            }
            if(map.get(num)==null){
                map.put(num,1);
            }
            if(numList.getFirst()==num){
                map.put(numList.getFirst(),map.get(numList.getFirst())+1);
            }else{
                map.put(numList.getFirst(),map.get(numList.getFirst())-1);
                if(map.get(numList.getFirst())==0){
                    numList.removeFirst();
                }
            }
        }
        return numList.getFirst();
    }
}
