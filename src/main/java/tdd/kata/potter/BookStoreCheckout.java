package tdd.kata.potter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BookStoreCheckout {

  private static final BigDecimal DISCOUNT_RATE_TWO_BOOKS = new BigDecimal("0.05");
  private static final BigDecimal DISCOUNT_RATE_THREE_BOOKS = new BigDecimal("0.10");
  private static final BigDecimal DISCOUNT_RATE_FOUR_BOOKS = new BigDecimal("0.20");
  private static final BigDecimal DISCOUNT_RATE_FIVE_BOOKS = new BigDecimal("0.25");
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
    BigDecimal discount = BigDecimal.ZERO;

    BigDecimal discountRate = getDiscountRate(items.size());
    if (discountRate != null) {
      discount = total.multiply(discountRate);
    }

    return total.subtract(discount);
  }

  private BigDecimal getDiscountRate(int noOfUniqueItems) {
    switch (noOfUniqueItems) {
    case 2:
      return DISCOUNT_RATE_TWO_BOOKS;
    case 3:
      return DISCOUNT_RATE_THREE_BOOKS;
    case 4:
      return DISCOUNT_RATE_FOUR_BOOKS;
    case 5:
      return DISCOUNT_RATE_FIVE_BOOKS;
    default:
      return null;
    }
  }

}
