/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 长字符串longString为bnjduaahbciwfbc
 * alphabet为abc
 * 要求返回longString中包含alphabet的最短子串：ahbc
 */

import java.util.*;


public class LeetCode_76 {
    public static String solution(String longString, String alphabet) {
       Map<Character, Integer> map = new HashMap<>();
       for (char c : alphabet.toCharArray()){
           map.put(c , map.containsKey(c) ? map.get(c) + 1 : 1);
       }
       int start = 0;
       int end = 0;
       int min = Integer.MAX_VALUE;
       int left = 0;
       int right = 0;
       int count = alphabet.length();
       for (; right < longString.length(); right++){
           if (map.containsKey(longString.charAt(right))){
                   map.put(longString.charAt(right), map.get(longString.charAt(right)) - 1);
                   //如果下面用map.get(longString.charAt(right)) < 0
               //则说明map.get(longString.charAt(right))原本就等于0或者小于0
               //说明原本该字母出现的次数已经够了，则不会影响判断
                   if (map.get(longString.charAt(right)) >= 0){
                       count--;
                   }
           }
           while (count == 0){
               if (right - left + 1 < min){
                   min = right - left + 1;
                   end = right;
                   start = left;
               }
               char temp = longString.charAt(left);
               if (map.containsKey(temp)){
                   map.put(temp, map.get(temp) + 1);
                   if (map.get(temp) > 0){
                       count++;
                   }
               }
               left++;
           }
       }
       return min == Integer.MAX_VALUE ? "" : longString.substring(start, end +1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String longString = in.next();
        String alphabet = in.next();
        System.out.println(solution(longString, alphabet));
    }
}