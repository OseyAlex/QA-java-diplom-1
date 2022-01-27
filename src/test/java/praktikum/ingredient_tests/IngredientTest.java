package praktikum.ingredient_tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void init() {
        ingredient = new Ingredient(SAUCE, "Кетчуп", 5);
    }

    @Test
    @DisplayName("Проверка метода getName")
    public void ingredientGetNameTest() {
        assertEquals("Кетчуп", ingredient.getName());
    }

    @Test
    @DisplayName("Проверка метода getPrice")
    public void ingredientGetPriceTest() {
        assertEquals(5, ingredient.getPrice(), 0);
    }

    @Test
    @DisplayName("Проверка метода getType")
    public void ingredientGetTypeTest() {
        assertEquals(SAUCE, ingredient.getType());
    }
}
