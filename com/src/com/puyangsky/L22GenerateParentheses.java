package com.puyangsky;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: puyangsky
 * Date: 17/4/27
 * 方法：递归、回溯
 */
public class L22GenerateParentheses {

    private static List<String> list = new ArrayList<>();

    public static void dfs(List<String> list, String parenthesis, int left, int right, int count) {
        if (parenthesis.length() == count * 2) {
            list.add(parenthesis);
            return;
        }
        if (left < count)
            dfs(list, parenthesis + "(", left + 1, right, count);

        if (right < left)
            dfs(list, parenthesis + ")", left, right + 1, count);
    }

    public static List<String> generateParenthesis(int n) {
        dfs(list, "", 0, 0, n);
        return list;
    }


    public static void main(String[] args) {
        generateParenthesis(3);
        for (String l : list) {
            System.out.println(l);
        }
    }
}
