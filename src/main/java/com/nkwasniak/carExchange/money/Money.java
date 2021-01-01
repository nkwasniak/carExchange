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


    public Money add(Money money) throws Exception {
        if (!money.getCurrency().equals(this.currency)) {
            throw (new Exception("different currency can't be add"));
        }
        BigDecimal value = this.getAmount().add(money.getAmount());
        Money result = new Money(value.doubleValue(), this.getCurrency());
        return result;
    }

    public Money minus(Money money) throws Exception {
        if (!money.getCurrency().equals(this.currency)) {
            throw (new Exception("different currency can't be minus"));
        }

        BigDecimal value = this.getAmount().add(money.getAmount().negate());
        Money result = new Money(value.doubleValue(), this.getCurrency());
        return result;

    }

    public Money multiply(double multiplicand, int roundingMode) {
        BigDecimal amount = this.getAmount().multiply(new BigDecimal(multiplicand));
        amount = amount.divide(BigDecimal.ONE, roundingMode);
        return new Money(amount.doubleValue(), this.getCurrency());
    }

    public Money divide(double divisor, int roundingMode) {
        BigDecimal amount = this.getAmount().divide(new BigDecimal(divisor), roundingMode);
        Money result = new Money(amount.doubleValue(), this.getCurrency());
        return result;

    }
}









