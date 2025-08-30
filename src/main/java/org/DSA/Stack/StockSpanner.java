package org.DSA.Stack;

import java.util.Stack;

class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        stack=new Stack<>();
    }

    public int next(int price) {
        int span=1;

        while(!stack.isEmpty() && stack.peek()[0]<=price){
            span+=stack.pop()[1];
        }

        stack.push(new int[]{price,span});

        return span;
    }
}

class StockSpannerMain {
    public static void main(String[] args) {
        StockSpanner stock=new StockSpanner();

        System.out.println(stock.next(29));//1
        System.out.println(stock.next(91));//2
        System.out.println(stock.next(62));//1
        System.out.println(stock.next(76));//2
        System.out.println(stock.next(51));//1
    }
}

/*
Intuition:
----------
For each price, we need to find how many consecutive days (including today) the stock price was less than or equal to today's price.
A monotonic decreasing stack can store previous prices along with their spans to efficiently compute the result.

Approach:
---------
1️⃣ Maintain a stack where each element is [price, span].
2️⃣ For each new price:
    Start with span = 1.
    While the stack's top price ≤ current price, pop it and add its span to the current span.
3️⃣ Push [price, span] into the stack.
4️⃣ Return span.


Complexity:
-----------
Time complexity: O(1) amortized per call – Each price is pushed and popped at most once.
Space complexity: O(n) – Stack stores pairs of price and span.
 */