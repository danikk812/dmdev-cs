package com.dmdev.javacore.oop.encapsulation.atm;

import java.util.Objects;

public class CashMachine {

    private final static int TEN_DOLLAR_BILL_DENOMINATION = 10;
    private final static int TWENTY_DOLLAR_BILL_DENOMINATION = 20;
    private final static int FIFTY_DOLLAR_BILL_DENOMINATION = 50;

    private int tenDollarBillsNumber;
    private int twentyDollarBillsNumber;
    private int fiftyDollarBillsNumber;

    public CashMachine() {
    }

    public CashMachine(int fiftyDollarBillsNumber, int twentyDollarBillsNumber, int tenDollarBillsNumber) {
        this.tenDollarBillsNumber = tenDollarBillsNumber;
        this.twentyDollarBillsNumber = twentyDollarBillsNumber;
        this.fiftyDollarBillsNumber = fiftyDollarBillsNumber;
    }

    public void cashIn(int fiftyDollarBillsAddition, int twentyDollarBillsAddition, int tenDollarBillsAddition) {
        this.tenDollarBillsNumber += tenDollarBillsAddition;
        this.twentyDollarBillsNumber += twentyDollarBillsAddition;
        this.fiftyDollarBillsNumber += fiftyDollarBillsAddition;

        System.out.printf("The ATM refilled with: 50$ X %d, 20$ X %d, $10 X %d%n", fiftyDollarBillsAddition, twentyDollarBillsAddition, tenDollarBillsAddition);
    }

    public boolean withdrawMoney(int cashAmount) {
        int remainingCashAmount = cashAmount;

        if (!isValidMoneyToWithdraw(cashAmount)) {
            System.out.println("Error: insufficient funds in the ATM or invalid amount");
            printCashStatus();
            return false;
        }

        int fiftyDollarBillsNeeded = countBillsNeededByDenominator(remainingCashAmount, FIFTY_DOLLAR_BILL_DENOMINATION, fiftyDollarBillsNumber);
        remainingCashAmount -= fiftyDollarBillsNeeded * FIFTY_DOLLAR_BILL_DENOMINATION;

        int twentyDollarBillsNeeded = countBillsNeededByDenominator(remainingCashAmount, TWENTY_DOLLAR_BILL_DENOMINATION, twentyDollarBillsNumber);
        remainingCashAmount -= twentyDollarBillsNeeded * TWENTY_DOLLAR_BILL_DENOMINATION;

        int tenDollarBillsNeeded = countBillsNeededByDenominator(remainingCashAmount, TEN_DOLLAR_BILL_DENOMINATION, tenDollarBillsNumber);
        remainingCashAmount -= tenDollarBillsNeeded * TEN_DOLLAR_BILL_DENOMINATION;

        if (remainingCashAmount == 0) {
            cashOut(fiftyDollarBillsNeeded, twentyDollarBillsNeeded, tenDollarBillsNeeded);
            printWithdrawalDetails(fiftyDollarBillsNeeded, twentyDollarBillsNeeded, tenDollarBillsNeeded);
            return true;
        } else {
            System.out.println("Error: Fail to issue the required amount with this set of bills");
            printCashStatus();
            return false;
        }
    }

    private void printWithdrawalDetails(int fiftyDollarBillsNeeded, int twentyDollarBillsNeeded,int tenDollarBillsNeeded) {
        System.out.printf("Cash issued: 50$ X %d, 20$ X %d, $10 X %d%n", fiftyDollarBillsNeeded, twentyDollarBillsNeeded, tenDollarBillsNeeded);
        System.out.println("Cash available: " + getTotalMoneyAvailable());
    }

    private void cashOut(int fiftyDollarBillsNeeded, int twentyDollarBillsNeeded,int tenDollarBillsNeeded) {
        this.tenDollarBillsNumber -= tenDollarBillsNeeded;
        this.twentyDollarBillsNumber -= twentyDollarBillsNeeded;
        this.fiftyDollarBillsNumber -= fiftyDollarBillsNeeded;
    }

    private int countBillsNeededByDenominator(int cashAmount, int billDenomination, int billsNumber) {
        return Math.min(cashAmount / billDenomination, billsNumber);
    }

    private boolean isValidMoneyToWithdraw(int cashAmount) {
        return cashAmount <= getTotalMoneyAvailable() && cashAmount > 0;
    }

    public void printCashStatus() {
        System.out.println("Cash available: " + getTotalMoneyAvailable());
        System.out.println("50$ bills number: " + getFiftyDollarBillsNumber());
        System.out.println("20$ bills  number: " + getTwentyDollarBillsNumber());
        System.out.println("10$ bills number: " + getTenDollarBillsNumber());
        System.out.println();
    }

    private int getTotalMoneyAvailable() {
        return tenDollarBillsNumber * TEN_DOLLAR_BILL_DENOMINATION
               + twentyDollarBillsNumber * TWENTY_DOLLAR_BILL_DENOMINATION
               + fiftyDollarBillsNumber * FIFTY_DOLLAR_BILL_DENOMINATION;
    }

    public int getTenDollarBillsNumber() {
        return tenDollarBillsNumber;
    }

    public void setTenDollarBillsNumber(int tenDollarBillsNumber) {
        this.tenDollarBillsNumber = tenDollarBillsNumber;
    }

    public int getTwentyDollarBillsNumber() {
        return twentyDollarBillsNumber;
    }

    public void setTwentyDollarBillsNumber(int twentyDollarBillsNumber) {
        this.twentyDollarBillsNumber = twentyDollarBillsNumber;
    }

    public int getFiftyDollarBillsNumber() {
        return fiftyDollarBillsNumber;
    }

    public void setFiftyDollarBillsNumber(int fiftyDollarBillsNumber) {
        this.fiftyDollarBillsNumber = fiftyDollarBillsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashMachine that = (CashMachine) o;
        return tenDollarBillsNumber == that.tenDollarBillsNumber && twentyDollarBillsNumber == that.twentyDollarBillsNumber && fiftyDollarBillsNumber == that.fiftyDollarBillsNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenDollarBillsNumber, twentyDollarBillsNumber, fiftyDollarBillsNumber);
    }

    @Override
    public String toString() {
        return "CashMachine{" +
                "tenDollarBillsNumber=" + tenDollarBillsNumber +
                ", twentyDollarBillsNumber=" + twentyDollarBillsNumber +
                ", fiftyDollarBillsNumber=" + fiftyDollarBillsNumber +
                '}';
    }
}
