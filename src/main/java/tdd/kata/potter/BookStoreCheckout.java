package tdd.kata.potter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BookStoreCheckout {

  private static final BigDecimal DISCOUNT_RATE_TWO_BOOKS = new BigDecimal("0.05");
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

    for (Map.Entry<String, Integer> item : items.entrySet()) {
      BigDecimal sameSetPrice = calculateBookSetPrice(item.getValue());

      total = total.add(sameSetPrice);
    }

    total = applyDiscount(total);

    return total;
  }

  private BigDecimal calculateBookSetPrice(int noOfSameBooks) {
    BigDecimal setPrice = new BigDecimal(noOfSameBooks);
    return setPrice.multiply(BOOK_FULL_PRICE);
  }

  private BigDecimal applyDiscount(BigDecimal total) {
    if (items.size() == 2) {
      BigDecimal discount = total.multiply(DISCOUNT_RATE_TWO_BOOKS);

      total = total.subtract(discount);
    }
    return total;
  }

}
