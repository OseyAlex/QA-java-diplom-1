package praktikum.ingredient_tests;

import jdk.jfr.Name;
import org.junit.Before;
import org.junit.Test;
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
    @Name("Проверка метода getName")
    public void ingredientGetNameTest() {
        assertEquals("Кетчуп", ingredient.getName());
    }

    @Test
    @Name("Проверка метода getPrice")
    public void ingredientGetPriceTest() {
        assertEquals(5, ingredient.getPrice(), 0);
    }

    @Test
    @Name("Проверка метода getType")
    public void ingredientGetTypeTest() {
        assertEquals(SAUCE, ingredient.getType());
    }
}
