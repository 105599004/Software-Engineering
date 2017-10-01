package seoo.lab2;

import java.util.ArrayList;
import java.util.List;

/** Bank.java created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 */
public class Bank
{

    private String name;

    private List<Account> accounts;

    public Bank(String name)
    {
        this.name = name;
        accounts = new ArrayList<Account>();
    }

    public String getName()
    {
        return name;
    }

    public void createAccount(String id, String password, double initBalance)
    {
        if (getAccount(id) == null)
        {
            accounts.add(new Account(this, id, password, initBalance));
        }
    }

    public Account getAccount(String id)
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            Account account = accounts.get(i);
            if (account.getID().equals(id))
            {
                return account;
            }
        }
        return null;
    }
}
