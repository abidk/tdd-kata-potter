package tdd.kata.potter;

import java.math.BigDecimal;

public class BookStoreCheckout {

  private static final double DISCOUNT_RATE_TWO_BOOKS = 0.05;
  private static final int BOOK_FULL_PRICE = 8;

  private int items = 0;

  public void buy() {
    items += 1;
  }

  public BigDecimal total() {
    double total = items * BOOK_FULL_PRICE;

    total = applyDiscount(total);

    return new BigDecimal(total);
  }

  private double applyDiscount(double total) {
    if (items == 2) {
      total = total - (total * DISCOUNT_RATE_TWO_BOOKS);
    }
    return total;
  }

}
