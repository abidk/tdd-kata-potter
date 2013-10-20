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
  public void buyingTwoDifferentBooksMustApply5PercentDiscountReturnPriceOf15_20Euro() {
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
}
