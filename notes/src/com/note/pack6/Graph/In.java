package com.note.pack6.Graph;

import java.io.*;
import java.util.*;

public class In {
    private Scanner scanner;

    public In(String filename) {
        try {
            scanner = new Scanner(new FileInputStream(filename));
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open file: " + filename);
        }
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public double readDouble() {
        return scanner.nextDouble();
    }
}
