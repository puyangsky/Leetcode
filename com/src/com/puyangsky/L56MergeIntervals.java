package com.puyangsky;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Author: puyangsky
 * Date:   17/6/15
 * Method:
 */
public class L56MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start) ;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            }else {
                ans.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }