package com.github.peaceheis.finhelper.backend.transaction;

import java.io.Serializable;
import java.util.ArrayList;

public class History implements Serializable {
    private String name;
    private int balance;
    public ArrayList<Transaction> transactions;
    private int id;

    public History() {
        this(new ArrayList<>(), 0, "History");
    }

    public History(ArrayList<Transaction> transactions, int balance, String name) {
        this.transactions = transactions;
        this.balance = balance;
        this.name = name;
    }

    void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        balance += transaction.getAmount();
        id++;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    int nextId() {
        return id;
    }

    @Override
    public String toString() {
        return "History{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                ", id=" + id +
                '}';
    }
}
