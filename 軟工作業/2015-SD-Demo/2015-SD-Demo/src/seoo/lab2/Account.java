package seoo.lab2;

/** Account.java created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 *
 * @author Pin-Ying Tu
 * @version 1.0
 */
public class Account
{

    private Bank _bank;

    private String _id;

    private String _password;

    private double _balance;

    public Account(Bank bank, String id, String password, double initBalance)
    {
        _bank = bank;
        _id = id;
        _password = password;
        _balance = initBalance;
    }

    public String getID()
    {
        return _id;
    }

    public double getBalance()
    {
        return _balance;
    }

    public String getBankName()
    {
        return _bank.getName();
    }

    public boolean checkPassword(String password)
    {
        return _password.equals(password);
    }

    public boolean withdraw(double amount)
    {
        if (amount > 0 && _balance >= amount)
        {
            _balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount)
    {
        if (amount > 0)
        {
            _balance += amount;
            return true;
        }
        return false;
    }
}
