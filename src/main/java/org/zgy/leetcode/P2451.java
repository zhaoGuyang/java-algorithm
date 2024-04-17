package org.zgy.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author z
 * @create 2023/5/25 14:00
 */
public class P2451 {

  public static void main(String[] args) {
    String[] words = {"aaa", "bob", "ccc", "ddd"};
    System.out.println(new P2451().oddString(words));
  }

  static HashMap<Character, Integer> wordMap = new HashMap<>(26);

  static {
    wordMap.put('a', 0);
    wordMap.put('b', 1);
    wordMap.put('c', 2);
    wordMap.put('d', 3);
    wordMap.put('e', 4);
    wordMap.put('f', 5);
    wordMap.put('g', 6);
    wordMap.put('h', 7);
    wordMap.put('i', 8);
    wordMap.put('j', 9);
    wordMap.put('k', 10);
    wordMap.put('l', 11);
    wordMap.put('m', 12);
    wordMap.put('n', 13);
    wordMap.put('o', 14);
    wordMap.put('p', 15);
    wordMap.put('q', 16);
    wordMap.put('r', 17);
    wordMap.put('s', 18);
    wordMap.put('t', 19);
    wordMap.put('u', 20);
    wordMap.put('v', 21);
    wordMap.put('w', 22);
    wordMap.put('x', 23);
    wordMap.put('y', 24);
    wordMap.put('z', 25);
  }

  public String oddString(String[] words) {
    int[] a = null, tmp;
    String aWord = null, bWord = null;
    int aCount = 0, bCount = 0;
    for (String word : words) {
      if (a == null) {
        a = convertStr2Num(word);
        aWord = word;
        aCount++;
        continue;
      }
      tmp = convertStr2Num(word);
      if (!Arrays.equals(a, tmp)) {
        if (bWord == null) {
          bWord = word;
        }
        bCount++;
      } else {
        aCount++;
      }

      if (aCount > 0 && bCount > 0) {
        if (aCount > bCount) {
          return bWord;
        } else if (aCount < bCount) {
          return aWord;
        }
      }
    }
    return null;
  }

  int[] convertStr2Num(String word) {
    int[] a = new int[word.length() - 1];
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (i + 1 < chars.length) {
        a[i] = wordMap.get(chars[i + 1]) - wordMap.get(chars[i]);
      }
    }
    return a;
  }
}
