package org.DSA.Recursion;

import java.util.List;
import java.util.ArrayList;

public class RestoreIPAdresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() > 12)
            return list;
        generate(list, new StringBuilder(), 0, s, 0);
        return list;
    }

    private void generate(List<String> list, StringBuilder res, int index, String s, int countDots) {
        if (index > s.length() || countDots > 4)
            return;
        if (index == s.length() && countDots == 4) {
            int len = res.length();
            res.setLength(len - 1);
            list.add(res.toString());
            return;
        }

        int len = res.length();

        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
            String segment = s.substring(index, i + 1);
            if (!isValid(segment))
                continue;
            res.append(segment).append(".");
            generate(list, res, i + 1, s, countDots + 1);
            res.setLength(len);
        }
    }

    private boolean isValid(String track) {
        if (track.isEmpty() || track.length() > 3 || (track.length() > 1 && track.charAt(0) == '0'))
            return false;
        return Integer.parseInt(track) >= 0 && Integer.parseInt(track) <= 255;
    }
}

class IPAdressMain{
    public static void main(String[] args) {
        System.out.println(new RestoreIPAdresses().restoreIpAddresses("25525511135"));
    }
}
