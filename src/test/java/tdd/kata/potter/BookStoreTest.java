package tdd.kata.potter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BookStoreTest {

  @Test
  public void buyingZeroBooksMustReturnPriceOf0() {
    BookStore store = new BookStore();

    assertEquals(0, store.buy());
  }
}
