package tdd.kata.potter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BookStoreCheckout {

  private static final BigDecimal DISCOUNT_RATE_TWO_BOOKS = new BigDecimal("0.05");
  private static final BigDecimal DISCOUNT_RATE_THREE_BOOKS = new BigDecimal("0.10");
  private static final BigDecimal DISCOUNT_RATE_FOUR_BOOKS = new BigDecimal("0.20");
  private static final BigDecimal DISCOUNT_RATE_FIVE_BOOKS = new BigDecimal("0.25");
  private static final BigDecimal BOOK_FULL_PRICE = new BigDecimal("8.00");

  private Map<String, Integer> items = new HashMap<String, Integer>();

  public void buy(String isbn) {
    Integer itemCount = items.get(isbn);
    if (itemCount == null) {
      itemCount = 0;
    }
    items.put(isbn, itemCount + 1);
  }

  public BigDecimal total() {
    BigDecimal fullPrice = calculateFullPrice();
    BigDecimal discountPrice = calculateDiscountPrice();

    return fullPrice.subtract(discountPrice);
  }

  private BigDecimal calculateFullPrice() {
    BigDecimal total = BigDecimal.ZERO;
    for (Map.Entry<String, Integer> item : items.entrySet()) {
      BigDecimal noOfSameBooks = new BigDecimal(item.getValue());
      BigDecimal sameBookFullPrice = BOOK_FULL_PRICE.multiply(noOfSameBooks);

      total = total.add(sameBookFullPrice);
    }
    return total;
  }

  private BigDecimal calculateDiscountPrice() {
    BigDecimal discountRate = getDiscountRate(items.size());
    BigDecimal discountPrice = BOOK_FULL_PRICE.multiply(new BigDecimal(items.size()));

    return discountPrice.multiply(discountRate);
  }

  private BigDecimal getDiscountRate(int noOfDifferentBooks) {
    switch (noOfDifferentBooks) {
    case 2:
      return DISCOUNT_RATE_TWO_BOOKS;
    case 3:
      return DISCOUNT_RATE_THREE_BOOKS;
    case 4:
      return DISCOUNT_RATE_FOUR_BOOKS;
    case 5:
      return DISCOUNT_RATE_FIVE_BOOKS;
    default:
      return BigDecimal.ZERO;
    }
  }

}
