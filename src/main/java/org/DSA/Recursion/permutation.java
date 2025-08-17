package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutation {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list=new ArrayList<>();

        generate(list, new ArrayList<>(), 0, nums, new boolean[nums.length]);

        return list;
    }

    private void generate(List<List<Integer>> list, List<Integer> res, int index, int[] nums, boolean[] visited){
        if(index==nums.length){
            list.add(new ArrayList<>(res));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1])continue;
            if(!visited[i]){
                res.add(nums[i]);
                visited[i]=true;
                generate(list, res, index+1, nums, visited);
                visited[i]=false;

                if(!res.isEmpty())
                    res.remove(res.size()-1);
            }
        }
    }
}

class generatePermsMain{
    public static void main(String[] args) {
        List<List<Integer>> list=new permutation().permuteUnique(new int[]{1,1,2});

        System.out.println(list.toString());
    }
}

/*
Take [1,1,2].
Naively, the backtracking tree is:

Pick 1 → Pick 1 → Pick 2 → [1,1,2]
Pick 1 → Pick 2 → Pick 1 → [1,2,1]
Pick 1 (second one first!) → Pick 1 → Pick 2 → [1,1,2] (duplicate!)
...


⚠️ The problem: identical numbers create identical branches.
If we don’t do anything, we get duplicates like [1,1,2] multiple times.


Intuition for avoiding duplicates:
----------------------------------
👉 Idea: If two numbers are the same, they should not be treated as “different choices” in the same stage of recursion.
Otherwise, we’ll create identical paths.

How do we enforce that?

=> Sort the array first → [1,1,2]
=> Now duplicates sit next to each other.
=> When we’re deciding whether to use nums[i], we check:
=> “Am I using this duplicate before its earlier copy has been placed?”
=> If yes → skip, because that would create duplicate paths.

The duplicate skipping rule:
----------------------------

The famous condition:
if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

Meaning in plain English: If this number is the same as the previous one
AND the previous one has not yet been used in this path
Then skip it (don’t allow the later duplicate to be picked first).

⚡ Intuition: Always use duplicates in left-to-right order.
This avoids starting a new branch with the second 1 while the first 1 is still free.

Example [1,1,2]:
At the root, don’t allow picking the second 1 first → ensures [1,1,2] is generated only once.

Why sorting is necessary:
--------------------------
Imagine [2,1,1] (unsorted).
Without sorting, duplicates are scattered and you can’t detect them easily.
By sorting → [1,1,2], duplicates are adjacent → easy to check nums[i] == nums[i-1].

So sorting + skipping rule together = uniqueness.

🔹 Approach (Step-by-Step):
---------------------------
1) Sort the array so duplicates are adjacent.
Example: [1,1,2]

2) Backtrack with:
A path (current permutation being built)
A visited[] array to mark which indices are already used

3) At each step, loop over indices:
If visited[i] → skip (already used).
If nums[i] == nums[i-1] && !visited[i-1] → skip (duplicate handling).
Else:
Add nums[i] to path, mark visited.

4) Recurse deeper.
Backtrack (remove from path, unmark visited).

5) Stop when path length == nums.length → add it to results.

🔹 What this achieves:
----------------------
Ensures all permutations are generated (since every number eventually gets picked).
Ensures no duplicates (since we never allow “jumping ahead” with a duplicate).


Example Walkthrough:
--------------------
nums = [1,1,2]
visited = [false,false,false]

[]
├── 1(index0)
│   ├── 1(index1)   <-- allowed because index0 already used
│   │   └── 2 → [1,1,2]
│   └── 2
│       └── 1(index1) → [1,2,1]
├── 1(index1)   <-- skipped because nums[1]==nums[0] and visited[0]==false
└── 2
    ├── 1(index0)
    │   └── 1(index1) → [2,1,1]
    └── 1(index1)   <-- skipped because nums[1]==nums[0] and visited[0]==false
 */