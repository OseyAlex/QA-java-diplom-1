package praktikum.burger_tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetReceiptTest {
    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void init() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
    }


    @Test
    @DisplayName("Проверка метода getReceipt")
    public void checkGetReceiptTestTest() {

        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(ingredient.getName()).thenReturn("кетчуп");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(55F);

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "Булка"));
        expectedReceipt.append(String.format("= %s %s =%n", "sauce", "кетчуп"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "Булка"));
        expectedReceipt.append(String.format("%nPrice: %f%n", 55.F));

        assertEquals("Не совпадает", expectedReceipt.toString(), burger.getReceipt());
    }
}
