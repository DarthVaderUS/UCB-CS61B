package com.note.pack;

//SLList, but with additional, rotateRight operation.
public class RotatingSLList<Item> extends SLList<Item> {

    public void rotateRight() {
        Item x = removeLast();
        addFirst(x);
    }

}
