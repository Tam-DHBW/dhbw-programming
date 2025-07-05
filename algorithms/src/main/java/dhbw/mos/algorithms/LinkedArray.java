package dhbw.mos.algorithms;

import java.util.Arrays;

// [val, nxt, pre, val, nxt, pre, ...] nullptr = -1
public class LinkedArray {
    private final int[] data = new int[10*3];
    private int length = 0;
    private int head = -1;
    private int back = -1;

    public void addToFront(int x) {
        int pos = length;
        int ptr = pos * 3;
        int headPtr = head * 3;

        data[ptr] = x;
        data[ptr + 1] = head;
        data[ptr + 2] = -1;

        if (length > 0) data[headPtr + 2] = pos;
        else back = pos;
        head = pos;

        length++;
    }

    public void addToBack(int x) {
        int pos = length;
        int ptr = pos * 3;
        int backPtr = back * 3;

        data[ptr] = x;
        data[ptr + 1] = -1;
        data[ptr + 2] = back;

        if (length > 0) data[backPtr + 1] = pos;
        else head = pos;
        back = pos;

        length++;
    }

    public void reverse() {
        int pos = head;
        while (pos != -1) {
            int ptr = pos * 3;
            pos = data[ptr + 1];

            int temp = data[ptr + 1];
            data[ptr + 1] = data[ptr + 2];
            data[ptr + 2] = temp;
        }

        int temp = head;
        head = back;
        back = temp;
    }

    public void print() {
        System.out.print("Contents: ");
        int pos = head;
        while (pos != -1) {
            int ptr = pos * 3;
            System.out.print(data[ptr]);
            System.out.print(" ");
            pos = data[ptr + 1];
        }
        System.out.println();
    }

    public void dump() {
        System.out.println(length);
        System.out.println(head);
        System.out.println(back);
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        LinkedArray list = new LinkedArray();
        list.addToFront(1);
        list.print();
        list.addToFront(2);
        list.print();
        list.addToFront(3);
        list.print();
        list.addToBack(4);
        list.print();
        list.addToFront(5);
        list.print();
        list.addToBack(6);
        list.print();
        list.addToFront(7);
        list.print();
        list.addToBack(8);
        list.print();
        list.addToBack(9);
        list.print();
        list.reverse();
        list.print();
    }
}
