package tdd.kata.potter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BookStoreCheckout {

  private static final BigDecimal DISCOUNT_RATE_TWO_BOOKS = new BigDecimal("0.05");
  private static final BigDecimal DISCOUNT_RATE_THREE_BOOKS = new BigDecimal("0.10");
  private static final BigDecimal BOOK_FULL_PRICE = new BigDecimal("8");

  private Map<String, Integer> items = new HashMap<String, Integer>();

  public void buy(String isbn) {
    Integer itemCount = items.get(isbn);
    if (itemCount == null) {
      itemCount = 0;
    }
    items.put(isbn, itemCount + 1);
  }

  public BigDecimal total() {
    BigDecimal total = BigDecimal.ZERO;

    total = calculateFullPrice(total);
    total = applyDiscount(total);

    return total;
  }

  private BigDecimal calculateFullPrice(BigDecimal total) {
    for (Map.Entry<String, Integer> item : items.entrySet()) {
      BigDecimal sameBookFullPrice = new BigDecimal(item.getValue());

      total = total.add(sameBookFullPrice.multiply(BOOK_FULL_PRICE));
    }
    return total;
  }

  private BigDecimal applyDiscount(BigDecimal total) {
    if (items.size() == 2) {
      BigDecimal discount = total.multiply(DISCOUNT_RATE_TWO_BOOKS);

      total = total.subtract(discount);
    } else if (items.size() == 3) {
      BigDecimal discount = total.multiply(DISCOUNT_RATE_THREE_BOOKS);

      total = total.subtract(discount);
    }
    return total;
  }

}
