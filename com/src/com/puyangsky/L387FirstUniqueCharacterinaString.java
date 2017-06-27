package com.puyangsky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:      puyangsky
 * Date:        17/6/27 下午2:10
 * Method:      HashMap
 * Difficulty:  Easy
 */
public class L387FirstUniqueCharacterinaString {
    public static int firstUniqChar(String s) {
        if (null == s || s.length() == 0) return -1;

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i=0;i<s.length();i++) {
            String ss = s.substring(i, i+1);
            map.put(ss, (map.get(ss) == null ? 0 : 1) + 1);
            list.add(ss);
        }

        for (int i = 0;i<list.size(); i++) {
            if (map.get(list.get(i)) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "dddccdbba";
        System.out.println(firstUniqChar(s));
    }
}
