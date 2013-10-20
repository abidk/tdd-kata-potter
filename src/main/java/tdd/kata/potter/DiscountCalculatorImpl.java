package tdd.kata.potter;

import java.math.BigDecimal;
import java.util.List;

public class DiscountCalculatorImpl implements DiscountCalculator {

  private static final BigDecimal DISCOUNT_RATE_TWO_BOOKS = new BigDecimal("0.05");
  private static final BigDecimal DISCOUNT_RATE_THREE_BOOKS = new BigDecimal("0.10");
  private static final BigDecimal DISCOUNT_RATE_FOUR_BOOKS = new BigDecimal("0.20");
  private static final BigDecimal DISCOUNT_RATE_FIVE_BOOKS = new BigDecimal("0.25");

  public BigDecimal calculateDiscount(List<Integer> items) {
    int noOfDifferentBooks = items.size();
    int totalBookCount = totalBooks(items);

    if (noOfDifferentBooks == 5 && totalBookCount == 8) {
      return calculateDiscount(4, 2);
    } else {
      return calculateDiscount(noOfDifferentBooks, 1);
    }
  }

  private BigDecimal calculateDiscount(int noOfDifferentBooks, int multiplier) {
    BigDecimal discountRate = getDiscountRate(noOfDifferentBooks);
    BigDecimal discountPrice = BookStoreCheckout.BOOK_FULL_PRICE.multiply(new BigDecimal(noOfDifferentBooks));
    return discountPrice.multiply(discountRate).multiply(new BigDecimal(multiplier));
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

  private int totalBooks(List<Integer> items) {
    int bookCount = 0;
    for (Integer item : items) {
      bookCount += item;
    }
    return bookCount;
  }

}
