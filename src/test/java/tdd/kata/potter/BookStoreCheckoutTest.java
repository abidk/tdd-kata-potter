package tdd.kata.potter;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BookStoreCheckoutTest {

  private BookStoreCheckout store;

  @Before
  public void setUp() {
    store = new BookStoreCheckout();
  }

  @Test
  public void buyingZeroBooksMustReturnPriceOf0Euro() {
    assertEquals(new BigDecimal("0.00"), store.total());
  }

  @Test
  public void buyingOneBookMustReturnPriceOf8Euro() {
    store.buy("1");

    assertEquals(new BigDecimal("8.00"), store.total());
  }

  @Test
  public void buyingTwoDifferentBooksMustApply5PercentDiscountAndReturnPriceOf15_20Euro() {
    store.buy("1");
    store.buy("2");

    assertEquals(new BigDecimal("15.2000"), store.total());
  }

  @Test
  public void buyingTwoSameBooksMustReturnPriceOf16Euro() {
    store.buy("1");
    store.buy("1");

    assertEquals(new BigDecimal("16.00"), store.total());
  }

  @Test
  public void buyingThreeDifferentBooksMustApply10PercentDiscountAndReturnPriceOf21_60Euro() {
    store.buy("1");
    store.buy("2");
    store.buy("3");

    assertEquals(new BigDecimal("21.6000"), store.total());
  }

  @Test
  public void buyingFourDifferentBooksMustApply20PercentDiscountAndReturnPriceOf25_60Euro() {
    store.buy("1");
    store.buy("2");
    store.buy("3");
    store.buy("4");

    assertEquals(new BigDecimal("25.6000"), store.total());
  }

  @Test
  public void buyingFiveDifferentBooksMustApply25PercentDiscountAndReturnPriceOf30Euro() {
    store.buy("1");
    store.buy("2");
    store.buy("3");
    store.buy("4");
    store.buy("5");

    assertEquals(new BigDecimal("30.0000"), store.total());
  }

  @Test
  public void buyingFourBooksWithTwoSameMustApplyDiscountAndReturnPriceOf29_60Euro() {
    store.buy("1");
    store.buy("2");
    store.buy("3");
    store.buy("3");

    assertEquals(new BigDecimal("29.6000"), store.total());
  }

}
