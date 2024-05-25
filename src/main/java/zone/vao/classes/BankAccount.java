package zone.vao.classes;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
  private double balance;
  private final Lock lock = new ReentrantLock();

  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public void deposit(double amount) {
    lock.lock();
    try {
      if (amount > 0) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", new balance: " + balance);
      }
    } finally {
      lock.unlock();
    }
  }

  public void withdraw(double amount) {
    lock.lock();
    try {
      if (amount > 0 && balance >= amount) {
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", new balance: " + balance);
      }
    } finally {
      lock.unlock();
    }
  }

  public double getBalance() {
    return balance;
  }
}
