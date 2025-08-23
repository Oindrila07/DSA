package org.DSA.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < tickets.length; i++) {
            queue.offer(i);//storing indices
        }

        int position = 0, time = 0;

        while (true) {
            if (tickets[position] == 0 && position == k)
                break;

            position = queue.poll();
            tickets[position]--;
            if (tickets[position] > 0) {
                queue.offer(position);
            }

            time++;
        }

        return time;
    }
}

class TimeNeededMain{
    public static void main(String[] args) {
        int[] tickets={5,1,1,1};
        int k=0;

        System.out.println(new TimeNeededToBuyTickets().timeRequiredToBuy(tickets,k));
    }
}
