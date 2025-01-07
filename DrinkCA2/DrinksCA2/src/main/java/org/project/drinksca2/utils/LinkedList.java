package org.project.drinksca2.utils;

public class LinkedList<N> {

    public Node<N> head = null, last = null;

    public void add(N c) {
        Node<N> temp = new Node<>();
        temp.setContents(c);
        if (head == null) head = temp;
        else last.next = temp;
        last = temp;
    }


    public N get(int e) {
        Node<N> temp = head;
        for(int i = 0; i < e; i++){
            temp = temp.next;
        }
        return temp.getContents();
    }

    public int LLlength(){

        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void reset() {
        head = null;
    }

    public class Node<N> {
        public Node<N> next = null;
        public N contents;

        public N getContents() {
            return contents;
        }

        public void setContents(N c) {
            contents = c;
        }
    }

    public void delete(int d) {
        Node<N> temp = head;
        int i = 1;

        while (i < d && temp != null) {
            temp = temp.next;
            i++;
        }
        if (d == 0) {
            head = head.next;
        } else if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }
}