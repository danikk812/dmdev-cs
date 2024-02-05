package com.dmdev.cs.loops;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 */
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

        for (int currentMonth = 1; currentMonth <= months; currentMonth++) {
            double investments = calculateMonthlyInvestmentsFromSalary(salary, monthlyInvestmentRate);

            if (currentMonth % salaryRisePeriodInMonths != 0) {
                bankAccountBalance = calculateMonthlyBankAccountBalance(bankAccountBalance, salary, monthlySpending, investments);
            } else {
                bankAccountBalance = calculateMonthlyBankAccountBalance(bankAccountBalance, salary, monthlySpending, investments);
                salary = calculateRaisedSalary(salary, salaryRise);
            }
        }

        return bankAccountBalance;
    }

    private static double checkBrokerBalance(int salary, int salaryRise, int salaryRisePeriodInMonths, double monthlyInvestmentRate, double stockReturnRate, int months) {
        double brokerAccountBalance = 0;

        for (int currentMonth = 1; currentMonth <= months; currentMonth++) {
            double investments = calculateMonthlyInvestmentsFromSalary(salary, monthlyInvestmentRate);
            double stockReturn = calculateStockReturn(brokerAccountBalance, stockReturnRate);

            if (currentMonth == 1) {
                brokerAccountBalance += investments;
            } else if (currentMonth % salaryRisePeriodInMonths != 0) {
                brokerAccountBalance = calculateMonthlyBrokerAccountBalanceWithStockReturn(brokerAccountBalance, investments, stockReturn);
            } else {
                brokerAccountBalance = calculateMonthlyBrokerAccountBalanceWithStockReturn(brokerAccountBalance, investments, stockReturn);
                salary = calculateRaisedSalary(salary, salaryRise);
            }
        }

        return brokerAccountBalance;
    }


    private static double calculateMonthlyInvestmentsFromSalary(int salary, double investmentRate) {
        return salary * investmentRate;
    }

    private static double calculateMonthlyBankAccountBalance(double bankAccountBalance, int salary, int monthlySpending, double investments) {
        return bankAccountBalance + salary - monthlySpending - investments;
    }

    private static int calculateRaisedSalary(int salary, int salaryRise) {
        return salary + salaryRise;
    }

    private static double calculateStockReturn(double brokerAccountBalance, double stockReturnRate) {
        return brokerAccountBalance * stockReturnRate;
    }

    private static double calculateMonthlyBrokerAccountBalanceWithStockReturn(double brokerAccountBalance, double investments,  double stockReturn) {
        return brokerAccountBalance + investments + stockReturn;
    }

}
