package com.devarchi33.excer;

public class BankConcurrentProblem {

	private int money;
	private String account;

	public BankConcurrentProblem(int money, String account) {
		this.money = money;
		this.account = account;
	}

	//deposith 과  withdraw에 여러 스레드가 접근시 공유자원 문제가 발생할 수 있다.
	public void deposit(int money) {
		money += money;
	}

	public boolean withdraw(int money) {
		if (this.money > money) {
			this.money -= money;
			return true;
		} else {
			return false;
		}
	}

	public String getAccount() {
		return this.account;
	}
}
