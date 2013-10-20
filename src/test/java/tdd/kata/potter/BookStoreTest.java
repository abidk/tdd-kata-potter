package tdd.kata.potter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BookStoreTest {

  private BookStore store;

  @Before
  public void setUp() {
    store = new BookStore();
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
}
