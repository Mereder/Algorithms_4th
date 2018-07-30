package com.mereder.Algs_Exercise.Exercises1_3;

/**
 * 编写一个函数，接受一条链表的首结点作为参数。（破坏性地）将链表反转，并返回结果链表的首结点
 */
public class E_30 {
    public static class Node<Item>{
        public Item item;
        public Node<Item> next;
    }

    /** 迭代解答记录链表中三个连续的结点：reverse first second
     * 在每轮迭代中，我们从原链表中提取结点first 并将它插入到逆链表的开头
     * 我们需要一直保持first指向原链表中所有剩余结点的首结点，second指向原链表中
     * 所有剩余结点的第二个结点，reverse指向结果链表的首结点
     *
     * 通俗来讲：reverse 就是一个新链表的首结点  first为即将插入reverse链表的结点，second始终为剩下的链表，
     * first每次需要指向将剩下链表的首结点，然后将second下移一个
     *
     * @param head
     * @return
     */
    public static Node iterationReverse(Node head){
        Node<Integer> reverse = null;
        Node<Integer> first = head;
        while(first != null){
            Node<Integer> second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    /**假设链表含有N个结点， 依次递归颠倒N-1个结点
     * @param head
     * @return
     */
    public static Node recursionReverse(Node head){
        if (head == null) return null;
        if (head.next == null) return head;
        Node second = head.next;
        Node rest = recursionReverse(second);
        second.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        Node<Integer> first = new Node<>();
        first.item = 1;
        Node<Integer> second = new Node<>();
        second.item = 2;
        Node<Integer> third = new Node<>();
        third.item = 3;
        Node<Integer> fourth = new Node<>();
        fourth.item = 4;
        first.next= second;second.next = third;third.next = fourth;fourth.next = null;

        Node<Integer> test = iterationReverse(first);
        System.out.println(test.item);

        Node<Integer> test2 = recursionReverse(test);
        System.out.println(test2.item);
    }
}
