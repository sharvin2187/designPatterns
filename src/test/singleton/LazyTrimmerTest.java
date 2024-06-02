package test.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import patterns.singleton.LazyTrimmer;

public class LazyTrimmerTest {
    @Test
    void test_LazyTrimmerGivesOutSameObject() {
        assertEquals(LazyTrimmer.getInstance(),  LazyTrimmer.getInstance());
    }
}
