package com.example.alternativebanking.domain;

import com.example.banking.domain.AccountStatus;

public class SavingsAccount implements Account {
	private final String iban;
	protected double balance;
	protected AccountStatus status;

	public SavingsAccount(String iban) {
		this(iban, 0.0);
	}

	public SavingsAccount(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
		this.status = AccountStatus.ACTIVE;
	}

	@Override
	public String getIban() {
		return iban;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public AccountStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(AccountStatus status) {
		this.status = status;
	}

}
