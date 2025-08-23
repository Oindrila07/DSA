package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();

        for (int hour = 0; hour <= 11; hour++) {
            for (int minute = 0; minute <= 59; minute++) {
                String res = "";

                int bitCount = Integer.bitCount(hour) + Integer.bitCount(minute);

                if (bitCount == turnedOn) {
                    res += hour + ":" + (minute < 10 ? "0" + minute : minute);
                    list.add(res);
                }
            }
        }

        return list;
    }
}

class BinaryWatchMain{
    public static void main(String[] args) {
        System.out.println(new BinaryWatch().readBinaryWatch(8));
    }
}

/*
Problem — what the code is solving:
-----------------------------------
This is the Binary Watch problem. A binary watch has 10 LEDs: 4 LEDs represent the hour (values 8,4,2,1 → valid hours 0–11) and 6 LEDs represent the minutes (values 32,16,8,4,2,1 → valid minutes 0–59).
Given turnedOn (the number of LEDs that are ON), return all possible times the watch could represent that have exactly turnedOn LEDs lit. Times must be formatted "H:MM" (minutes always two digits).

High-level approach / intuition:
--------------------------------
There are only 12 × 60 = 720 possible times (hour 0–11, minute 0–59). That’s a tiny, fixed search space,
so the simplest and most reliable approach is brute force: enumerate every hour/minute pair, count how many 1-bits are in
the binary representation of hour and minute, and if the sum equals turnedOn, format and add the time to the result.
Counting set bits is done with Java’s Integer.bitCount(int), which is fast and concise.

Examples:
---------
turnedOn = 0 → only "0:00" (no LEDs lit).

turnedOn = 1 → times where exactly one LED is on:
Hours with 1 bit: 1,2,4,8 → times 1:00, 2:00, 4:00, 8:00
Minutes with 1 bit: 1,2,4,8,16,32 → times 0:01, 0:02, 0:04, 0:08, 0:16, 0:32
Combined set (order depends on iteration):
["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]

turnedOn = 9 → no results. Although there are 10 LEDs in total (4+6), not every LED pattern maps to a valid
hour/minute (hours limited to 0–11, minutes to 0–59). Practically the maximum possible number of set bits in a valid time is
8 (e.g., hour=11 has 3 ones, many minutes have up to 5 ones), so requests >8 will return an empty list.

Complexity:
-----------
Time: O(12 × 60) = O(720) iterations — a constant, tiny amount. Each iteration does a constant amount of work (popcount + string formatting). So practically constant time, extremely fast.
S0, TC = O(1), SC = O(1)
 */