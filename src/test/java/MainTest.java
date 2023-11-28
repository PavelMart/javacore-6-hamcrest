import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int[] productsCount = new int[]{1, 0 ,0, 0};

    @Test
    void createShoppingCartTest() {
        String[] shoppingCart = Main.createShoppingCart(productsCount);
        assertThat("Молоко 1 шт 50 руб/шт 50 руб в сумме", isIn(shoppingCart));
    }

    @Test
    void calculateResultTest() {
        Integer expected = 50;
        Integer result = Main.calculateResult(productsCount);
        assertThat(expected, equalTo(result));
    }
}