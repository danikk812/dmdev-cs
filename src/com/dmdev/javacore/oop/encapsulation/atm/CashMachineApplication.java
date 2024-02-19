package com.dmdev.javacore.oop.encapsulation.atm;

import com.dmdev.javacore.oop.encapsulation.atm.util.ConsoleReader;

public class CashMachineApplication {

    public static void main(String[] args) {

        CashMachine cashMachine = new CashMachine();

        cashMachine.cashIn(3, 5, 7);

        cashMachine.printCashStatus();

        cashMachine.withdrawMoney(ConsoleReader.readInt("Enter the cash amount to be withdrawn: "));

    }
}
