package test.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import patterns.singleton.Trimmer;

public class TrimmerTest {
    @Test
    void test_TrimmerGivesOutSameObject() {
        assertEquals(Trimmer.getInstance(),  Trimmer.getInstance());
    }
}
