package com.github.peaceheis.finhelper.backend.transaction;

import java.io.Serializable;

public class Transaction implements Serializable {
    private History history;
    private int amount;
    private int id;
    private String category;
    private String comments;
    private int balanceBefore;
    private int balanceAfter;

    public Transaction(History history, int amount, String category, String comments) {
        this.history = history;
        this.amount = amount;
        this.id = history.nextId();
        this.category = category;
        this.comments = comments;
        this.balanceBefore = history.getBalance();
        this.history.addTransaction(this);
        this.balanceAfter = history.getBalance();
    }

    public History getHistory() {
        return history;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getComments() {
        return comments;
    }

    public int getBalanceBefore() {
        return balanceBefore;
    }

    public int getBalanceAfter() {
        return balanceAfter;
    }
}
