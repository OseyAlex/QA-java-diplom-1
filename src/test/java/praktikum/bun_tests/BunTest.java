package praktikum.bun_tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void init() {
        bun = new Bun("Булка", 60);
    }

    @Test
    @DisplayName("Проверка метода getName")
    public void bunGetNameTest() {
        assertEquals("Булка", bun.getName());
    }

    @Test
    @DisplayName("Проверка метода getPrice")
    public void bunGetPriceTest() {
        assertEquals(60, bun.getPrice(), 0);
    }
}
