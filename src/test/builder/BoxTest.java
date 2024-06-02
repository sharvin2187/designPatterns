package test.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import patterns.builder.Box;

public class BoxTest {
    @Test
    void test_paramsAreSetCorrectly() {
        int l = 1, b = 2, h = 3;
        Box box = Box.builder()
                .setLength(l)
                .setBreadth(b)
                .setHeight(h)
                .build();
        assertEquals(l, box.length);
        assertEquals(b, box.breadth);
        assertEquals(h, box.height);
    }
}
