package tdd.kata.potter;

public class BookStoreCheckout {

  private int items = 0;

  public void buy() {
    items += 1;
  }

  public double total() {
    double total = items * 8;
    if (items == 2) {
      total = total - (total * 0.05);
    }
    return total;
  }

}
