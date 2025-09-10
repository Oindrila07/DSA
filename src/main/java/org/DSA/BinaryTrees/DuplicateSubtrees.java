package org.DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicateSubtrees {
    HashMap<String, List<TreeNode>> hash=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();

        find(list,root);
        return list;
    }

    private String find(List<TreeNode> list, TreeNode node){
        if(node==null)return "N";
        String left=find(list,node.left);
        String right=find(list,node.right);
        String encoded=node.val+"N"+left+"N"+right;
        List<TreeNode> temp;
        if(hash.containsKey(encoded))temp=hash.get(encoded);
        else temp=new ArrayList<>();
        temp.add(node);
        hash.put(encoded,temp);
        if(hash.get(encoded).size()==2)list.add(node);
        return encoded;
    }
}

/*
🔑 Approach:
------------
1. The key idea is: Each subtree can be uniquely identified by its structure + values.
For example:
    2
   / \
  4   N
can be represented as: 2N4NNNN
Another subtree with the same structure and values will produce the exact same string.

2. Serialize each subtree into a string.
=> Use postorder traversal (left → right → root),
=> Build a unique string for each subtree:
=> encoded = node.val + "N" + left_serial + "N" + right_serial

3. Track occurrences in a HashMap.
=> Key = subtree serialization string
=> Value = list of roots that have this exact serialization

4. Detect duplicates.
=> If the same serialization is seen more than once, we’ve found a duplicate subtree.
=> To avoid adding multiple times, add it to the result list only when size == 2.
 */
