package pipboss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class IntBoolPairTest {

    @Test
    void TestConstructor() {
        IntBoolPair pear = new IntBoolPair(1, true);
        assertThat(pear.getInt(), is(1));
        assertThat(pear.getBool(), is(true));
    }
}
