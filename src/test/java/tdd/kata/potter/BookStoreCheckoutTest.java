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
    assertEquals(BigDecimal.ZERO, store.total());
  }

  @Test
  public void buyingOneBookMustReturnPriceOf8Euro() {
    store.buy("1");

    assertEquals(new BigDecimal("8"), store.total());
  }

  @Test
  public void buyingTwoDifferentBooksMustApply5PercentDiscountAndReturnPriceOf15_20Euro() {
    store.buy("1");
    store.buy("2");

    assertEquals(new BigDecimal("15.20"), store.total());
  }

  @Test
  public void buyingTwoSameBooksMustReturnPriceOf16Euro() {
    store.buy("1");
    store.buy("1");

    assertEquals(new BigDecimal("16"), store.total());
  }

  @Test
  public void buyingThreeDifferentBooksMustApply10PercentDiscountAndReturnPriceOf21_60Euro() {
    store.buy("1");
    store.buy("2");
    store.buy("3");

    assertEquals(new BigDecimal("21.60"), store.total());
  }

  @Test
  public void buyingFourDifferentBooksMustApply20PercentDiscountAndReturnPriceOf25_60Euro() {
    store.buy("1");
    store.buy("2");
    store.buy("3");
    store.buy("4");

    assertEquals(new BigDecimal("25.60"), store.total());
  }
  
  @Test
  public void buyingFiveDifferentBooksMustApply25PercentDiscountAndReturnPriceOf30Euro() {
    store.buy("1");
    store.buy("2");
    store.buy("3");
    store.buy("4");
    store.buy("5");

    assertEquals(new BigDecimal("30.00"), store.total());
  }
}
