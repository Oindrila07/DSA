package org.DSA.Stack;

import java.util.Stack;

class BrowserHistory {
    String homepage;
    private Stack<String> stack;
    private Stack<String> visited;

    public BrowserHistory(String homepage) {
        this.homepage=homepage;
        this.stack=new Stack<>();
        this.visited=new Stack<>();
        stack.push(homepage);
    }

    public void visit(String url) {
        stack.push(url);
        visited.clear();
    }

    public String back(int steps) {
        while(steps>0 && stack.peek()!=homepage){
            String url=stack.pop();
            visited.push(url);
            steps--;
        }

        return stack.peek();
    }

    public String forward(int steps) {
        while(steps>0){
            if(visited.isEmpty())break;

            String url=visited.pop();
            stack.push(url);
            steps--;
        }

        if(!stack.isEmpty())
            return stack.peek();

        return null;
    }
}

class BrosweHistMain {
    public static void main(String[] args) {
        BrowserHistory browserHistory=new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }
}