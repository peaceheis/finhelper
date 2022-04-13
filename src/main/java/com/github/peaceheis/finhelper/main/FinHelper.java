package com.github.peaceheis.finhelper.main;

import com.github.peaceheis.finhelper.backend.transaction.History;
import com.github.peaceheis.finhelper.backend.transaction.Transaction;

import java.io.*;

public class FinHelper {
    private static History history;
    public static void main(String[] args) {
        load();

    }

    public static void load() {
        History history = new History();
        Transaction testTransaction = new Transaction(history, 500, "PAYMENT", "Blah");

        History history1 = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/history.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            history1 = (History) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("History class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized History...");
        System.out.println(history1);
    }

    public static void save() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/history.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(history);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /tmp/history.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
