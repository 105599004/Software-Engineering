package seoo.lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;

/** ATMTextUI.java created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 */
public class ATMTextUI
{

    private static final int UNKNOWN = -1;

    private static final int EXIT = 0;

    private static final int SHOW_BALANCE = 1;

    private static final int WITHDRAW = 2;

    private static final int DEPOSIT = 3;

    private static final int TRANSFER = 4;

    private ATMModel atmModel;

    private BufferedReader reader;

    public ATMTextUI(ATMModel model)
    {
        atmModel = model;
    }

    public void show()
    {
        while (true)
        {
            if (atmModel.isValidAccount())
            {
                int option = UNKNOWN;
                do
                {
                    option = showMainMenu();
                    switch (option)
                    {
                    case EXIT:
                        atmModel.logout();
                        System.out.println("Bye!!");
                        System.out.println();
                        break;
                    case SHOW_BALANCE:
                        showResult(true);
                        break;
                    case WITHDRAW:
                        showWithdrawScreen();
                        break;
                    case DEPOSIT:
                        showDepositScreen();
                        break;
                    case TRANSFER:
                        showTransferScreen();
                        break;
                    default:
                        System.out.println("Unkown option!");
                    }
                    ;
                } while (option != EXIT);
            } else
            {
                showLoginScreen();
            }
        }
    }

    private void showDepositScreen()
    {
        System.out.print("Please input the amount to deposit: ");
        double amount = readDouble();
        showResult(atmModel.deposit(amount));
    }

    private void showLoginScreen()
    {
        System.out.println("Welcome to ATM!");
        System.out.println("There are two accounts in the system.");
        System.out.println("   1. Account ID: 123-456-789");
        System.out.println("      Password: 123456");
        System.out.println("   2. Account ID: 987-654-321");
        System.out.println("      Password: 654321");
        System.out.println("Please use the above accounts to access the ATM.");
        System.out.println();
        System.out.println("Please enter account ID and password");
        System.out.print("Account ID (###-###-###): ");
        String id = readString();
        System.out.print("Account password: ");
        String password = readString();
        if (atmModel.login(id, password))
        {
            System.out.println();
            System.out.println("Welcome to " + atmModel.getBankName() + ".");
        } else
        {
            System.out.println("Your account and password are incorrect!!!!!");
            System.out.println("Please try again.");
            System.out.println();
        }
    }

    private int showMainMenu()
    {
        System.out.println();
        System.out.println("Options");
        System.out.println("[" + SHOW_BALANCE + "] Show balance.");
        System.out.println("[" + WITHDRAW + "] Withdraw.");
        System.out.println("[" + DEPOSIT + "] Deposit.");
        System.out.println("[" + TRANSFER + "] Transfer.");
        System.out.println("[" + EXIT + "] Exit.");
        System.out.print("Your choice: ");
        return readInt();
    }

    private void showResult(boolean result)
    {
        System.out.print((result) ? "Success." : "Fail.");
        System.out.println(" Your account balance: " + atmModel.getBalance());
        System.out.println();
    }

    private void showTransferScreen()
    {
        System.out.print("Please input the account ID (###-###-###) to transfer: ");
        String account = readString();
        System.out.print("Please input the amount to transfer: ");
        double amount = readDouble();
        showResult(atmModel.transfer(account, amount));
    }

    private void showWithdrawScreen()
    {
        System.out.print("Please input the amount to withdraw: ");
        double amount = readDouble();
        showResult(atmModel.withdraw(amount));
    }

    private double readDouble()
    {
        Number number = readNumber();
        return number != null ? number.doubleValue() : 0;
    }

    private String readString()
    {
        String value = "";
        do
        {
            try
            {
                value = getConsoleReader().readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        } while (value.equals(""));
        return value;
    }

    private Number readNumber()
    {
        DecimalFormat format = new DecimalFormat();
        Number number = null;
        try
        {
            number = format.parse(readString());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return number;
    }

    private int readInt()
    {
        Number number = readNumber();
        return number != null ? number.intValue() : 0;
    }

    private BufferedReader getConsoleReader()
    {
        if (reader == null)
        {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }
        return reader;
    }
}
