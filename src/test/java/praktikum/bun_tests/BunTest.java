package praktikum.bun_tests;

import jdk.jfr.Name;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void init() {
        bun = new Bun("Булка", 60);
    }

    @Test
    @Name("Проверка метода getName")
    public void bunGetNameTest() {
        assertEquals("Булка", bun.getName());
    }

    @Test
    @Name("Проверка метода getPrice")
    public void bunGetPriceTest() {
        assertEquals(60, bun.getPrice(), 0);
    }
}
