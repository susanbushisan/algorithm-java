import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Question114
 */
public class Question114 {

    public static void main(String[] args) {
        Question114 question = new Question114();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        long start = System.currentTimeMillis();
        question.flatten(root);
        TreeNodeUtils.printAsTree(root);
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    /**
     * 难点是如果达到空间复杂度为O（1）
     */
    public void flattenI(TreeNode root) {
        while (root != null){
            if (root.left != null){
                TreeNode temp = root.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }else {
                root = root.right;
            }
        }
    }

    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        Queue<TreeNode> temp = new LinkedList<>();
        while (!stack.isEmpty()){
            root = stack.pop();
            temp.offer(root);
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
        TreeNode d = temp.poll();
        while (!temp.isEmpty()){
            d.left = null;
            d.right = temp.poll();
            d = d.right;
        }
    }


}

