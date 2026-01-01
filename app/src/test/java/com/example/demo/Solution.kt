package com.example.demo

import android.health.connect.datatypes.units.Length
import java.util.Collections

class Solution {
    // 整数数组nums， 只有一个出现奇数次， 其余都是偶数次数
    fun findOdd(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var ans = nums[0]
        for (i in 1 until nums.size) {
            ans = ans xor nums[i]
        }
        return ans
    }

    class TreeNode(
        val value: Int,
        val left: TreeNode? = null,
        val right: TreeNode? = null
    )

    // 二叉树， 查找最近公共祖先
    var count = 2
    var a: TreeNode = TreeNode(1)
    var b: TreeNode = TreeNode(2)
    fun findNearCommonParent(root: TreeNode) {
        // 中序遍历
        dfs(root.left)
        root
        dfs(root.right)
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) {
            return
        }

        if (node === a) {
            count--
        }

        if (node === b) {
            count--
        }

        if (count == 0) {

        }
    }


    // 二叉树， 查找最近公共祖先
    fun findCommonParent(root: TreeNode?, a: TreeNode, b: TreeNode): TreeNode? {
        if (root == null || root === a || root === b) {
            return root
        }

        val left = findCommonParent(root.left, a, b)
        val right = findCommonParent(root.right, a, b)

        return if (left != null && right != null) {
            root
        } else {
            left ?: right
        }
    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root === p || root === q) {
            return root
        }

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        return if (left != null && right != null) {
            root
        } else {
            left ?: right
        }
    }


    fun permute(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val output = mutableListOf<Int>()
        for (num in nums) {
            output.add(num)
        }
        backTrace(nums.size, output, 0, ans)
        return ans
    }

    private fun backTrace(
        length: Int, output: List<Int>, first: Int, ans: MutableList<List<Int>>
    ) {
        if (first == length) {
            ans.add(output.toMutableList())
        }
        for (i in first until length) {
            Collections.swap(output, first, i)
            backTrace(length, output, first + 1, ans)
            Collections.swap(output,first,i)
        }
    }


}