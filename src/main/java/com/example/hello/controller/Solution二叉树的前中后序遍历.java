package com.example.hello.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: com.example.hello.controller
 * @author: 喝咖啡的大象
 * @date: 2021/6/11
 */
public class Solution二叉树的前中后序遍历 {

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        //preorder(root,res);
        //preorder(root,res);
        postorder(root,res);
        return res;
    }

    /**
     * 二叉树的前序遍历O(N)
     *
     * @param root
     * @param res
     */
    private void preorder(TreeNode root, List<Integer> res) {
        if (root==null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);

    }
    /**
     * 二叉树的中序遍历O(N)
     *
     * @param root
     * @param res
     */
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    /**
     * 二叉树的后序遍历O(N)
     *
     * @param root
     * @param res
     */
    private void postorder(TreeNode root, List<Integer> res) {
        if (root==null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        Solution二叉树的前中后序遍历 solution = new Solution二叉树的前中后序遍历();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNodel = new TreeNode(9);
        treeNode.left = treeNodel;
        TreeNode treeNoder = new TreeNode(5);
        treeNode.right = treeNoder;
        solution.preorderTraversal(treeNode);
        System.out.println(solution.preorderTraversal(treeNode).toString());
    }

}
