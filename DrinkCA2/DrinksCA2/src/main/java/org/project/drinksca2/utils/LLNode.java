package org.project.drinksca2.utils;

public class LLNode<T> {
    T data;
    LLNode<T> next;

    public LLNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LLNode<T> getNext() {
        return next;
    }

    public void setNext(LLNode<T> next) {
        this.next = next;
    }
    public void sortAlphabetically() {
        LLNode<T> current = this, index = null;
        T temp;

        if (this == null) {
            return;
        } else {
            while (current != null) {
                index = current.getNext();

                while (index != null) {
                    if (current.getData().toString().compareTo(index.getData().toString()) > 0) {
                        temp = current.getData();
                        current.setData(index.getData());
                        index.setData(temp);
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }

    public void add(T data) {
        LLNode<T> temp = new LLNode<>(data);
        LLNode<T> current = this;

        if (this == null) {
            this.data = data;
            this.next = null;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
        }
    }
}
