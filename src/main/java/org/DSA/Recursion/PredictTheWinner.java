package org.DSA.Recursion;

public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        return returnDiff(nums,0,nums.length-1)>=0;
    }

    private int returnDiff(int[] nums, int left, int right){
        if(left>right)return 0;

        int leftScore=nums[left]-returnDiff(nums,left+1,right);
        int rightScore=nums[right]-returnDiff(nums,left,right-1);

        return Math.max(leftScore,rightScore);
    }
}

class PredictTheWinnerMain{
    public static void main(String[] args) {
        System.out.println(new PredictTheWinner().predictTheWinner(new int[]{1,5,2}));
    }
}

/*
In the recursive solution, we define a function like:

int score(int[] nums, int i, int j)

that returns the maximum score difference (current player − other player) from the subarray nums[i..j].

🎯 Key Intuition:
-----------------
At each step:
=> The current player picks either left (nums[i]) or right (nums[j]).
=> Then it’s the opponent’s turn on the remaining subarray.
=> Since the opponent also plays optimally, whatever value they return will represent their advantage over me.
=> To reflect my net advantage, I subtract their result.

🔎 Why subtraction?:
--------------------
Suppose I pick nums[i]:
I get nums[i] immediately.
Now it’s the opponent’s turn with subarray [i+1..j].
The recursive call score(i+1, j) gives the opponent’s net advantage from that subarray.

👉 My net advantage is:

my immediate gain − opponent’s advantage
my immediate gain−opponent’s advantage

So, choice1=nums[i]−score(i+1,j)

Similarly, if I pick nums[j]:
choice2=nums[j]−score(i,j−1)

Then I take the max of the two choices.

🌰 Example:
nums = [1, 5, 2]

If I (Player 1) pick 1:
Opponent plays optimally on [5,2].
Suppose their net advantage is X.
My net = 1 - X.

If I pick 2:
Opponent plays optimally on [1,5].
Suppose their net advantage is Y.
My net = 2 - Y.

So the subtraction is basically:
“I got my number, but I need to cancel out how much advantage the opponent can force against me in the next step.”
 */

/*
🧠 Intuition:
--------------
This is a two-player zero-sum game:
My gain is the opponent’s loss.
If I want to win, I don’t just maximize what I take — I also minimize what the opponent can do later.

👉 That’s why subtraction comes in:
It models the tug-of-war between me and my opponent.

🏗 Approach (Recursive Game Theory)
Step 1: Define the State

We define a recursive function:

score(i, j) = maximum net score (current player − opponent)
              that the current player can achieve from nums[i..j].


If i == j: only one number left, so score(i,j) = nums[i].

Step 2: Transition (Choices)

At each turn, the current player has two choices:

Take the left element (nums[i]):

Gain nums[i].

Opponent then plays on [i+1..j] optimally, giving them score(i+1, j).

Since that’s the opponent’s advantage, subtract it: choice1=nums[i]−score(i+1,j)

Take the right element (nums[j]):

Gain nums[j].

Opponent plays on [i..j-1], gaining score(i, j-1).

Subtract it: choice2=nums[j]−score(i,j−1)

Step 3: Pick the Best

The current player plays optimally, so: score(i,j)=max(choice1,choice2)
Step 4: Final Answer

If score(0, n-1) >= 0, then Player 1 can guarantee at least a tie.

Otherwise, Player 2 wins.

🌰 Example Walkthrough: nums = [1, 5, 2]
Call: score(0,2)

Two choices:

Pick 1:
1 - score(1,2)
→ Need score(1,2)

score(1,2) = max(
5 - score(2,2),
2 - score(1,1)
)

score(2,2) = 2

score(1,1) = 5

So:

choice = 5 - 2 = 3

choice = 2 - 5 = -3
→ score(1,2) = 3

Back to root: 1 - 3 = -2

Pick 2:
2 - score(0,1)
→ Need score(0,1)

score(0,1) = max(
1 - score(1,1),
5 - score(0,0)
)

score(1,1) = 5 → 1 - 5 = -4

score(0,0) = 1 → 5 - 1 = 4

So: score(0,1) = 4

Back to root: 2 - 4 = -2

Final:
score(0,2) = max(-2, -2) = -2
❌ Negative → Player 1 cannot win.
 */