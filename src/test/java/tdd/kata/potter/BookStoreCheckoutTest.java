package tdd.kata.potter;

import static org.junit.Assert.assertEquals;

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
    assertEquals(0, store.total());
  }

  @Test
  public void buyingOneBookMustReturnPriceOf8Euro() {
    store.buy();

    assertEquals(8, store.total());
  }

  @Test
  public void buyingTwoDifferentBooksMustApply5PercentDiscountReturnPriceOf15_20Euro() {
    store.buy();
    store.buy();

    assertEquals(15.20, store.total(), 0.1);
  }
}
