package com.ro0sterjam.ctci;

import java.lang.reflect.Array;

/**
 * Created by kenwang on 2016-03-13.
 */
public class LinkedList<T> {

    private SinglyLinkedNode<T> head;

    public T head() {
        if (head == null) {
            return null;
        } else {
            return head.value;
        }
    }

    public int size() {
        SinglyLinkedNode<T> node = head;
        int i = 0;
        while (node != null) {
            node = node.next;
            i++;
        }
        return i;
    }

    public void removeDuplicates() {
        SinglyLinkedNode<T> node = head;
        while (node != null && node.next != null) {
            node.next = removeAll(node.next, node.value);
            node = node.next;
        }
    }

    public T[] toArray() {
        if (head == null) {
            return (T[]) new Object[0];
        }
        T[] array = (T[]) Array.newInstance(head.value.getClass(), size());
        SinglyLinkedNode<T> node = head;
        int i = 0;
        while (node != null) {
            array[i++] = node.value;
            node = node.next;
        }
        return array;
    }

    public T get(int i) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        } else if (i < 0) {
            return reverseGet(-i - 1);
        } else {
            SinglyLinkedNode<T> node = head;
            while (i-- > 0 && node != null) {
                node = node.next;
            }
            if (node == null) {
                throw new IndexOutOfBoundsException();
            }
            return node.value;
        }
    }

    public T reverseGet(int i) {
        if (i < 0 || head == null) {
            throw new IndexOutOfBoundsException();
        }
        SinglyLinkedNode<T> runner = head;
        while (i-- >= 0) {
            if (runner == null) {
                throw new IndexOutOfBoundsException();
            }
            runner = runner.next;
        }
        SinglyLinkedNode<T> node = head;
        while (runner != null) {
            runner = runner.next;
            node = node.next;
        }
        return node.value;
    }

    public boolean isPalindrome() {
        LinkedList<T> reversed = reverse();
        SinglyLinkedNode<T> node1 = head;
        SinglyLinkedNode<T> node2 = reversed.head;
        while (node1 != null && node2 != null) {
            if (node1.value != node2.value) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    public LinkedList<T> reverse() {
        SinglyLinkedNode<T> cursor = head;
        SinglyLinkedNode<T> node = null;
        while (cursor != null) {
            SinglyLinkedNode<T> temp = node;
            node = new SinglyLinkedNode<>(cursor.value);
            node.next = temp;
            cursor = cursor.next;
        }
        LinkedList<T> reversed = new LinkedList<>();
        reversed.head = node;
        return reversed;
    }

    public static <T> LinkedList<T> of(T... elements) {
        LinkedList<T> list = new LinkedList<>();
        if (elements.length == 0) {
            return list;
        }
        list.head = new SinglyLinkedNode<>(elements[0]);
        SinglyLinkedNode<T> node = list.head;
        for (int i = 1; i < elements.length; i++) {
            node.next = new SinglyLinkedNode<>(elements[i]);
            node = node.next;
        }
        return list;
    }

    public static <T extends Comparable<T>> void partition(LinkedList<T> list, T value) {
        SinglyLinkedNode<T> lt = null;
        SinglyLinkedNode<T> ge = null;
        SinglyLinkedNode<T> runner = list.head;
        SinglyLinkedNode<T> mid = null;
        while (runner != null) {
            SinglyLinkedNode<T> next = runner.next;
            if (runner.value.compareTo(value) < 0) {
                runner.next = lt;
                lt = runner;
                if (mid == null) {
                    mid = runner;
                }
            } else {
                runner.next = ge;
                ge = runner;
            }
            runner = next;
        }
        if (lt == null) {
            list.head = ge;
        } else {
            list.head = lt;
            mid.next = ge;
        }
    }

    public static LinkedList<Integer> reverseSum(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> sum = new LinkedList<>();
        sum.head = reverseSum(list1.head, list2.head, 0);
        return sum;
    }

    public static LinkedList<Integer> sum(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        if (list1.head == null && list2.head == null) {
            return new LinkedList<>();
        }

        int sizeDiff = list2.size() - list1.size();
        SinglyLinkedNode<Integer> head1 = pad(list1.head, sizeDiff);
        SinglyLinkedNode<Integer> head2 = pad(list2.head, -sizeDiff);

        SinglyLinkedNode<Integer> sum = sum(head1, head2);
        if (sum.value == 0 && sum.next != null) {
            sum = sum.next;
        }
        LinkedList<Integer> sumList = new LinkedList<>();
        sumList.head = sum;
        return sumList;
    }

    private static SinglyLinkedNode<Integer> pad(SinglyLinkedNode<Integer> node, int length) {
        while (length-- > 0) {
            SinglyLinkedNode<Integer> temp = node;
            node = new SinglyLinkedNode<>(0);
            node.next = temp;
        }
        return node;
    }

    private static SinglyLinkedNode<Integer> sum(SinglyLinkedNode<Integer> node1, SinglyLinkedNode<Integer> node2) {
        if (node1 == null && node2 == null) {
            return new SinglyLinkedNode<>(0);
        } else {
            SinglyLinkedNode<Integer> carry = sum(node1.next, node2.next);
            int partialSum = node1.value + node2.value + carry.value;
            SinglyLinkedNode<Integer> node = new SinglyLinkedNode<>(partialSum % 10);
            node.next = carry.next;
            carry.value = partialSum / 10;
            carry.next = node;
            return carry;
        }
    }

    private static SinglyLinkedNode<Integer> reverseSum(SinglyLinkedNode<Integer> node1, SinglyLinkedNode<Integer> node2, int carry) {
        if (node1 == null && node2 == null && carry == 0) {
            return null;
        }
        int sum = (node1 == null? 0 : node1.value) + (node2 == null? 0 : node2.value) + carry;
        SinglyLinkedNode<Integer> result = new SinglyLinkedNode<>(sum % 10);
        carry = sum / 10;
        result.next = reverseSum(node1 == null? null : node1.next, node2 == null? null : node2.next, carry);
        return result;
    }

    private <T> SinglyLinkedNode<T> removeAll(SinglyLinkedNode<T> root, T value) {
        if (root == null) {
            return null;
        }
        if (root.value.equals(value)) {
            return removeAll(root.next, value);
        } else {
            root.next = removeAll(root.next, value);
            return root;
        }
    }

}
