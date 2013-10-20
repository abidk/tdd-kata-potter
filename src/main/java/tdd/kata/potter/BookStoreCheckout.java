package tdd.kata.potter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BookStoreCheckout {

  private static final double DISCOUNT_RATE_TWO_BOOKS = 0.05;
  private static final int BOOK_FULL_PRICE = 8;

  private Map<String, Integer> items = new HashMap<String, Integer>();

  public void buy(String isbn) {
    Integer itemCount = items.get(isbn);
    if (itemCount == null) {
      itemCount = 0;
    }
    items.put(isbn, itemCount + 1);
  }

  public BigDecimal total() {
    double total = 0;

    for (Map.Entry<String, Integer> item : items.entrySet()) {
      total += item.getValue() * BOOK_FULL_PRICE;
    }

    total = applyDiscount(total);

    return new BigDecimal(total);
  }

  private double applyDiscount(double total) {
    if (items.size() == 2) {
      total = total - (total * DISCOUNT_RATE_TWO_BOOKS);
    }
    return total;
  }

}
