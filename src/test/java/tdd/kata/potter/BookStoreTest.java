package tdd.kata.potter;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class BookStoreTest {

  @Test
  public void buyingOneBookMustReturnPriceOf8Euro() {
    BookStore store = new BookStore();
    store.buy();

    assertEquals(new BigDecimal(8), store.total());
  }
}
