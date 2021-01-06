package com.nkwasniak.carExchange.money;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {
    private long amount;
    private Currency currency;

    public BigDecimal getAmount() {
        return BigDecimal.valueOf(amount, currency.getDefaultFractionDigits());
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money(double amount, Currency currency) {
        this.currency = currency;
        this.amount = Math.round(amount * centFactor());
    }

    public Money(long amount, Currency currency) {
        this.currency = currency;
        this.amount = amount * centFactor();
    }

    private static final int[] cents = new int[]{1, 10, 100, 1000, 10000};

    private int centFactor() {
        return cents[currency.getDefaultFractionDigits()];
    }
}









