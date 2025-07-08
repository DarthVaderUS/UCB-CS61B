package com.note.pack;

//This is a recursive version of list.
public class IntList{
    public int first;
    public  IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /*Return the size of the list using recursion */
    public  int size(){
        if(rest==null){
            return 1;
        }else{
            return rest.size()+1;
        }
    }
    /*Return the size of the list not using the recursion!!!*/
    public int iterativeSize(){     //iterative 迭代法
        IntList p = this;
        int totalSize=0;
        while(p!=null){
            p=p.rest;
            totalSize++;
        }
        return totalSize;
    }

    /*Return the ith element of the list using Recursion*/
    public int get(int i){
        if(i==0){
            return first;
        }else{
            return rest.get(i-1);
        }
    }


    public static void main(String[] args) {
        IntList L = new IntList(15,null);
        L = new IntList(10,L);
        L = new IntList(5,L);
        System.out.println(L.size()); //3
        System.out.println(L.get(2)); //3
    }
}

