package com.example;

/**
 * @Title: ListNode
 * @Package com/example/ListNode.java
 * @Description: ListNode节点, value为int类型
 * singly-linked list
 * @author zhaozhiwei
 * @date 2021/10/5 下午2:15
 * @version V1.0
 */
public class ListNode {
   int val;
   ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
