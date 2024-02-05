package com.dmdev.cs.loops;

public class Task3 {

    public static void main(String[] args) {

        int salary = 600;
        int salaryRise = 400;
        int salaryRisePeriodInMonths = 6;
        int monthlySpending = 300;
        double monthlyInvestmentRate = 0.1;
        double stockReturnRate = 0.02;
        int months = 38;

        System.out.printf("Bank account balance with %.2f monthly investment rate: %.2f$%n",
                monthlyInvestmentRate, checkBankBalance(salary, salaryRise, salaryRisePeriodInMonths, monthlySpending, monthlyInvestmentRate, months));
        System.out.printf("Broker account balance with %.2f monthly investment rate: %.2f$%n",
                monthlyInvestmentRate, checkBrokerBalance(salary, salaryRise, salaryRisePeriodInMonths, monthlyInvestmentRate, stockReturnRate, months));
        System.out.println();

        monthlyInvestmentRate = 0.25; // increase monthly investment rate up to 25%

        System.out.printf("Bank account balance with %.2f monthly investment rate: %.2f$%n",
                monthlyInvestmentRate, checkBankBalance(salary, salaryRise, salaryRisePeriodInMonths, monthlySpending, monthlyInvestmentRate, months));
        System.out.printf("Broker account balance with %.2f monthly investment rate: %.2f$%n",
                monthlyInvestmentRate, checkBrokerBalance(salary, salaryRise, salaryRisePeriodInMonths, monthlyInvestmentRate, stockReturnRate, months));
        System.out.println();

        monthlyInvestmentRate = 0.3; // increase monthly investment rate up to 30%

        System.out.printf("Bank account balance with %.2f monthly investment rate: %.2f$%n",
                monthlyInvestmentRate, checkBankBalance(salary, salaryRise, salaryRisePeriodInMonths, monthlySpending, monthlyInvestmentRate, months));
        System.out.printf("Broker account balance with %.2f monthly investment rate: %.2f$%n",
                monthlyInvestmentRate, checkBrokerBalance(salary, salaryRise, salaryRisePeriodInMonths, monthlyInvestmentRate, stockReturnRate, months));


    }

    private static double checkBankBalance(int salary, int salaryRise, int salaryRisePeriodInMonths, int monthlySpending, double monthlyInvestmentRate, int months) {
        double bankAccountBalance = 0;

        for (int currentMonth = 1; currentMonth < months; currentMonth++) {
            double investments = salary * monthlyInvestmentRate;

            if (currentMonth % salaryRisePeriodInMonths != 0) {
                bankAccountBalance += salary - monthlySpending - investments;
            } else {
                bankAccountBalance += salary - monthlySpending - investments;
                salary += salaryRise;
            }
        }

        return bankAccountBalance;
    }

    private static double checkBrokerBalance(int salary, int salaryRise, int salaryRisePeriodInMonths, double monthlyInvestmentRate, double stockReturnRate, int months) {
        double brokerAccountBalance = 0;

        for (int currentMonth = 1; currentMonth < months; currentMonth++) {
            double investments = salary * monthlyInvestmentRate;
            double stockReturn = brokerAccountBalance * stockReturnRate;

            if (currentMonth == 1) {
                brokerAccountBalance += investments;
            } else if (currentMonth % salaryRisePeriodInMonths != 0) {
                brokerAccountBalance += investments + stockReturn;
            } else {
                brokerAccountBalance += investments + stockReturn;
                salary += salaryRise;
            }
        }

        return brokerAccountBalance;
    }

}
