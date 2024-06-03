package test.facade;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import patterns.facade.OrderUtil;
import patterns.facade.ProductNotFoundException;

public class OrderUtilTest {
    @Test
    public void test_onValidId_orderIsReturned() {
        assertDoesNotThrow(() -> OrderUtil.order(25));
    }

    @Test
    public void test_onInvalidId_ExceptionIsThrown() {
        assertThrows(ProductNotFoundException.class, () -> OrderUtil.order(200));
    }
}
