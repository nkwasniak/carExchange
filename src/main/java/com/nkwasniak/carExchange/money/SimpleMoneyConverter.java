package com.nkwasniak.carExchange.money;

import java.math.BigDecimal;
import java.util.Currency;

public class SimpleMoneyConverter {

    private static final BigDecimal PLN_TO_DOLLAR = new BigDecimal(0.27);
    private static final BigDecimal EURO_TO_DOLLAR = new BigDecimal(1.23);
    private static final Currency DOLLAR = Currency.getInstance(com.nkwasniak.carExchange.money.Currency.USD.name());
    private static final Currency PLN = Currency.getInstance(com.nkwasniak.carExchange.money.Currency.PLN.name());
    private static final Currency EURO = Currency.getInstance(com.nkwasniak.carExchange.money.Currency.EUR.name());

    public static Money convertTo(Money money, Currency target) throws Exception {
        if (!known(money.getCurrency()) || !known(target)) {
            throw (new Exception("unknown currency"));
        }

        BigDecimal factorSource = BigDecimal.ONE, factorTarget = BigDecimal.ONE;
        if (money.getCurrency().equals(PLN))
            factorSource = PLN_TO_DOLLAR;
        if (money.getCurrency().equals(EURO))
            factorSource = EURO_TO_DOLLAR;
        BigDecimal value = money.getAmount().multiply(factorSource).divide(factorTarget);

        return new Money(value.doubleValue(), target);
    }

    private static boolean known(Currency currency) {
        return (currency.equals(PLN) || currency.equals(EURO)) || currency.equals(DOLLAR);
    }

}
