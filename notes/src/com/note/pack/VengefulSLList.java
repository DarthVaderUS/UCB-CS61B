package com.note.pack;

public class VengefulSLList<Item> extends SLList<Item> {

    SLList<Item> lostItems;

    // Create an empty Vengeful SLList.
    public VengefulSLList() {
        super();  /* Calls the parent class constructor
                     If we don't add this line, the java compiler will still call the parent class constructor;
                   */
        lostItems = new SLList<>();
    }

    // Create a Vengeful SLList with one item, x.
    public VengefulSLList(Item x) {
        super(x);  /* Calls the parent class constructor with one item */
        lostItems = new SLList<>();
    }


    @Override
    public Item removeLast() {
        Item x = super.removeLast();  /*super : calls the parent class method
                                       Because size and sentinel are private in SLList.
                                       */

        lostItems.addLast(x);
        return x;
    }

    public void printLostItems() {
        lostItems.print();
    }
}
