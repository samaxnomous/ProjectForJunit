package com.bank.service;
<<<<<<< HEAD
//comment added from eclipse for conflicts
=======
//comment added from github.com for conflict
>>>>>>> 6d1c10b707e5836d9edbd13a38766fef986d9b89
import com.bank.dal.AccountDAO;
import com.bank.dal.AccountDAOInMemoryImpl;
import com.bank.domain.Account;

public class AccountService {
	
	AccountDAO dao=new AccountDAOInMemoryImpl();
	final double MIN_BAL=10000;
	
	public int createNewAccount(String type,double balance)
	{
		if(balance>=MIN_BAL)
		{
			Account a=new Account();
			a.setBalance(balance);
			a.setType(type);
			return dao.create(a);
		}else
			return 0;
	}
	
	public void withdraw(int id,double amount)throws InsufficientBalanceException
	{
		Account a=dao.getById(id);
		if(a.getBalance()>=amount)
		{
			a.setBalance(a.getBalance()-amount);
			dao.update(a);
		}else {
			throw new InsufficientBalanceException("Insufficient Balance to Withdraw "+amount);
		}
		
	}
	
	public void deposit(int id,double amount)
	{
		Account a=dao.getById(id);
		
			a.setBalance(a.getBalance()+amount);
			dao.update(a);
		
	}
	protected Account getById(int id)
	{
		return dao.getById(id);
	}

	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}

}
