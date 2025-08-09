package org.DSA.Stack;


import java.util.*;

public class NextGreaterNodeInLL {
    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(9,7,6,7,6,9);

        ListNode head=new ListNode(nums.get(0));
        head.next=null;
        ListNode temp=head;

        int idx=1;

        while(idx<nums.size()){
            ListNode node=new ListNode(nums.get(idx));
            temp.next=node;
            temp=temp.next;
            idx++;
        }

        System.out.println(Arrays.toString(new Solution().nextLargerNodes(head)));
    }
}
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if(head==null || head.next==null) return new int[]{0};

        List<Integer> list=new ArrayList<>();

        while(head!=null){
            list.add(head.val);
            head=head.next;
        }

        Stack<Integer> stack=new Stack<>();//to store indices
        //usage of Monotonically Decreasing Stack

        int[] res=new int[list.size()];

        for(int i=0;i<list.size();i++){
            while(!stack.isEmpty() && list.get(stack.peek())<list.get(i)){
                int idx=stack.pop();
                res[idx]=list.get(i);
            }

            stack.push(i);
        }

        return res;
    }
}

/*Intuition:
------------
✅ Goal
For each node in the linked list, find the next node that has a greater value. If no such node exists, store 0.

🧠 Approach Explanation (Monotonic Stack)
Why a stack?
This is a classic Next Greater Element problem, and we solve it efficiently using a monotonic decreasing stack. Here’s how it works:

Convert the linked list to an ArrayList so we can access elements by index.

Use a stack to keep indices where we haven’t yet found the next greater node.

For each node value at index i:

While the stack is not empty and the current value is greater than the value at the index on top of the stack:

Pop that index from the stack.

The current value is the next greater node for that popped index.

After the loop, the values at any remaining indices in the stack don't have a greater node, so they remain 0.

👨‍💻 Code Walkthrough
java
Copy
Edit
List<Integer> list = new ArrayList<>();
while (head != null) {
    list.add(head.val);
    head = head.next;
}
Convert linked list to array for easy index access.

java
Copy
Edit
Stack<Integer> stack = new Stack<>();
int[] res = new int[list.size()];
Stack will store indices, not values.

res[] holds the final answer.

java
Copy
Edit
for (int i = 0; i < list.size(); i++) {
    while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
        int idx = stack.pop();
        res[idx] = list.get(i);
    }
    stack.push(i);
}
For each index i, pop indices from the stack where current value is greater.

Update those popped indices with the current value (next greater).

Push current index to the stack.
 */

