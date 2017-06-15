package com.puyangsky;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: puyangsky
 * Date:   17/6/15
 * Method:
 */
public class L216CombinationSumIII {

    public static void dfs(int count, int cur, int sum, List<Integer> tmp, List<List<Integer>> ans, int k, int n) {
        if (count == k && sum == n) {
            List<Integer> list = new ArrayList<>(tmp);
            ans.add(list);
            return;
        }else if (count == k) {
            return;
        }else {
            for (int i=cur+1;i<=9;i++) {
                tmp.add(i);
                dfs(count+1, i, sum + i, tmp, ans, k, n);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, 0, 0, new ArrayList<Integer>(), ans, k, n);
        return ans;
    }


    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum3(3, 7);
        for (List<Integer> list : ans) {
            for (int i : list) {
                System.out.printf(i + "\t");
            }
        }
    }
}
