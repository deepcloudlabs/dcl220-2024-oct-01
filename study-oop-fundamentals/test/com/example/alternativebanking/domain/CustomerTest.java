package com.example.alternativebanking.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void test1() {
		var jack = new Customer("11111111110");
		Account account = new DebitAccount("TR1");
		jack.addAccount(account);
		if (account instanceof Depositable depositableAccount) {
			depositableAccount.deposit(10_000);
		}
		if (account instanceof Withdrawable withdrawableAccount) {
			withdrawableAccount.withdraw(5_000);
		}
		assertAll(List.of(
		    () -> assertEquals(1,jack.getAccounts().size()),
		    () -> assertEquals(5_000,account.getBalance())
		));
	}
	
	@Test
	void test2() {
		var jack = new Customer("11111111110");
		Account account = new SavingsAccount("TR1",100_000);
		jack.addAccount(account);
		if (account instanceof Depositable depositableAccount) {
			depositableAccount.deposit(10_000);
		}
		if (account instanceof Withdrawable withdrawableAccount) {
			withdrawableAccount.withdraw(5_000);
		}
		assertAll(List.of(
		    () -> assertEquals(1,jack.getAccounts().size()),
		    () -> assertEquals(100_000,account.getBalance())
		));
	}

}
