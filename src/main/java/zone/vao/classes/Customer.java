package zone.vao.classes;

import java.util.Random;

public class Customer implements Runnable {
  private final BankAccount account;

  public Customer(BankAccount account) {
    this.account = account;
  }

  @Override
  public void run() {
    Random random = new Random();
    for (int i = 0; i < 5; i++) {
      if (random.nextBoolean()) {
        account.deposit(random.nextInt(100));
      } else {
        account.withdraw(random.nextInt(50));
      }
      try {
        Thread.sleep(random.nextInt(1000));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}

