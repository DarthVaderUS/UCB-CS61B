package com.note.pack2;
import java.util.function.Function;
//This file is to show how to write a higher order function in modern Java.

public class TenX {
    public static int tenX(int x) {
        return 10 * x;
    }
    public static int doTwice(Function<Integer, Integer> f, int x) {
        return f.apply(f.apply(x));
    }
    public static void main(String[] args) {
           int result = doTwice(TenX::tenX, 2);
           System.out.println(result);
    }
}
