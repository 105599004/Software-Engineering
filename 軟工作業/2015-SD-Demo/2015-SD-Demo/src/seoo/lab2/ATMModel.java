package seoo.lab2;

import java.util.ArrayList;
import java.util.List;

/** ATMModel.java created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 */
public class ATMModel
{

    private List<Bank> banks;

    private Account currentAccount;

    public ATMModel()
    {
        banks = new ArrayList<Bank>();
        currentAccount = null;
    }

    public boolean login(String id, String password)
    {
        Account account = findAccount(id);
        if (account != null && account.checkPassword(password))
        {
            currentAccount = account;
            return true;
        }
        return false;
    }

    public void logout()
    {
        currentAccount = null;
    }

    public boolean isValidAccount()
    {
        return currentAccount != null;
    }

    public String getBankName()
    {
        if (isValidAccount())
        {
            return currentAccount.getBankName();
        }
        return null;
    }

    public double getBalance()
    {
        if (isValidAccount())
        {
            return currentAccount.getBalance();
        }
        return 0;
    }

    public boolean withdraw(double amount)
    {
        if (isValidAccount())
        {
            return currentAccount.withdraw(amount);
        }
        return false;
    }

    public boolean deposit(double amount)
    {
        if (isValidAccount())
        {
            return currentAccount.deposit(amount);
        }
        return false;
    }

    public boolean transfer(String id, double amount)
    {
        Account transferTo = findAccount(id);
        if (isValidAccount() && transferTo != null)
        {
            if (currentAccount.withdraw(amount))
            {
                transferTo.deposit(amount);
                return true;
            }
        }
        return false;
    }

    public void initialize()
    {
        Bank abcBank = new Bank("ABC bank");
        Bank xyzBank = new Bank("XYZ bank");
        banks.add(abcBank);
        banks.add(xyzBank);
        abcBank.createAccount("123-456-789", "123456", 3000.0);
        xyzBank.createAccount("987-654-321", "654321", 2000.0);
    }

    private Account findAccount(String id)
    {
        for (int i = 0; i < banks.size(); i++)
        {
            Account account = banks.get(i).getAccount(id);
            if (account != null)
            {
                return account;
            }
        }
        return null;
    }
}
