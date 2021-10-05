package com.example;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 1942 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoLists_21 {

    /**
     * @data: 2021/10/5-下午3:11
     * @User: zhaozhiwei
     * @method: mergeTwoLists2
      * @param l1 :
     * @param l2 :
     * @return: com.example.ListNode
     * @Description: 合并两个有序链表
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.8 MB,击败了61.59% 的Java用户
     *
     * 设定一个哨兵节点 prehead ，这可以在最后让我们比较容易地返回合并后的链表。我们维护一个 prev 指针，我们需要做的是调整它的 next 指针。
     * 然后，我们重复以下过程，直到 l1 或者 l2 指向了 null
     * ：如果 l1 当前节点的值小于等于 l2 ，我们就把 l1 当前的节点接在 prev 节点的后面
     * 同时将 l1 指针往后移一位。
     * 否则，我们对 l2 做同样的操作。不管我们将哪一个元素接在了后面，我们都需要把 pre向后移一位。
     *
     * 在循环终止的时候， l1 和 l2
     * 至多有一个是非空的。由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表即可
     *
     * while 循环的次数不会超过两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        判断next, 增加一个虚拟Node
        ListNode preHead = new ListNode(-1);

//      移动指针，指向当前便利对象, 初始化到头
        ListNode prev = preHead;

//        一直调整l1, l2 = .next, 直到为空，即都遍历完成
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
//            如果 l1 当前节点的值小于等于 l2 ，我们就把 l1 当前的节点接在 prev 节点的后面
               prev.next = l1;
//               * 同时将 l1 指针往后移一位。
               l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

//        可能存在一个未被合并完成
        prev.next = l1 == null ? l2: l1;

        return preHead.next;
    }

    /**
     * @Description: 递归
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.9 MB,击败了23.35% 的Java用户
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val <= l2.val){
//            如果l1.val <= l2.val那么l1.next就是l2, 反之同理, 递归直到next为null
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        //按照给定节点遍历next
//        传入没有下一节点的情况
        if (l1 == null || l1.next == null) {
            return l2;
        } else if (l2 == null || l2.next == null) {
            return l1;
        }

        final List<Integer> integers = new ArrayList<Integer>();

        integers.add(l1.val);
        while (l1.next != null) {
            integers.add(l1.next.val);
            l1.next = l1.next.next;
        }

        integers.add(l2.val);
        while (l2.next != null) {
            integers.add(l2.next.val);
            l2.next = l2.next.next;
        }

//        排序
        Collections.sort(integers);

//        将集合写入到ListNode中
        ListNode listNode = null;
        ListNode pre = null;
        for (Integer integer : integers) {
            ListNode tmp = new ListNode(integer);
            if (listNode == null) {
                listNode = tmp;
                pre = listNode;
            } else {
                pre.next = tmp;
//               指针后移
                pre = pre.next;
            }
        }
        return listNode;
    }

    public static void main(String[] args) {

        //输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]

//        final ListNode l1 = new ListNode();
        final ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

//        final ListNode l2 = new ListNode();
        final ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        final ListNode listNode = new MergeTwoLists_21().mergeTwoLists2(l1, l2);

        System.out.println(listNode.val);
        while (listNode.next != null) {
            System.out.println(listNode.next.val);
            listNode.next = listNode.next.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
