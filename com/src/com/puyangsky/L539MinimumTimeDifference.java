package com.puyangsky;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Author: puyangsky
 * Date:   17/6/15
 * Method:
 */
public class L539MinimumTimeDifference {
    static class Time{
        int minute;
        int hour;

        public Time(int minute, int hour) {
            this.minute = minute;
            this.hour = hour;
        }
    }

    public static int minus(Time t1, Time t2) {
        return Math.abs((t1.hour - t2.hour)*60 + t1.minute - t2.minute);
    }

    public static int findMinDifference(List<String> timePoints) {
        List<Time> times = new ArrayList<>();
        for (String s : timePoints) {
            String[] ss = s.split(":");
            times.add(new Time(Integer.valueOf(ss[1]), Integer.valueOf(ss[0])));
        }

        times.sort(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if (o1.hour == o2.hour) {
                    return o1.minute - o2.minute;
                }
                return o1.hour - o2.hour;
            }
        });


        int min = minus(times.get(0), times.get(1));

        for(int i=1;i<times.size();i++) {
            if (min > minus(times.get(i), times.get(i-1))) {
                min = minus(times.get(i), times.get(i-1));
            }
        }

        int corner = 1440 - minus(times.get(0), times.get(times.size()-1));
        min = Math.min(min, corner);
        return min;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("00:00");
        list.add("00:00");
        list.add("23:59");
        System.out.println(findMinDifference(list));
    }
}
